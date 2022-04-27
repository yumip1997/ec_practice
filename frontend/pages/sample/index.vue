<template>
<div>
  <h1>라우팅 확인</h1>
  <nuxt-link to="/sample/child/sample1">샘플 페이지1</nuxt-link>
  <nuxt-link to="/sample/child/sample2">샘플 페이지2</nuxt-link>
  <nuxt-child/>
</div>
</template>

<script>
export default {
  name: "Sample"
}
</script>

<style scoped>

</style>
