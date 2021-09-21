<template>
  <div id="app">
    <div id="nav">
      <div class="login">
        <div class="buttons">

          <router-link to="/login">
            <buttton class="btn btn-primary btn-sm mr-3">Login</buttton>
          </router-link>
          <router-link id="link" clas="link ml-3 mt-2" to="">
              <h6>Cadastro</h6>
          </router-link>

        </div>
      </div>

      <Menu />
      <hr>


    </div>
    <router-view/>
  </div>
</template>


<script>
import Menu from './components/Menu.vue'

export default {
  components:{
    Menu
  }
}
</script>
<style scoped>

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
.buttons{
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
