<template>
  <div>
    {{$route.query.prdNo}}
  </div>
</template>

<script>

export default {
  async asyncData({$axios}){
    const {data} = await $axios.get('/api/prd?prdId=4');
  }
}
</script>

<style>

</style>
