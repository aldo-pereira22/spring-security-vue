<template>
  <div class="main">
    <div v-if="confirmed" class="alert alert-success">
      <h4>Email enviado!!!</h4>
      <h4>Confira seu email para confirmar seu cadastro</h4>
    </div>
    <div v-if="!confirmed" class="login">
      <h2>Adicione seus dados</h2>
      <label for="email">E-mail</label>
      <input v-model="email" type="email" />

      <label for="username">username</label>
      <input v-model="username" type="text" />

      <label for="password">Password:</label>
      <input v-model="password" type="password" />
      <button
        v-on:click="enviarDadosCadastro"
        class="btn btn-primary"
      >
        Cadastrar
      </button>
    </div>
  </div>
</template>

<script>
import {mapState, mapActions} from 'vuex'
export default {
  data(){
    return {
      email:"",
      username:"",
      password:"",
      confirmed:false
    }
  },
  computed: {
    ...mapState(["user"])
  },
  methods:{
    ...mapActions('user',["usersRegisterAction", "emailConfirmed"]),
    async enviarDadosCadastro(){

      const user = {
        email:this.email,
        username:this.username,
        password:this.password
      }

      await this.usersRegisterAction(user);

      const email = {
        emailTO: user.email,
        subject: "Confirmação de Cadastro!",
        text:`<h4> Confirmação de cadastro! </h4>
              <td style="border-radius: 4px;background:#0095ff; color:white; text-align:center" >
              <a href="http://localhost:8081/#/registration?email=${user.email}"> Confirmar cadastro </a>
            </td>
            `
      }

      await this.emailConfirmed(email);
      this.confirmed = true;
    }
  }

};
</script>

<style scoped>

    .main {
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 2%;
    }
    .login {
      display: flex;
      flex-direction: column;
      width: 40%;
 background-color: #dceaf8;
      padding: 4%;
      border-radius: 12px;

    }
    input {
      border: none;
      border-bottom: solid 0.5px #070729;
     
    }
    label {
       margin-top: 20px;
    }
    input:focus{
      outline: none;
    }

    button{
      margin-top: 20px;
    }
</style>