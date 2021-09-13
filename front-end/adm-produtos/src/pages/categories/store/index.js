import axios from "axios";

export default {
    state: { categories:[]},
   
    mutations: {
        getCategoriesM(state, payload){
            state.categories = payload;
        }
    },

    actions: {
        getCategories( { commit  }){
            axios.get('http://localhost:8080/categories')
            .then(resp => {
                commit('getCategoriesM', resp.data);
            })
        }
    }
}