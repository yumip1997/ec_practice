<template>
<div>
  <el-row>
  <el-col :span="8" v-for="(prd, index) in prdList" :key="index">
    <el-card :body-style="{ padding: '0px' }">
      <img src="" class="image">
      <div style="padding: 14px;">
        <span>{{prd.prdNm}}</span>
      </div>
    </el-card>
  </el-col>
</el-row>    
</div>
</template>

<script>
export default {
  props : {
    prdList : Array
  },
  name: "ProductCard"
}
</script>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>