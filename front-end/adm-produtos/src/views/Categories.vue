<template>
  <div>
    <div class="categories">
      <h1>Categories</h1>
    </div>

    <div class="list" v-for="categories in categories " :key="categories.id">
      
      <div class="dados"> {{ categories.id }}</div>
      <div class="dados"> {{ categories.name }} </div>

    </div>
    <div class="vuex">

      <button v-on:click="addCount" >+</button>
      <button v-on:click="minusCount" >-</button>
    </div>
      {{ contador }}

  </div>
</template>

<script>

import axios from 'axios'
export default {
  data(){
    return {
      categories:{}
    }
  },
  methods:{
    getCategories(){
      axios.get('http://localhost:8080/categories').then( resp => {
        this.categories = resp.data;
      })
    },

    addCount(){
      this.$store.commit('increments')
    },
    minusCount(){
      this.$store.commit('decrements')
    }


  },
  created(){
    this.getCategories();
  },
  computed:{
    contador(){
      return this.$store.state.count
    }
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

</style>