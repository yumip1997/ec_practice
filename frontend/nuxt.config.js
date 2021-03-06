export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  target : 'server',
  head: {
    title: 'frontend',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    'element-ui/lib/theme-chalk/index.css'
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '@/plugins/element-ui'
  ],

  ssr : true,

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    ['@nuxtjs/dotenv', { filename: `.env.${process.env.NODE_ENV}` }],
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    '@nuxtjs/axios',
    '@nuxtjs/proxy',
  ],

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    transpile: [/^element-ui/],
  },

  axios :{
    proxy : true,
    baseURL : `${process.env.BASE_URL}`,
  },

  proxy : {
    '/api' : {
      target : `${process.env.BASE_URL}`,
      changeOrigin: true,
      pathRewrite: {
        '^/api' : ""
      },
    },
  },

  router : {
    extendRoutes (routes, resolve) {
      const rootIndex = routes.findIndex(route => route.name === "index");
      routes[rootIndex] = {
        ...routes[rootIndex],
        components : {
          default : routes[rootIndex].component,
          MainHeader : resolve(__dirname, 'pages/main-header'),
          MainFooter : resolve(__dirname, 'pages/main-footer'),
        },
        chunkNames : {
          MainHeader : 'pages/main-header',
          MainFooter : 'pages/main-footer'
        }
      }
    }
  }
}
