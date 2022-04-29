<template>
  <div>
    <header-nav :cateList="cateList"/>
  </div>
</template>

<script>
import HeaderNav from '~/components/com/nav/HeaderNav.vue';
import CateApi from "~/util/api/cate-api";

export default {
  components: {HeaderNav},

  async fetch(){
    console.log("사버일까?" + `${process.server}`);
    console.log("브라우저일까?" + `${process.browser}`);
    const cateList = await CateApi.getDispCateList();
    this.cateList = cateList;
  },

  data() {
    return {
      cateList: [],
    }
  },
}
</script>

<style>

</style>
