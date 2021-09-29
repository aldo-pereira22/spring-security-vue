<template>
  <div id="app">
    <div id="nav">
      

      <MenuLogin />
      <Menu />
      <hr />
    </div>
    <router-view />
  </div>
</template>


<script>
import Menu from "./components/Menu.vue";
import MenuLogin from "./components/MenuLogin.vue";

export default {
  components: {
    Menu,
    MenuLogin
  },
};
</script>
<style scoped>
/* #app {
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
} */
</style>
