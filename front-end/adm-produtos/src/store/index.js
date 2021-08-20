import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count:0
  },
  mutations: {
    increments(state){
      state.count++;
    },
    decrements(state){
      state.count --;
    }
  },
  actions: {
  },
  modules: {
  }
})
