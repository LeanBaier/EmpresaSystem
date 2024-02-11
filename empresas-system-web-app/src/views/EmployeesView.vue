<script>
import {userSession} from "@/stores/sessionStore.js";
import {BIconPencilSquare, BIconTrash3} from "bootstrap-icons-vue";

export default {
  data: () => ({
    employees: [],
    filters: {
      name: '',
      lastname: '',
      lowerBirthdate: '',
      higherBirthdate: '',
      lowerRegistrationDate: '',
      higherRegistrationDate: '',
    },
    pageOptions: {
      actualPage: 1,
      size: 10,
      hasNextPage: true,
      hasPreviousPage: true,
      totalPages: 0,
      totalRecords: 0,
    },
    loadingPage: true
  }),
  components: {
    BIconTrash3,
    BIconPencilSquare
  },
  mounted() {
    this.fetchEmployees(1)
  },
  methods: {
    async fetchEmployees(page) {
      this.loadingPage = true
      let searchParams = new URLSearchParams()
      searchParams.append('page', page)
      searchParams.append('size', this.pageOptions.size)
      if (this.filters.name) {
        searchParams.append('name', this.filters.name)
      }
      if (this.filters.lastname) {
        searchParams.append('lastname', this.filters.lastname)
      }
      if (this.filters.lowerBirthdate) {
        searchParams.append('birthdateSince', this.filters.lowerBirthdate)
      }
      if (this.filters.higherBirthdate) {
        searchParams.append('birthdateUntil', this.filters.higherBirthdate)
      }
      if (this.filters.lowerRegistrationDate) {
        searchParams.append('registrationDateSince', this.filters.lowerRegistrationDate)
      }
      if (this.filters.higherRegistrationDate) {
        searchParams.append('registrationDateUntil', this.filters.higherRegistrationDate)
      }
      let sessionToken = await userSession().accessToken
      await fetch("/api-employees/api/v1/employees/search?" + searchParams.toString(), {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': sessionToken
        },
      }).then(async (result) => {
        result = await result.json()
        this.employees = result.data
        this.pageOptions.totalPages = result.totalPages
        this.pageOptions.totalRecords = result.totalRecords
        this.pageOptions.hasNextPage = result.totalPages > page
        this.pageOptions.hasPreviousPage = page > 1
        this.pageOptions.actualPage = page
        this.loadingPage = false
      }).catch((e) => console.log(e))
    },
  }
}
</script>
<template>
  <div class="container">
    <div class="columns m-1">
      <div class="column is-2-desktop mt-6">
        <div class="container mb-6">
          <RouterLink to="/employees/new" class="button is-info is-outlined is-fullwidth">Alta Empleado
          </RouterLink>
        </div>
        <form @submit.prevent="fetchEmployees(1)">
          <div class="field">
            <label class="label">Registros por Página</label>
            <div class="control">
              <input class="input" v-model="pageOptions.size" type="number">
            </div>
          </div>
          <div class="field">
            <label class="label">Nombre</label>
            <div class="control">
              <input class="input" v-model="filters.name" type="text" placeholder="Nombre">
            </div>
          </div>
          <div class="field">
            <label class="label">Apellido</label>
            <div class="control">
              <input class="input" v-model="filters.lastname" type="text" placeholder="Apellido">
            </div>
          </div>
          <div class="field">
            <label class="label">Fecha Nacimiento</label>
            <div class="control">
              <input class="input mb-1" v-model="filters.lowerBirthdate" type="date">
              <input class="input" v-model="filters.higherBirthdate" type="date">
            </div>
          </div>
          <div class="field">
            <label class="label">Fecha Registro</label>
            <div class="control">
              <input class="input mb-1" v-model="filters.lowerRegistrationDate" type="date">
              <input class="input" v-model="filters.higherRegistrationDate" type="date">
            </div>
          </div>
          <div class="field mt-5">
            <button type="submit" :class="{'is-loading': loadingPage}" class="button is-primary is-fullwidth">Buscar
            </button>
          </div>
        </form>
      </div>
      <div class="column mt-5">
        <div class="container mb-3">
          <table class="table is-striped is-hoverable is-fullwidth" aria-label="Tabla de empleados">
            <thead>
            <tr>
              <th>Legajo</th>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>Nacimiento</th>
              <th>Fecha Alta</th>
              <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="employee in employees">
              <td> {{ employee.idEmployee }}</td>
              <td> {{ employee.name }}</td>
              <td> {{ employee.lastname }}</td>
              <td> {{ new Date(employee.birthdate).toLocaleDateString() }}</td>
              <td> {{ new Date(employee.registrationDate).toLocaleDateString() }}</td>
              <td class="mgr-small">
                <div class="buttons">
                  <button class="button is-small is-danger is-outlined">
                    <BIconTrash3></BIconTrash3>
                  </button>
                  <button class="button is-small is-info is-outlined">
                    <BIconPencilSquare></BIconPencilSquare>
                  </button>
                </div>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="container">
          <nav class="pagination is-centered is-rounded" role="navigation" aria-label="pagination">
            <button @click="fetchEmployees(pageOptions.actualPage - 1)" type="button"
                    :disabled="!pageOptions.hasPreviousPage || loadingPage"
                    v-bind:class="{'is-disabled': !pageOptions.hasPreviousPage || loadingPage}"
                    class="pagination-previous">Anterior
            </button>
            <button @click="fetchEmployees(pageOptions.actualPage + 1)" type="button"
                    :disabled="!pageOptions.hasNextPage || loadingPage"
                    v-bind:class="{'is-disabled': !pageOptions.hasNextPage || loadingPage}" class="pagination-next">
              Proxima
            </button>
            <ul class="pagination-list">
              <li>
                <button @click="fetchEmployees(1)" :class="{'is-disabled': loadingPage}" class="pagination-link"
                        aria-label="Goto page 1">1
                </button>
              </li>
              <li><span class="pagination-ellipsis">&hellip;</span></li>
              <li v-if="pageOptions.hasPreviousPage">
                <button type="button" :class="{'is-disabled': loadingPage}"
                        @click="fetchEmployees(pageOptions.actualPage - 1)" class="pagination-link">{{
                    pageOptions.actualPage - 1
                  }}
                </button>
              </li>
              <li>
                <button type="button" @click="fetchEmployees(pageOptions.actualPage)"
                        :class="{'is-disabled': loadingPage}"
                        class="pagination-link is-current  ">{{ pageOptions.actualPage }}
                </button>
              </li>
              <li v-if="pageOptions.hasNextPage">
                <button type="button" @click="fetchEmployees(pageOptions.actualPage + 1)" class="pagination-link"
                        :class="{'is-disabled': loadingPage}">
                  {{ pageOptions.actualPage + 1 }}
                </button>
              </li>
              <li><span class="pagination-ellipsis">&hellip;</span></li>
              <li>
                <button type="button" @click="fetchEmployees(pageOptions.totalPages)" class="pagination-link"
                        :class="{'is-disabled': loadingPage}">
                  {{ pageOptions.totalPages }}
                </button>
              </li>
            </ul>
          </nav>
        </div>
      </div>

    </div>
  </div>
</template>