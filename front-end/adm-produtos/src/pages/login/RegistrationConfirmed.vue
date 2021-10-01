<template>
  <div class="main">
      <h2>Email Confirmado!</h2>
      <h3>Faça o Login e aproveite sua aplicação!</h3>
      <button @click="logar()" class="btn btn-primary" >Login </button>
  </div>
</template>

<script>
import Axios from 'axios'
export default {
  data(){
    return {
      email:""
    }
  },
  methods:{
   async logar(){
      this.email = this.$route.query.email
      console.log(this.email);

      await Axios.get("http://localhost:8080/users").then( resp => {
          const result = resp.data;
          result.forEach(element => {
            if(element.email === this.email){
              this.$router.push({
                name:"login",
                params:{
                  username: element.username 
                }
              })
            }
          });
        })



    }
  }

}
</script>

<style>

</style>