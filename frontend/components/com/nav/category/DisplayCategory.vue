<template>
  <div>
    <el-tree :data="cateList" @node-click="handleNodeClick"></el-tree>
  </div>
</template>

<script>
import CateApi from "~/api/CateApi";

export default {
  name: "DisplayCategory",

  data() {
    return {
      cateList : []
    }
  },

  //TODO 라이프사이클 찾아보기
  async created(){
    await this.initCateList();
  },

  methods: {
    async initCateList(){
      this.cateList = await CateApi.getDispCateList();
    },

    handleNodeClick(node) {
      if (node.cateLeafF) {
        this.$emit('getCurrentCate', node);
      }
    },
  }
}
</script>

<style scoped="scoped"></style>
