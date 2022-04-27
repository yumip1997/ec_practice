<template>
<div>
  <main-header/>
  <Nuxt/>
  <main-footer class="main_footer"/>
</div>
</template>

<script>
import MainHeader from "@/pages/com/MainHeader.vue"
import MainFooter from "@/pages/com/MainFooter";

export default {
  components :{
    MainFooter,
    MainHeader,
  },
  name: "defaultLayout"
}
</script>


<style scoped>
.main_footer {
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
}
</style>
