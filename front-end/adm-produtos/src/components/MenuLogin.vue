<template>
  <div class="main">
    <div class="login">
      <div class="buttons">
        <router-link  to="/login" v-if="!token" >
          <button class="btn btn-primary btn-sm mr-3">Login</button>
        </router-link>

        <button v-if="token" @click="resetLogin" class="btn btn-primary btn-sm mr-3">
          Logout
        </button>

        <router-link id="link" clas="link ml-3 mt-2" to="">
          <h6>Cadastro</h6>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
      data(){
    return{
      session:false
    }
  },
  computed: {
    username(){
      return localStorage.username
    },

    token(){
      return this.$store.state.user.user.token
    }
  },
  mounted(){
    if(localStorage.token){
      this.session = true
    }
  },
  methods: {
    resetLogin() {
      localStorage.removeItem("token");
      this.$router.go();
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.login {
  width: 100%;
  background-color: #dceaf8;
}
.buttons {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  margin-right: 4%;
}

.link {
  text-decoration: none;
}
.btn {
  margin: 10px;
}

#link {
  text-decoration: none;
}
</style>