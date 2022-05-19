<template>
<div>
  상품리스트..
</div>
</template>

<script>
export default {
  name: "index",

  asyncData(){
    console.log(`${process.server}` ===  'true' ? "server" : "client");
    console.log("product asyncData");
  },

  async fetch(){
    console.log(`${process.server}` ===  'true' ? "server" : "client");
    console.log("proudct fetch");
  },
}
</script>

<style scoped>

</style>
