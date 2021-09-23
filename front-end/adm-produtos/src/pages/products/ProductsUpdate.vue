<template>
  <div>
    <div class="main" v-for="produto in products" :key="produto.id">
      <h2>Atualizando o produto</h2>
      <div class="alert alert-success" v-if="ok">
        <h4>Dados atualizados com Sucesso!</h4>
      </div>
      <div v-else-if="error">
        <h4>{{ message }}</h4>
      </div>
      <div class="form">
        <form>
          <div class="row">
            <label for="" readonly="readonly">Descrição</label>
            <input v-model="produto.name" type="text" />
          </div>

          <div class="row2">
            <label for=""> Preço </label>
            <input v-model.lazy="produto.price" v-money="money" type="text" />

            <div class="row mt-3">
              
             <label for=""> Categoria </label>
              <select id="categorias" v-model="produto.category">
                <option value="">Escolha a categoria</option>
                <option value="1">Eletrônico</option>
                <option value="2">Papelaria</option>
                <option value="3">Cosmeticos</option>
                <option value="4">Vestuário</option>
              </select>
            </div>
          </div>

          <div class="row">
            <label for="">Quantidade </label>
            <input v-model="produto.amount" type="text" />
          </div>

          <div class="botao">
            <button v-on:click="updateProduto(produto, produto.price)" class="btn btn-warning">
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
import { VMoney } from "v-money";

export default {
  directives: { money: VMoney },
  data() {
    return {
      id: this.$route.params.id,
      message: "error",
      ok: false,
      error: false,
      money: {
        decimal: ",",
        thousands: ".",
        prefix: "R$ ",
        suffix: "",
        precision: 2,
        masked: false,
      },
    };
  },
  computed: {
    ...mapState(["products"]),
  },
  methods: {
    ...mapActions("products", ["findProductById", "updateProducts"]),

    async updateProduto(produto, preco) {
      console.log(preco)
      preco = preco.replace(/\./g, "");
      preco = preco.slice(3).replace(",", ".");
      const update = {
        id: produto.id,
        name: produto.name,
        amount: produto.amount,
        price: preco,
        category: {
          id:produto.category
        }
      };
      console.log(update)
      try {
        await this.updateProducts(update);
        this.ok = true;
        await this.findProductById(produto.id);
      } catch (error) {
        error.data
          ? (this.message = error.data.message)
          : (this.message = "Não foi possível a atualização");
        this.error = true;
      }
    },
  },
  created() {
    this.findProductById(this.$route.params.id);
  },
};
</script>
<style  scoped>
.form {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: solid 1px gray;
  width: 35%;
  margin: 0 auto;
  border-radius: 10px;
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