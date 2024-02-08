<script>
import { userSession} from "@/stores/sessionStore.js";
import router from "@/router/index.js";

export default {
  data: () => ({
    username: "",
    password: "",
  }),
  methods: {
    login() {
      console.log(userSession().login(this.username, this.password))

      if (userSession().$state.accessToken){
        router.push("/home")
      } else {
        router.push("/login?error=true")
      }
    }
  }
}
</script>

<template>
  <div class="columns is-centered">
    <div class="column is-4-desktop">
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
            <input class="input" v-model="password" type="password" placeholder="Contraseña">
          </div>
        </div>

        <div class="field is-grouped">
          <div class="control">
            <button class="button is-link">Submit</button>
          </div>
          <div class="control">
            <button class="button is-link is-light">Cancel</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>

</style>