<template>
  <div>
    카테고리 {{ $route.query.label || '전체' }}의 상품 리스트 영역
    <product-card :prdList="prdList"/>
  </div>
</template>

<script>
import ProductCard from '~/components/product/ProductCard.vue'
import PrdApi from "~/api/PrdApi";
import {getProductMetaInfo} from "../metaInfo/product-meta";

export default {
  components: {ProductCard},
  data() {
    return {
      prdList: [],
    }
  },
  watch :{
    async '$route.query' (){
      await this.initPrdListByCate();
    }
  },
  async asyncData({route}){
    console.log("실행?");
    const prdList = await PrdApi.getPrdListByCate(route.query.cateId);
    return{
      prdList : prdList
    }
  },
  methods: {
    async initPrdListByCate() {
      const cateId = this.$route.query.cateId;
      this.prdList = await this.getPrdListByCate(cateId);
    },
    async getPrdListByCate(cateId){
      const prdList = await PrdApi.getPrdListByCate(cateId);
      return prdList;
    }
  },
  head() {
    return {
      meta: getProductMetaInfo(this)
    }
  },
}
</script>

<style>

</style>
