<template>
  <div>
    <el-tree :data="cateList" @node-click="handleNodeClick"></el-tree>
  </div>
</template>

<script>
import CateApi from "~/util/api/CateApi";

export default {
  name: "DisplayCategory",

  data() {
    return {
      cateList : []
    }
  },
  async fetch(){
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
