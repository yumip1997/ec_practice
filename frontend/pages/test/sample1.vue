<template>
<div>
  <el-container class="page_body">
    sample1 페이지 컴퍼넌트
    {{prdList}}
  </el-container>
</div>
</template>

<script>
import ProductApi from "../../util/api/product/product-api";

export default {
  name: "sample1",
  async fetch(){
    const cateId = this.$route.query.cateId;
    const prdList = await ProductApi.getPrdListByCate(cateId);
    this.prdList = prdList;
  },
  data(){
    return {
      prdList : [],
    }
  }
}
</script>

<style scoped>
.page_body {
  text-align: center;
}
</style>
