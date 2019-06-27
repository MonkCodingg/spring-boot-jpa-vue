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
    <button type="submit" class="btn btn-default" @click="submit">Submit</button>
  </form>
  <Footer></Footer>
</div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'
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
  // es5 방식
  // methods: {
  //   submit: function(){
  //     alert('되냐?')
  //   }  
  // }
  // es6 방식
  methods: {      
    submit(){
      alert("submit 함수 실행 변경 실험중입니다.");
        axios.get('/customers/count')
        .then(d=>{
            alert(`SUCCESS : +${d.data}`)
        })
        .catch(e=>{
            alert('ERROR')
        })

    }
  }
}
</script>

<style scoped>
</style>