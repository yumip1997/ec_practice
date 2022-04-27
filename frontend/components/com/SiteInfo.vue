<template>
  <div class="footer-main">
    <el-divider/>
    <div class="footer-body">
      <span class="footer-span">서울시 송파구 법원로9길 26 H Business Park D동 6층</span><br>
      <span class="footer-span">Copyright ⓒ 2020 PLATEER. All rights reserved.</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "SiteInfo"
}
</script>

<style scoped>
.footer-main {
  margin-top: 20px;
  margin-bottom: 20px;
}

.footer-body {
  padding: 10px 50px;
  width: 100%;
  height: auto;
  display: table-cell;
  vertical-align: middle;
}

.footer-span {
  font-size: 14px;
  line-height: 180%;
  font-weight: 500;
  margin: 10px;
  color : darkgray;
}
</style>
