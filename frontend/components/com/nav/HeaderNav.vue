<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-submenu index="1">
        <template slot="title">카테고리</template>
        <tree-nav
          :tree-list="cateList"
          @click-node="handleNodeClick"
        />
      </el-submenu>
      <el-menu-item index="2" class="right-side">
        <nuxt-link to="/" class="underline-none">홈으로</nuxt-link>
      </el-menu-item>
      <el-menu-item index="5" class="right-side">
        <nuxt-link to="/product" class="underline-none">상품페이지</nuxt-link>
      </el-menu-item>
    </el-menu>
  </div>
</template>



<script>
import TreeNav from "./TreeNav";

export default {
  components: {TreeNav},
  props :{
    cateList : Array,
  },
  data() {
    return {
      activeIndex: "1",
    }
  },
  methods: {
    handleSelect(index) {
      this.activeIndex = index;
    },
    handleNodeClick(e){
      if(e.cateLeafF){
        this.$router.push({name :'product', query : {label : e.label, cateId : e.cateId}});
      }
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
