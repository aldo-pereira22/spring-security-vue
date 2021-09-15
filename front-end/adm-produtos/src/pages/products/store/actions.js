import * as types from './mutation-types'
import Axios from 'axios'


export const getProducts = ({commit}) => {
    Axios.get('http://localhost:8080/products')
    .then(( resp ) =>{
        commit(types.GET_PRODUCTS, resp.data)
    })
}

export const addProducts = ( {commit}, add ) => {
    Axios.post('http://localhost:8080/products', add)
    .then( (resp) => {
        commit(types.ADD_PRODUCTS, resp.data)
    } )
}

export const findProductById = ( { commit }, id) => {
    Axios.get('http://localhost:8080/products/' + id)
    .then(resp => {
        commit(types.FIND_PRODUCTS, resp.data);
    })
}

export const updateProducts = ( {commit}, add ) => {
    Axios.put('http://localhost:8080/products/'+ add.id, add)
    .then(resp => {
        commit(types.UPDATE_PRODUCTS, resp.data)
    })
}

export const deleteProducts = ( {commit }, id ) => {
    Axios.delete('http://localhost:8080/products/'+id)
    .then(resp => {
        commit(types.DELETE_PRODUCTS, resp.data)
    })
}