<template>
    <div>
        <NavBar/>
    </div>
    
  <div id="invoice-POS">
    
    <center id="top">
      <div class="logo"></div>
      <div class="info"> 
        <h2>Movie Tickes Login</h2>
      </div><!--End Info-->
    </center><!--End Login top-->
    
    <div id="mid">
         <h1>Login</h1>
         <form action="">
            UserName:<br>
            <input type="text" class="userInput"> <br><br>
            Password: <br>
            <input type="password" class="userInput"> <br><br>
            <span class="warning">{{Warning}}</span><br>
         </form>
        
    </div><!--End Login Page-->
    
    <div id="bot">
        <div id="legalcopy">
            <p class="legal"><strong>Thank you for your business!</strong><br>Please register if you do not have an account.
            </p>
        </div>
    
    </div><!--End LoginBot-->
        <div>
           
            <button type="button" @click="Login">Login</button>
            <router-link to="/register">
            <button type="button" class="view-order">Register</button>
            </router-link>
  
        </div>
  </div><!--End Login-->

</template>

<script>
import NavBar from './NavBar.vue';
import http from "../http-common";
export default {
    name: "OrderDetail",
    components: {
        NavBar
    },

    data(){
        return{
            userList:[],
            Warning:""

        }
    },
    methods:{
        Login(){
            var userInput= document.getElementsByClassName("userInput");
            for(let i=0;i<userInput.length;i++){
                if (userInput[i].value==""){
                    this.Warning="Please fill up the blank";
                    return;
                }
            }
            for (let i=0;i<this.userList.length;i++){
                if (userInput[0].value==this.userList[i].userName){
                    if (userInput[1].value==this.userList[i].userPassword){
                        alert("Success"); // this is for success loging
                        return;
                    }
                }
            }
            this.Warning="Your UserName is not match to your Password or your UserName is not existed";

        }
    },
    mounted(){
        http.get("/users")
        .then((response)=>{
            this.userList=response.data
        })
        .catch((e)=>{
            console.log(e.response.data)
        })

    }

    
}
</script>
<style scoped>
#invoice-POS{
  box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);
  padding:2mm;
  margin: 0 auto;
  width: 204mm;
  background: #FFF;
}
h1{
  font-size: 1.5em;
  color: #222;
}
h2{font-size: .9em;}
h3{
  font-size: 1.2em;
  font-weight: 300;
  line-height: 2em;
}
p{
  font-size: .7em;
  color: #666;
  line-height: 1.2em;
}
 
#top, #mid,#bot{ /* Targets all id with 'col-' */
  border-bottom: 1px solid #EEE;
}

#top{min-height: 100px;}
#mid{min-height: 80px;} 
#bot{ min-height: 50px;}

#top .logo{

	height: 60px;
	width: 60px;
	background: url(../assets/logo.png) no-repeat;
	background-size: 60px 60px;
}
.clientlogo{
  float: left;
	height: 60px;
	width: 60px;
	background: url(../assets/logo.png) no-repeat;
	background-size: 60px 60px;
  border-radius: 50px;
}
.info{
  display: block;

  margin-left: 0;
}
.title{
  float: right;
}
.title p{text-align: right;} 
table{
  width: 100%;
  border-collapse: collapse;
  position: center;
}

.tabletitle{
  /* //padding: 5px; */
  font-size: .5em;
  background: #EEE;
}
.service{border-bottom: 1px solid #EEE;}
.item{width: 24mm;}
.itemtext{font-size: .5em;}

#legalcopy{
  margin-top: 5mm;
}

button{
    margin: 20px;
    width: 100px;
    height: 40px;
    border-radius: 10px;
    border-color: #EEE;
}
.view-order{
    background: #4FC3A1;
}

/* new  */

.warning{
    color: red;
}

</style>