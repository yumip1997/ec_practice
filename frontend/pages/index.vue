<template>
<div>
  메인 페이지
  <nuxt-child/>
</div>
</template>

<script>
export default {
  name: 'IndexPage',
    head() {
    return {
      meta: [{
        hid: 'description',
        name: '메인 페이지',
        content: 'nuxt project',
      }]
    }
  },
}
</script>
