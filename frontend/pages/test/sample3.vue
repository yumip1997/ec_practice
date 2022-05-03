<template>
  <div>
    <el-container class="page_body">
      sample3 페이지 컴퍼넌트
    </el-container>
  </div>
</template>

<script>
import CateApi from "../../util/api/category/cate-api";

export default {
  name: "sample3",
  async fetch(){
    const cateList = await CateApi.getDispCateList();
    this.cateList = cateList;
  },
  data(){
    return{
      cateList : [],
    }
  }
}
</script>

<style scoped>

</style>
