<template>
  <div class="main">
    <h1>Novos produtos</h1>
    <div class="form">
      <form>
        <div class="row">
          <label for="">Descrição</label>
          <input v-model="form.name" type="text" />
        </div>
        <div class="row">
          <label for="">Quantidade </label>
          <input v-model="form.amount" type="text" />
        </div>

        <div class="row">
          <label for=""> Preço </label>
          <!-- <input v-model="price" v-money="money" type="text" /> -->
          <input v-model.lazy="price" v-money="money" type="text" />

        </div>


        <div class="row mt-3">
          <select id="categorias" v-model="form.category">
            <option value="">Escolha a categoria</option>
            <option value="1">Eletrônico</option>
            <option value="2">Papelaria</option>
            <option value="3">Cosmeticos</option>
            <option value="4">Vestuário</option> 
        
          </select>
        </div>

        <div class="botao">
          <button v-on:click="addProdutos" class="btn btn-primary">
            Cadastrar
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { VMoney } from "v-money";
export default {
  directives: { money: VMoney },
  data() {
    return {
      form: {
        name: "",
        amount: "",
        category:''
      },
      price: 0,
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
  methods: {
    ...mapActions("products", ["addProducts"]),

    addProdutos(add) {

      this.price = this.price.replace(/\./g, "");
      this.price = this.price.slice(3).replace(",", ".");
      add = {
        name: this.form.name,
        amount: this.form.amount,
        price: this.price,
        category:{ id: parseInt(this.form.category)}
      };
      // console.log(add);
      this.addProducts(add);
      this.form.name = "";
      this.form.amount = "";
      this.price = "";
    },
  },
};
</script>

<style  scoped>
/* form {
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
} */

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: solid 1px gray;
  border-radius: 7%;
  width: 35%;
  padding: 1%;
}

.row {
  width: 100%;
  padding: 1.4%;
  display: flex;
  align-items: center;
  justify-content: flex-start;
}

label {
  align-items: flex-start;
  text-align: right;
  width: 21%;
}
input {
  border: none;
  border-bottom: 1px solid grey;
}
input:focus {
  outline: none;
}
</style>