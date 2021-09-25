<template>
  <div>
    <div class="categories">
      <h1>Categories</h1>
    </div>

    <div
      class="list"
      v-for="category in categories.categories"
      :key="category.id"
    >
      <div class="categories">
        <div class="dados">{{ category.id }}</div>
        <div class="dados">
          <button class="btn" v-on:click="mostraProdutos(category.id)">
            {{ category.name }}
          </button>
        </div>
      </div>
      <div class="row" v-for="produto in products.products" :key="produto.id">
        <div class="produtos" v-if="produto.category" >
          <ul v-if="produto.category.id == productId && category.id == productId">
            <li>
              {{ produto.name }}
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from 'axios'
import { mapActions, mapState } from "vuex";
export default {
  data() {
    return {
      productId: "",
    };
  },
  methods: {
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
    ...mapActions("categories",["getCategories"]),
    ...mapActions("products",["getProducts"]),
    mostraProdutos(id) {
      id != this.productId ? (this.productId = id) : (this.productId = "");
    
    },
  },
  created() {
    // this.getCategories();
    this.getCategories(), this.getProducts();
  },
  computed: {
    ...mapState(["categories", "products"]),
  },
};
</script>

<style scoped>
.categories {
  display: flex;
  justify-content: center;
}
.list {
  width: 50%;
  margin-left: 22.5%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 1px solid gray;
}
.dados {
  padding: 0.7%;
}

ul {
  width: 100%;
  list-style: none;
}

.vuex {
  display: flex;
  font-size: 30px;
  font-weight: 900;
  align-items: center;
  justify-content: center;
}

.produtos {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.row {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.categories {
  width: 100%;
  display: flex;
  justify-content: center;
  background-color: #dceaf8;
}
</style>