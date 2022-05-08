<template>
  <div>
    상세페이지~
    {{prd}}
  </div>
</template>

<script>

import ProductApi from "../../util/api/product/product-api";

export default {
  async asyncData({route}){
    const prdId = route.params.prdId;
    const prd  = await ProductApi.getPrdDtl(prdId);
    return {
      prd
    }
  },
  data(){
    return{
      prd : {}
    }
  }

}
</script>

<style>

</style>
