<template>
  <div>
    <div class="main" v-for="produto in products" :key="produto.id">
      <h2>Atualizando o produto</h2>
      <div class="alert alert-success" v-if="ok">
        <h4>Dados atualizados com Sucesso!</h4>
      </div>
      <div v-else-if="error" >
        <h4> {{message}} </h4>
      </div>
      <div class="form">
        <form>
          <div class="row">
            <label for="" readonly="readonly">Descrição</label>
            <input v-model="produto.name" type="text" />
          </div>

          <div class="row">
            <label for=""> Preço </label>
            <input v-model="produto.price" type="text" />
          </div>

          <div class="row">
            <label for="">Quantidade </label>
            <input v-model="produto.amount" type="text" />
          </div>

          <div class="botao">
            <button v-on:click="updateProduto(produto)" class="btn btn-warning">
              Atualizar
            </button>
          </div>
        </form>
      </div>
      <h3>{{ id }}</h3>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  data() {
    return {
      id: this.$route.params.id,
      message: 'error',
      ok: false,
      error: false
    };
  },
  computed: {
    ...mapState(["products"]),
  },
  methods: {
    ...mapActions('products', ['findProductById', 'updateProducts']),

   async updateProduto(produto) {
      const update = {
        id: produto.id,
        name: produto.name,
        amount: produto.amount,
        price: produto.price,
      };
      try {
        await  this.updateProducts(update);
        this.ok = true;
        await this.findProductById(produto.id);
      } catch (error) {
        error.data ? this.message =  error.data.message : this.message =  'Não foi possível a atualização';
        this.error  = true
      }
    }
  },
  created() {
    this.findProductById(this.$route.params.id);
  },
};
</script>
<style  scoped>
form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.row {
  padding: 1.4%;
  display: flex;
  align-items: center;
}
input {
  border: none;
  border-bottom: 1px solid grey;
}
input:focus {
  outline: none;
}
</style>