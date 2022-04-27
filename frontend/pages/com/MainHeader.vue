<template>
  <div>
    <header-nav :cateList="cateList"/>
  </div>
</template>

<script>
import HeaderNav from '~/components/com/nav/HeaderNav.vue';
import CateApi from "@/util/api/cate-api";

export default {
  components: {HeaderNav},

  async created() {
    this.cateList = await CateApi.getDispCateList();
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
