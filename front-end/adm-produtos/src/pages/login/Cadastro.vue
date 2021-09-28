<template>
  <div class="main">
    <div class="login">
      <h2>Adicione seus dados</h2>
      <label for="email">E-mail</label>
      <input v-model="email" type="email" />
      <label for="username">username</label>
      <input v-model="username" type="text" />
      <label for="password">Password:</label>
      <input v-model="password" type="password" />
      <button
        v-on:click="enviarDadosLogin"
        name="password"
        class="btn btn-primary"
      >
        Cadastrar
      </button>
    </div>
  </div>
</template>

<script>
export default {};
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