<template>
  <div class="conteudo">
    <ul>
      <router-link to="/"> <li>Home</li> </router-link>

      <router-link to="/about"> <li>Sobre nós</li> </router-link>

      <router-link v-if="token" to="/categories"> <li>Categories</li> </router-link>

      <router-link v-if="token" to="/products"> <li>Products</li> </router-link>
    </ul>


  </div>
</template>

<script>
export default {
  computed:{
    username(){
      return localStorage.username
    },
    token(){
      return localStorage.token
    }
  }
};
</script>

<style scoped>
 ul {
     display: flex;
     justify-content: space-around;
     list-style: none;
 }

li {

    margin-left: 1%;    
    width: 100%;

}

</style>