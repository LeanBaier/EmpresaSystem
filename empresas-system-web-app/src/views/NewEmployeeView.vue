<script>
import {userSession} from "@/stores/sessionStore.js";

export default {
  data: () => ({
    name: '',
    lastname: '',
    birthdate: '',
    created: false,
  }),
  actions: {
    createEmployee() {
      let data = {
        name: this.name,
        lastname: this.lastname,
        birthdate: this.birthdate
      }
      let headers = new Headers()
      headers.append("Authorization", userSession().getAccessToken)
      fetch('http://localhost:8080/api/v1/employees', {
        method: 'POST',
        headers: headers,
        data: data,
      }).then(response => this.created = response.ok)
          .catch(e => console.log(e))
    }
  }
}

</script>

<template>
  <div class="columns">
    <div class="column is-half-desktop">
      <form>
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
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>

</style>