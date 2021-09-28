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
  },
  {
    path: '/products-register',
    name: 'products-register',
    component: () => import('../pages/products/ProductsRegister.vue')
  },
  {
    path: '/update',
    name: 'update',
    component: () => import('../pages/products/ProductsUpdate.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../pages/login/Login.vue')
  },
  {
    path: '/cadastro',
    name: 'cadastro',
    component: () => import('../pages/login/Cadastro.vue')
  }

]

const router = new VueRouter({
  routes
})

export default router
