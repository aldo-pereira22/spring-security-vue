<template>
  <div class="main">
    <div class="login">
      <h2>Login</h2>
      <label for="username">username</label>
      <input type="text">
      <label for="password">Password:</label>
      <input type="password">
      <button class="btn btn-primary">Login</button>
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
    input:focus{
      outline: none;
    }

    button{
      margin-top: 20px;
    }
</style>