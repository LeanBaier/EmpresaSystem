<script>
export default {
  data: () => ({
    username: '',
    password: '',
    email: '',
  }),
  actions: {
    register(){

    }
  }

}
</script>

<template>
  <form>
    <div class="columns is-centered">
      <div class="column is-4-desktop m-6">

        <div class="field">
          <label class="label">Usuario</label>
          <div class="control ">
            <input class="input" v-bind="username" type="text" placeholder="Usuario">
          </div>
        </div>

        <div class="field">
          <label class="label">Email</label>
          <div class="control">
            <input class="input" type="email" v-bind="email" placeholder="Email">
          </div>
        </div>

        <div class="field">
          <label class="label">Contraseña</label>
          <div class="control">
            <input class="input" type="text" v-bind="password" placeholder="Contraseña">
          </div>
        </div>
      </div>
    </div>
  </form>
</template>