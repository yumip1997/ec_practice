<template>
<div>
  <el-container class="page_body">
    sample1 페이지 컴퍼넌트
  </el-container>
</div>
</template>

<script>
const whoCall = () => {
  return `${process.browser}` === 'true' ?  '브라우저' : '서버';
}
export default {
  name: "sample1",
  asyncData(){
    console.log("asyncData  Hook" + whoCall());
  },
  fetch(){
    console.log("fetch hook " + whoCall());
  },
  created(){
    console.log("created hook " + whoCall());
  },
  mounted() {
    console.log("mounted hook " + whoCall());
  },
};

</script>

<style scoped>
.page_body {
  text-align: center;
}
</style>
