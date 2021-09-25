<template>
  <div class="main">
    <div class="login">
      <h2>Login</h2>
      <label for="username">username</label>
      <input v-model="username" type="text">
      <label for="password">Password:</label>
      <input v-model="password" type="password">
      <button v-on:click="enviarDadosLogin" name="password" class="btn btn-primary">Login</button>
    </div>
  </div>
</template>

<script>
import Axios from 'axios';
import {mapActions} from 'vuex'
export default {
  data(){
    return {
      username:'',
      password:''
    }
  },
  methods:{
    ...mapActions('user', ['setUserLogin']),
    enviarDadosLogin(){
      const dados = {
        username:this.username,
        password:this.password
      }
      console.log(dados)
      Axios.post('http://localhost:8080/login', dados)
      .then(response => {
        localStorage.setItem('token', response.data.token);
        localStorage.setItem('username', response.data.username);
        this.setUserLogin();
      })
        this.$router.push('/')
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