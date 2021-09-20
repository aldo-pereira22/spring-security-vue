<template>
  <div id="app">
    <div id="nav">
      <div class="login">
        <router-link to="/">
          <buttton class="btn btn-primary btn-sm">Login</buttton>
        </router-link>

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

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  




}
</style>
