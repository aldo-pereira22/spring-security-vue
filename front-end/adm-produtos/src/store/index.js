import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count:0,
    products:[]
  },
  mutations: {
    increments(state){
      state.count++;
    },
    decrements(state){
      state.count --;
    },
    addProducts(state, payload){
      state.products.push(payload)
    }
  },
  actions: {
    addProdutos(context, payload){
      context.commit('addProducts', payload)
    }
  },
  modules: {
  }
})
