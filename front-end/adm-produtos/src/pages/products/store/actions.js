import * as types from './mutation-types'
import Axios from 'axios'


export const getProducts = ({commit}) => {
    Axios.get('http://localhost:8080/products')
    .then(( resp ) =>{
        commit(types.GET_PRODUCTS, resp.data)
    } )
}