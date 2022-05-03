<template>
 <div>
   <el-row class="page_title">라우팅 확인</el-row>
   <div class="page_box">
     <el-row>
       <el-col>
         <div class="grid-content bg-purple">
           <nuxt-link to="/test/sample1" class="underline-none">
             샘플 페이지 1로 이동합니다. (프리패칭 설정o)
           </nuxt-link>
         </div>
       </el-col>
     </el-row>
   </div>
   <div class="page_box">
     <el-row>
       <el-col>
         <div class="grid-content bg-purple">
           <nuxt-link to="/test/sample2" class="underline-none" :prefetch="false">
             샘플 페이지 2로 이동합니다. (프리패칭 설정 x)
           </nuxt-link>
         </div>
       </el-col>
     </el-row>
   </div>
   <div class="page_box">
     <el-row>
       <el-col>
         <div class="grid-content bg-purple">
           <el-button @click="sample3Visible = true">link {{sample3Visible ? "visible" : "invisible"}}</el-button>
           <nuxt-link to="/test/sample3" class="underline-none" v-if="sample3Visible">
             샘플 페이지 3로 이동합니다. (프리패칭 설정 o)
           </nuxt-link>
         </div>
       </el-col>
     </el-row>
   </div>
   <div class="page_box">
     <el-row>
       <el-col>
         <div class="grid-content bg-purple">
           <el-button @click="sample4Visible = true">link {{sample4Visible ? "visible" : "invisible"}}</el-button>
           <nuxt-link to="/test/sample4" class="underline-none" v-if="sample4Visible" :prefetch="false">
             샘플 페이지 4로 이동합니다. (프리패칭 설정 x)
           </nuxt-link>
         </div>
       </el-col>
     </el-row>
   </div>
 </div>
</template>

<script>
export default {
  name: "Sample",
  data(){
    return{
      sample3Visible : false,
      sample4Visible : false,
    }
  }
}
</script>

<style scoped>

.underline-none {
  color: black;
}
.underline-none > :visited {
  text-decoration: none;
}
.page_box {
  padding-top: 20px;
  padding-left: 30px;
  padding-right: 30px;
}
.page_title {
  padding-top: 20px;
  text-align: center;
  color : gray;
}
.bg-purple {
  background: #d3dce6;
}
.grid-content {
  text-align: center;
  border-radius: 4px;
  min-height: 50px;
}
</style>
