<template>
<div>
  <el-menu :default-active="activeIndex" mode="horizontal" @select="handleSelect">
  <el-menu-item index="1"><nuxt-link to="/">홈으로</nuxt-link></el-menu-item>
  </el-menu>
</div>
</template>

<script>
export default {
  data(){
    return {
      activeIndex : "1",
    }
  },
  methods : {
    handleSelect(index){
      this.activeIndex = index; 
    
    }
  }
}
</script>

<style>

</style>