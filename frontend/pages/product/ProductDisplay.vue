<template>
  <div>
    <display-category/>
    <product-list/>
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
        name: '클릭된 카테고리!',
        content: '카테고리!',
      }
      ]
    }
  },
}
</script>

<style scoped>

</style>
