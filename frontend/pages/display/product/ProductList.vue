 <template>
   <div>
       카테고리 페이지..<br>
       카테고리 {{$route.query.label || '전체'}}의 상품 리스트 영역
       <product-card :prdList="prdList"/>
   </div>
 </template>

<script>
import ProductCard from '@/components/product/ProductCard.vue'

const dummyData = [{
    prdNo : '1',
    prdNm : '냉장고1',
    cateNo : '100100100',
},
{
    prdNo : '2',
    prdNm : '냉장고2',
    cateNo : '100100100',
},
{
    prdNo : '3',
    prdNm : '냉장고3',
    cateNo : '100100100',
}
]

 export default {
  components: { ProductCard },
  data(){
    return{
        prdList : dummyData,
    }
  },
   head() {
    return {
       meta: [{
        hid: 'cateNo',
        name: `카테고리 번호`,
        content: `${this.$route.query.cateNo}`,
      },
      {
        hid: 'cateNm',
        name: `카테고리 이름`,
        content: `${this.$route.query.label}`,
      },
      ]
    }
  },
 }
 </script>

 <style>

 </style>
