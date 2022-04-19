<template>
  <div>
    <display-category/>
    <product-list />
  </div>
</template>

<script>
import ProductList from "~/components/product/ProductList";
import DisplayCategory from "~/components/category/DisplayCategory";

export default {
  name: "ProductDisplay",
  components: {DisplayCategory, ProductList}
}
</script>

<style scoped>

</style>
