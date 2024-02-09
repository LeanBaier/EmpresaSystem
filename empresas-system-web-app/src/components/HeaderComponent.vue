<script>
import {userSession} from "@/stores/sessionStore.js";
import router from "@/router/index.js";
import {useRoute} from "vue-router";

export default {
  data: () => ({
    sessionActive: false
  }),
  mounted() {
    this.sessionActive = userSession().getAccessToken
    if (!this.sessionActive) {
      if (useRoute().path !== '/register') {
        router.push('/login')
      }
    }
  },
}

</script>

<template>
  <header>
    <nav class="navbar is-primary" role="navigation" aria-label="main navigation">
      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <RouterLink class="navbar-item" to="/home">
            Inicio
          </RouterLink>
          <RouterLink class="navbar-item" to="/employees">
            Empleados
          </RouterLink>
        </div>

        <div class="navbar-end">
          <div class="navbar-item">
            <div class="buttons" v-if="sessionActive">
              <RouterLink class="button is-outlined" to="/logout">
                Salir
              </RouterLink>
            </div>
            <div class="buttons" v-else>
              <RouterLink class="button is-light" to="/register">
                Registrarse
              </RouterLink>
              <RouterLink class="button is-light" to="/login">
                Ingresar
              </RouterLink>
            </div>
          </div>
        </div>
      </div>
    </nav>
  </header>
</template>

<style scoped>

</style>