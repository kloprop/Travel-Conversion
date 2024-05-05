<template>
  <div class="big_container" :class = "{dark_container:dark}">
<div class="content_container">
  <div class="frame" :class = "{dark_frame:dark}"> {{ displayTopic}}</div>
  <div class="frame" :class="{show:show, hidden:hidden, dark_frame:dark}">{{ displayAnswer }}</div>
  <div class="btn-container_space">
    <button class="btn btn_secondary" @click = "toggle">Show</button>
    <button class="btn btn_secondary" @click="nextQuestion">Next</button>
  </div>
    <button class="btn btn_inline btn_absolute btn_accent" @click="changeMode" >Change Mode</button>
</div>
</div>
</template>
<script>
import axios from 'axios';
export default {
  name: 'App',
  data(){
    return{
      dark: false,
      show: false,
      hidden: true,
      source:[], 
      container: [],
      displayTopic: "",
      displayAnswer: ""
    }
  },
  mounted() {
    axios.get('http://localhost:8081/api/v1/pairs')
      .then(response => {
        this.source = response.data;
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })},
  methods: {
    toggle(){
      this.show = !this.show;
      this.hidden = !this.hidden;
    },
    getRandomInt(max) {
  return Math.floor(Math.random() * max);
},
    nextQuestion() {
      this.hidden = true;
  if (this.container.length == 0){
      this.container = [...this.source];
      console.log("Reach the end")
      console.log("Size" + this.container.length);
  }
  let int = this.getRandomInt(this.container.length);
  console.log(int);
  this.displayTopic = this.container[int].conversation;
  this.displayAnswer = this.container[int].translation;
  this.container.splice(int, 1);
    }, 
    changeMode(){
      console.log("dark? " + this.dark);
      this.dark = !this.dark;
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
body {
    margin: 0;
    padding: 0;
    overflow: hidden;
}
.big_container{
  background-color: rgb(77,121, 119);
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 15px;
}
.dark_container{
  background-color: black;
}
.content_container{
  height: 70vh;
  display: flex;
  flex-direction: column;
  gap: 15px;

}
.btn{
  padding: 5px 10px;
  background-color: rgb(227, 241, 241);
  cursor: pointer;
  border: none;
  outline: none; 
  border-radius: 5px;
  font-size: 20px;

}
.btn-container_space{
  display: flex;
  justify-content: space-around;
}
.btn-container_center{
  display: flex;
    justify-content: center;
}
.btn_inline{
  display: inline-block;
  width: 150px
}
.btn_absolute {
  position: absolute;
  top: 20px; /* Adjust as needed */
  right: 20px; /* Adjust as needed */
}
.btn_secondary{
  background-color: rgb(11, 71, 66);
  color: grey;
}
.btn_accent{
  background-color: rgb(119, 18, 26);
  color: grey;
}
.btn_accent:hover{
  color: white;
  transition-delay: 0.1s
}
.btn_secondary:hover{
  color: white;
  transition-delay: 0.1s
}

.frame{
  border: 5px solid rgb(189,180,198);
  text-align: center;
  font-size: 30px;
  width: 400px;
  height: 150px;
}
.show{
  color: black;
}
.hidden{
  /* color: transparent;*/
  text-indent: -9999px;
  user-select: none;
}
.dark_frame{
  border: 5px solid rgb(188,134,49);
  color: white;
}
</style>
