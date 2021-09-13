<template>

  <div class="home">
    <img src="./../assets/trade.jpg" width="400" alt="Traders" />
    <div class="items">
      <div class="card text-white bg-info mb-3" style="max-width: 36rem">
        <div class="card-header">Categorias</div>
        <div class="card-body">
          <h5 class="card-title"> Categories </h5>
          <p class="card-text">
            Os diversos tipos de produtos são divididos em categorias específicas
            
          </p>
        </div>
      </div>

      <div class="card bg-light mb-3" style="max-width: 36rem">
        <div class="card-header">Products</div>
        <div class="card-body">
          <h5 class="card-title">Produtos</h5>
          <p class="card-text">
              
            Cada produto é separado por sua respectiva categoria
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: "Home",
  components: {},
};
</script>


<style scoped>
  .home {
    display: flex;
    justify-content: space-around;
  }

  .items {
    max-width: 50%;
  }

</style>
