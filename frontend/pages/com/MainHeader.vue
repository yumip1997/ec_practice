<template>
  <div>
    <header-nav :cateList="cateList"/>
  </div>
</template>

<script>
import HeaderNav from '~/components/com/nav/HeaderNav.vue';
import CateApi from "~/util/api/CateApi";

export default {
  components: {HeaderNav},
  async created(){
    const cateList = await CateApi.getDispCateList();
    this.cateList = cateList;
  },
  async fetch(){

  },
  data(){
    return {
      cateList : [],
    }
  },
}
</script>

<style>

</style>
