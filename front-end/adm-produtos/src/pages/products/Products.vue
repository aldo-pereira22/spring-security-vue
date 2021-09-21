<template>
  <div class="principal">
    <div class="principal">
      <div class="topo">
        <h1>Products</h1>
        <button class="btn btn-success" > <router-link class="link" to="/products-register"> Adicionar Produto </router-link> </button>
      </div>

      <div>
        <ul>
          <li>
            <div class="dados" id="id"><strong> Id </strong></div>
            <div class="dados" id="descricao"><strong> Descrição </strong></div>
            <div class="dados" id="amount"><strong> Quantidade </strong></div>
            <div class="dados" id="price"><strong> Preço </strong></div>
            <div class="dados" id="action"><strong> Ação </strong></div>

            <hr />
          </li>
        </ul>
      </div>

      <div v-for="dado in products.products" :key="dado.id">
        <ul>
          <li>
            <div class="dados" id="id">{{ dado.id }}</div>
            <div class="dados" id="name">{{ dado.name }}</div>
            <div class="dados" id="amount">{{ dado.amount }}</div>
            <div class="dados" id="price">{{ conversaoValor(dado.price) }}</div>
            <div class="dados" id="action"> 
                <router-link v-bind:to="{name:'update', params: {id: dado.id}}" > 

                    <button id="edit" class="btn btn-primary"> <i class="fas fa-edit">  </i> </button>
                </router-link>
                <button v-on:click="exluirProduto(dado.id)" class="btn btn-danger ml-3"> 
                  <strong> X </strong>
                </button>
            </div>

            <hr />
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
// import dados from './../data/data.json'
import { mapState, mapActions } from "vuex";
export default {
  data() {
    return {
      // dados:dados
    };
  },
  methods: {
    ...mapActions("products", ["getProducts", "deleteProducts" ]),
    conversaoValor(valor) {
      return "R$ " + valor.toFixed(2);
    },

    async exluirProduto(id){
      try{
        await this.deleteProducts(id);
        // this.getProducts();
        this.$router.go();
      }catch(e){
        alert('Não foi possível excluir'+ e)
      }
    }
  },
  computed: {
    ...mapState(["products"]),
  },
  created() {
    this.getProducts();
  },
};
</script>

<style scoped>
.principal ul {
  padding: 1%;
  padding-top: 0.1%;
  margin-top: -1%;
  list-style: none;
}

ul li {
  display: flex;
  justify-content: space-around;
  border: solid 1px gray;
  padding: 1%;
}

.dados {
  padding: 0.7%;
  border-right: solid 1px gray;
  border-left: solid 1px gray;
}

#id {
  min-width: 10%;
}

#name {
  min-width: 35%;
  color: blue;
}
#descricao {
  min-width: 35%;
}

#amount {
  min-width: 10%;
}

#price {
  min-width: 14%;
}
.topo {
    display: flex;
    justify-content: space-around;
    padding: 1.4%;
}

.btn {
    max-height: 50px;

}
.link {
    text-decoration: none;
    color:white;
}

#edit {
  margin: 5px;
}
</style>>




