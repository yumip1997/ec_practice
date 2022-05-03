<template>
  <div>
    <header-nav :cateList="cateList"/>
  </div>
</template>

<script>
//routing으로 그려지는 화면이 아님 -> asyncData 호출x
//pages폴더 아래 있는 컴포넌트는 무조건 asyncData을 호출하는 것이 아니라
//pages 폴더 아래 있는 컴포넌트가 routing 대상 컴포넌트로 자동등록되기에, routing 될 경우에만 asyncData 호출
import HeaderNav from '~/components/com/nav/HeaderNav.vue';
import CateApi from "~/util/api/category/cate-api";

export default {
  components: {HeaderNav},

  //TODO fetch에서 호출하면 virturl dom이랑 일치하지 않는 이유 알기
  async fetch(){
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
