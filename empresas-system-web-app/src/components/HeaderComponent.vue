<script setup>

</script>

<template>
  <header>
    <nav class="navbar has-background-primary-light" role="navigation" aria-label="main navigation">
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
            <div class="buttons">
              <RouterLink class="button is-primary" to="/register">
                <strong>Registrarse</strong>
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