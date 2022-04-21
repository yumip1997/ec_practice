<template>
<div>
  <header-nav/>
  <display-category  @getCurrentCate="getCurrentCate"/>
</div>
</template>

<script>
import DisplayCategory from '@/components/category/DisplayCategory.vue';
import HeaderNav from '@/components/nav/HeaderNav.vue';
export default {
  components: { DisplayCategory, HeaderNav },
  methods : {
    getCurrentCate(e){
      this.$router.push({name :'display-product-ProductList', query : {label : e.label, cateNo : e.cateNo}})
    },
  },
}
</script>

<style>

</style>