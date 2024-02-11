<script>
import {userSession} from "@/stores/sessionStore.js";
import router from "@/router/index.js";

export default {
  data: () => ({
    name: '',
    lastname: '',
    birthdate: '',
    errorName: '',
    errorLastname: '',
    errorBirthdate: '',
    textInputOptions: {format: 'dd/MM/yyyy'},
    created: false,
    loading: false,
  }),
  updated() {
    if (this.created) {
      router.push('/employees')
    }
  },
  methods: {
    async createEmployee() {
      this.loading = true
      if (!this.name) {
        this.errorName = 'Debe ingresar un nombre'
      } else {
        this.errorName = ''
      }
      if (!this.lastname) {
        this.errorLastname = 'Debe ingresar el apellido'
      } else {
        this.errorLastname = ''
      }
      if (!this.birthdate) {
        this.errorBirthdate = 'Debe seleccionar una fecha de nacimiento'
      } else {
        this.errorLastname = ''
      }
      if (this.errorName || this.errorLastname || this.errorBirthdate) {
        this.loading = false
        return
      }
      let birthdate = this.birthdate
      let data = {
        name: this.name,
        lastname: this.lastname,
        birthdate: birthdate.getDate() + "-" + birthdate.getMonth() + "-" + birthdate.getFullYear()
      }
      let headers = new Headers()
      headers.append("Authorization", userSession().getAccessToken)
      headers.append('Content-Type', 'application/json')
      await fetch('/api-employees/api/v1/employees', {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(data),
      }).then(response => {
        console.log(response.ok)
        this.created = response.ok
        this.loading = false
      })
          .catch(e => console.log(e))
    }
  }
}

</script>

<template>
  <div class="columns is-centered m-6">
    <div class="column is-half-desktop">
      <form @submit.prevent="createEmployee">
        <div class="field">
          <label class="label">Nombre</label>
          <div class="control">
            <input class="input" v-model="name" type="text" placeholder="Nombre">
          </div>
          <p class="help is-danger" v-if="errorName">{{ errorName }}</p>
        </div>
        <div class="field">
          <label class="label">Apellido</label>
          <div class="control">
            <input class="input" v-model="lastname" type="text" placeholder="Apellido">
          </div>
          <p class="help is-danger" v-if="errorLastname">{{ errorLastname }}</p>
        </div>
        <div class="field">
          <label class="label">Fecha Nacimiento</label>
          <p class="help"> Ejemplo: 31/01/2024</p>
          <p class="help is-danger" v-if="errorBirthdate">{{ errorBirthdate }}</p>
          <div class="control">
            <VueDatePicker class="is-fullwidht is-primary-light" v-model="birthdate" format="dd/MM/yyyy"
                           :text-input="textInputOptions"
                           placeholder="Ingresa la fecha de nacimiento..."></VueDatePicker>
          </div>
        </div>
        <div class="field is-grouped is-grouped-right">
          <div class="control">
            <RouterLink to="/employees" class="button is-primary is-light">Cancelar</RouterLink>
          </div>
          <button class="button is-primary" :class="{'is-loading': loading}" type="submit">Guardar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>

</style>