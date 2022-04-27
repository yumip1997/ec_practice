<template>
  <div>
    <el-row class="page_title">라우팅 확인</el-row>
    <el-row class="page_box">
      <el-col :sm="12" :lg="8">
        <el-result icon="info" subTitle="샘플 페이지1로 이동합니다.">
          <template slot="extra">
            <nuxt-link to="/test/sample1" class="underline-none">
              <el-button type="primary" size="medium">
                이동
              </el-button>
            </nuxt-link>
          </template>
        </el-result>
      </el-col>
      <el-col :sm="12" :lg="8">
        <el-result icon="info" subTitle="샘플 페이지2로 이동합니다.">
          <template slot="extra">
            <nuxt-link to="/test/sample2" class="underline-none">
              <el-button type="primary" size="medium">
                이동
              </el-button>
            </nuxt-link>
          </template>
        </el-result>
      </el-col>
      <el-col :sm="12" :lg="8">
        <el-result icon="info" subTitle="샘플 페이지3로 이동합니다.">
          <template slot="extra">
            <nuxt-link to="/test/sample3" class="underline-none">
              <el-button type="primary" size="medium">
                이동
              </el-button>
            </nuxt-link>
          </template>
        </el-result>
      </el-col>
    </el-row>
    <nuxt-child/>
  </div>
</template>

<script>
export default {
  name: "Sample"
}
</script>

<style scoped>
.underline-none > :visited {
  text-decoration: none;
}
.page_box {
  padding-top: 30px;
}
.page_title {
  padding-top: 20px;
  text-align: center;
  color : gray;
}
</style>
