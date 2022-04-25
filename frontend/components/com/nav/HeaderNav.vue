<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-submenu index="1">
        <template slot="title">카테고리</template>
        <display-category @getCurrentCate="getCurrentCate"/>
      </el-submenu>
      <el-menu-item index="2" class="right-side">
        <nuxt-link to="/" class="underline-none">홈으로</nuxt-link>
      </el-menu-item>
      <el-menu-item index="3" class="right-side">
        <nuxt-link to="/" class="underline-none">로그인</nuxt-link>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import DisplayCategory from "~/components/com/nav/category/DisplayCategory";

export default {
  components: {DisplayCategory},
  data() {
    return {
      activeIndex: "1",
    }
  },
  methods: {
    handleSelect(index) {
      this.activeIndex = index;
    },
    getCurrentCate(e){
      this.$router.push({name :'product', query : {label : e.label, cateNo : e.cateNo}})
    },
  }
}
</script>

<style>
.el-menu--horizontal > .el-menu-item.right-side {
  float : right;
}

.underline-none {
  text-decoration: none;
}
</style>
