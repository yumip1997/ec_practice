<template>
  <div>
    <h4 class="page_title">카테고리 {{ $route.query.label || '전체' }}의 상품 리스트 영역</h4>
    <el-row :gutter="20">
      <el-col :span="12" :offset="6">
        <product-card class="page_body_content" :prdList="prdList"/>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import ProductCard from '~/components/product/ProductCard.vue'
import ProductApi from '~/util/api/product-api'
import {getProductMetaInfo} from "~/util/metaInfo/product-meta";

export default {
  components: {ProductCard},
  data() {
    return {
      prdList: [],
    }
  },
  watch: {
    async '$route.query'() {
      await this.initPrdListByCate();
    }
  },
  async created() {
    await this.initPrdListByCate();
  },
  methods: {
    async initPrdListByCate() {
      const cateId = this.$route.query.cateId;
      this.prdList = await this.getPrdListByCate(cateId);
    },
    async getPrdListByCate(cateId) {
      const prdList = await ProductApi.getPrdListByCate(cateId);
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
.page_body_content {
  text-align: center;
}

.page_title {
  padding-top: 20px;
  text-align: center;
  color: gray;
}
</style>
