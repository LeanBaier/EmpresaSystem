<script>
import {userSession} from "@/stores/sessionStore.js";
import router from "@/router/index.js";

export default {
  setup() {
    if (userSession().refreshToken){
      router.push("/login")
    }
  }
}
</script>

<template>
  <main>
    <h1>Home</h1>
  </main>
</template>
