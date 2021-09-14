<template>
  <div>
    <div class="categories">
      <h1>Categories</h1>
    </div>

    <div class="list" v-for="category in categories.categories " :key="category.id">
      
      <div class="dados"> {{ category.id }}</div>
      <div class="dados"> {{ category.name }} </div>

    </div>
    <!-- <div class="vuex"> -->

      <!-- <button v-on:click="addCount" >+</button>
      <button v-on:click="minusCount" >-</button>
    </div>
      {{ contador }} -->

      <hr>
      <!-- <div class="produtos">
        {{ products }}
        <input v-model="produtos" type="text" name="" id="">
        <button v-on:click="addProdutos(produtos)" class="btn btn-primary mt-4">+</button>
      </div> -->

  </div>
</template>

<script>

// import axios from 'axios'
import {mapActions, mapState} from 'vuex'
export default {
  data(){
    return {
      produtos: ''
    }
  },
  methods:{
    // getCategories(){
    //   axios.get('http://localhost:8080/categories').then( resp => {
    //     this.categories = resp.data;
    //   })
    // },

    // addCount(){
    //   this.$store.commit('increments')
    // },
    // minusCount(){
    //   this.$store.commit('decrements')
    // },
    // ...mapActions(['addProdutos'])
   ...mapActions(['getCategories'])

  },
  created(){
    // this.getCategories();
      this.getCategories()
  },
  computed:{

    ...mapState([ 'categories'])
  }

}
</script>

<style scoped>


.categories {
  display: flex;
  justify-content: center;
}
.list {
    width: 50%;
    margin-left: 22.5% ;
    display: flex;
    align-items: center;
    justify-content: center;
    border:  1px solid gray;
  }
.dados {
  padding: 0.7%;

}

.vuex{
  display: flex;
  font-size: 30px;
  font-weight: 900;
  align-items: center;
  justify-content: center;
}

.produtos{
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>