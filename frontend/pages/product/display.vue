<template>
  <div>
    <nuxt-child/>
  </div>
</template>

<script>
import ProductList from "~/components/product/ProductList";
import DisplayCategory from "~/components/category/DisplayCategory";

export default {
  name: "ProductDisplay",
  components: {DisplayCategory, ProductList},
  data() {
    return {}
  },
  head() {
    return {
      meta: [{
        hid: 'description',
        name: '상품전시페이지',
        content: '상품전시페이지',
      }
      ]
    }
  },
}
</script>

<style scoped>

</style>
