import * as types from './mutation-types'

export default {
    [types.GET_PRODUCTS](state,payload){
        state.products = payload;
    },
    [types.ADD_PRODUCTS](state,payload){
        state.products = payload;
    },
    [types.FIND_PRODUCTS](state,payload){
        state.products = payload;
    },
    [types.UPDATE_PRODUCTS](state,payload){
        state.products = payload;
    }
}

