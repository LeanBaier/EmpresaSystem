<script>
import {userSession} from "@/stores/sessionStore.js";
import router from "@/router/index.js";

export default {
  data: () => ({
    username: "",
    password: "",
    loading: false,
  }),
  methods: {
    async login() {
      this.loading = true
      await userSession().login(this.username, this.password)
      const session = userSession().$state.accessToken
      console.log(session)
      if (session) {
        await router.push("/home")
      } else {
        await router.push("/login?error=true")
      }
    }
  }
}
</script>

<template>
  <div class="columns is-centered ">
    <div class="column is-4-desktop m-6">
      <form @submit.prevent="login">
        <div class="field">
          <label class="label">Usuario</label>
          <div class="control">
            <input class="input" v-model="username" type="text" placeholder="Usuario">
          </div>
        </div>

        <div class="field">
          <label class="label">Contraseña</label>
          <div class="control">
            <input class="input" v-model="password" type="password"
                   placeholder="Contraseña">
          </div>
        </div>

        <div class="field is-grouped is-grouped-right ">
          <div class="control">
            <RouterLink to="/register" class="button is-primary is-light">Registrarse</RouterLink>
          </div>
          <div class="control">
            <button class="button is-primary" :class="{'is-loading': loading}">Ingresar</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>

</style>