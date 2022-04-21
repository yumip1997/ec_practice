<template>
  <div>

  </div>
</template>

<script>
export default {
    data(){
        return {
            productId : '',
            productName : '',
        }
    },
create() {
    this.initProductDetail();
},
method : {
    initProductDetail(){
        this.productId = '상품번호',
        this.productName = '상품이름'
    }
},
  head() {
    return {
      meta: [{
        hid: 'description',
        name: `${this.productName}`,
        content: `상품번호 : 상품 이름 : ${this.productName}`,
      }
      ]
    }
  },
}
</script>

<style>

</style>