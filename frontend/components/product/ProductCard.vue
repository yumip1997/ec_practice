<template>
<div>
  <el-row>
  <el-col :span="8" v-for="(prd, index) in prdList" :key="index">
    <el-card :body-style="{ padding: '2px' }">
      <div style="padding: 14px;">
        <span>
          <nuxt-link :to="{name : 'product-prdNo', query : {prdNo : prd.prdNo}}">
            {{prd.prdNm}}
          </nuxt-link>
        </span>
      </div>
    </el-card>
  </el-col>
</el-row>
</div>
</template>

<script>
export default {
  props : {
    prdList : Array
  },
  name: "ProductCard"
}
</script>

<style>
</style>
