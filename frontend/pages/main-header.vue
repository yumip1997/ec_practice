<template>
  <div>
    <header-nav :cateList="cateList"/>
  </div>
</template>

<script>
import HeaderNav from '~/components/com/nav/HeaderNav.vue';
import CateApi from "~/util/api/category/cate-api";

export default {
  components: {HeaderNav},

  async asyncData(){
    const cateList = await CateApi.getDispCateList();
    return {
      cateList,
    }
  },

  data(){
    return {
      cateList : [],
    }
  }
}
</script>

<style>

</style>
