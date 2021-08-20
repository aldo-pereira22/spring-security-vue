<template>
  <div class="conteudo">
    <ul>
      <router-link to="/"> <li>Home</li> </router-link>

      <router-link to="/about"> <li>Sobre nós</li> </router-link>

      <router-link to="/categories"> <li>Categories</li> </router-link>

      <router-link to="/products"> <li>Products</li> </router-link>
    </ul>
  </div>
</template>

<script>
export default {

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