export const getProductMetaInfo = (vm) => {
  return [
    {
      hid: 'cateId',
      name: `카테고리 번호`,
      content: `${vm.$route.query.cateId}`,
    },
    {
      hid: 'cateNm',
      name: `카테고리 이름`,
      content: `${vm.$route.query.label}`,
    },
  ]
}
