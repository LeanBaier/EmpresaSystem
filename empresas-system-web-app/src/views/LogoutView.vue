<script>
  import {userSession} from "@/stores/sessionStore.js";
  import router from "@/router/index.js";

  export default {
    mounted() {
      userSession().logout()
      router.push('/login')
    }
  }
</script>

<template>

</template>

<style scoped>

</style>