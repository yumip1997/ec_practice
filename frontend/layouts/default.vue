<template>
<div>
  <main-header/>
  <Nuxt/>
</div>
</template>

<script>
import MainHeader from "../pages/MainHeader.vue"

export default {
  components :{
    MainHeader,
  },
  name: "defaultLayout"
}
</script>


<style scoped>

</style>, MainHeader