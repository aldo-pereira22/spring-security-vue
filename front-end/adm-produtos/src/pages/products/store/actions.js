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