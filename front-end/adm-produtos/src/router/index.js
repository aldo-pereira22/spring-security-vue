import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../pages/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../pages/About.vue')
  },
  {
    path: '/categories',
    name: 'Categories',
    component: () => import('../pages/categories/Categories.vue')
  },
  {
    path: '/products',
    name: 'Products',
    component: () => import('../pages/products/Products.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
