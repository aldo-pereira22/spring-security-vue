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
            var token = localStorage.getItem('token');
            const headers = { Authorization: `Bearer ${token}`}
            axios.get('http://localhost:8080/categories', {headers})
            .then(resp => {
                commit('getCategoriesM', resp.data);
            })
        }
    },
    namespaced:true
}