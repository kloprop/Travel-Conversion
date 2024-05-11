<template>
  <div class="big_container" :class = "{dark_container:dark}">
<div class="content_container">
  <div class="text_above_frame">{{displayWord}}</div>
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
      conversionSource:[], 
      vocabSource:[], 
      topic:"conversation",
      answer:" ",
      container: [],
      displayTopic: "",
      displayAnswer: "",
      totalWords:0,
      remainingWords:0,
      displayWord: 0, 
      questionBank: 1
    }
  },
  mounted() {
    axios.get('http://localhost:8081/api/v1/conversions')
      .then(response => {
        this.conversionSource = response.data;
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
      axios.get('http://localhost:8081/api/v1/vocabs')
      .then(response => {
        this.vocabSource = response.data;
      })
      .catch(error => {
        console.error('Error fetching vocab data:', error);
      });
    
    },
  methods: {
    toggle(){
      this.show = !this.show;
      this.hidden = !this.hidden;
    },
    getRandomInt(max) {
  return Math.floor(Math.random() * max);
},
    nextQuestion() {
      console.log(this.conversionSource[0][this.topic])
      this.hidden = true;
  if (this.container.length == 0){
    if (this.questionBank == 1){
      this.container = [...this.conversionSource];
      this.topic  = "conversation";
      this.answer = "translation"
    }
    if (this.questionBank == 2){
      this.container = [...this.vocabSource];
      this.topic  = "chinese";
      this.answer = "english"
    }
      this.totalWords = this.container.length;
      console.log("Reach the end")
      console.log("Size" + this.container.length);
  }
  let int = this.getRandomInt(this.container.length);
  console.log(int);
  this.displayTopic = this.container[int][this.topic];
  this.displayAnswer = this.container[int][this.answer];
  this.container.splice(int, 1);
  this.remainingWords = this.totalWords-this.container.length;
  this.displayWord = this.remainingWords +  "/" + this.totalWords     
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
.text_above_frame {
  font-size: 24px;
  color: #fff; /* Adjust color as needed */
  position: absolute;
  top: 60px; /* Adjust as needed */
  right: 440px; /* Adjust as needed */
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
