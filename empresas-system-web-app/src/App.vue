<script setup>
import {RouterView} from 'vue-router'
import HeaderComponent from "@/components/HeaderComponent.vue";
</script>

<template>
  <HeaderComponent :key="$route.fullPath"/>
  <div class="container">
    <RouterView />
  </div>
</template>

<style scoped>
</style>
