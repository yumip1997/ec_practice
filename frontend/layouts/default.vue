<template>
<div>
  <Nuxt name="MainHeader"/>
  <Nuxt/>
  <Nuxt name="MainFooter" class="main_footer"/>
</div>
</template>

<script>
export default {
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
