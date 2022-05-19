<template>
  <el-tree :data="treeList" @node-click="handleNodeClick"></el-tree>
</template>

<script>
export default {
  name: "TreeNav",
  props : {
    treeList : Array,
  },
  methods : {
    handleNodeClick(node){
      this.$emit('clickNode', node);
    }
  }
}
</script>

<style scoped>

</style>
