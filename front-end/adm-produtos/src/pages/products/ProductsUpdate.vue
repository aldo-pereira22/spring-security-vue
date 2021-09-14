<template>
  <div class="main">
      <h2>Atualizar produto</h2>
      <h3>  {{ id }} </h3>
  </div>
</template>

<script>
export default {

    data(){
        return {
            id:this.$route.params.id
        }
    }

}
</script>

<style>

</style>