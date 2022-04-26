<template>
  <div>
    <el-tree :data="cateList" @node-click="handleNodeClick"></el-tree>
  </div>
</template>

<script>
const
  dummyCate = [
    {
      cateNo: 100,
      label: '가전',
      children: [
        {
          cateNo: 100100,
          label: '생활가전',
          children: [
            {
              isLeaf: 'Y',
              cateNo: 100100100,
              label: '냉장고'
            },
            {
              isLeaf: 'Y',
              cateNo: 100100101,
              label: '건조기'
            }
          ]
        }
      ]
    },
    {
      cateNo: 200,
      label: '컴퓨터',
      children: [
        {
          cateNo: 200100,
          label: '컴퓨터/노트북',
          children: [
            {
              isLeaf: 'Y',
              cateNo: 200100100,
              label: '데스크탑'
            },
            {
              isLeaf: 'Y',
              cateNo: 200100101,
              label: '노트북'
            }
          ]
        },
        {
          cateNo: 200200,
          label: '컴퓨터 주변 장치',
          children: [
            {
              isLeaf: 'Y',
              cateNo: 200200201,
              label: '모니터'
            },
            {
              isLeaf: 'Y',
              cateNo: 200200202,
              label: '키보드'
            }
          ]
        }
      ]
    },
  ]

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
