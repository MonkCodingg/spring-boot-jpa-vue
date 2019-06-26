<template>
<div>
  <Nav></Nav>
  <form>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Recommon me</label>
    </div>
    <button type="submit" class="btn btn-default" @submit="submit">Submit</button>
  </form>
  <Footer></Footer>
</div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
export default {
  data: ()=>{
    return {
      email: '',
      pwd: ''
    }
  },
  components: {
    Nav,
    Footer
  },
  methods: {
      
      submit(){
        alert("submit 함수 실행");
        this.email = 
//        let email = document.getElementById('email').value;
//        let pwd = document.getElementById('pwd').value;
        alert("email창 입력값은 => " + email+"\n"+"password창 입력값은=> "+pwd);

      }
  }
}
</script>

<style scoped>
</style>