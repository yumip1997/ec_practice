<template>
  <div>기획전</div>
</template>

<script>
import {getPlanShopMetaInfo} from "~/util/metaInfo/planshop-meta";

export default {
  name: "index",
  head(){
    return{
      meta : getPlanShopMetaInfo()
    }
  }
}
</script>

<style scoped>

</style>
