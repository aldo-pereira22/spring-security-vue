import Vue from 'vue'
import Vuex from 'vuex'
import { store as products} from './../pages/products'
import {store as categories} from './../pages/categories'
Vue.use(Vuex)

// export default new Vuex.Store({
//   state: {
//     count:0,
//     products:[]
//   },
//   mutations: {
//     increments(state){
//       state.count++;
//     },
//     decrements(state){
//       state.count --;
//     },
//     addProducts(state, payload){
//       state.products.push(payload)
//     }
//   },
//   actions: {
//     addProdutos(context, payload){
//       context.commit('addProducts', payload)
//     }
//   },
//   modules: {
//   }
// })

// const categories = {
//   state:{
//     categories:[]
//   }
// }

// const products = {
//   state:{
//     products:[]
//   },
//   mutations:{
//     getProductsM(state, payload){
//       state.products = payload;
//     }
//   },
//   actions: {
//     getProducts( {commit} ){
//       Axios.get('http://localhost:8080/products').then( resp => {
//         console.log(resp.data)
//         commit('getProductsM', resp.data)
//       })


//     }
//   }

// }

const store = new Vuex.Store({
  modules: {
    categories,
    products
  }
})


export default store 