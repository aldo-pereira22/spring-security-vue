import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import $ from 'jquery'
import bootstrap from './bootstrap'
import money from 'v-money'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  $,
  bootstrap,
  money,
  render: h => h(App)
}).$mount('#app')

