<template>
    <div>
        <NavBar/>
    </div>
    
  <div id="invoice-POS">
    
    <center id="top">
      <div class="logo"></div>
      <div class="info"> 
        <h2>Movie Tickes Register</h2>
      </div><!--End Info-->
    </center><!--End Login top-->
    
    <div id="mid">
         <h1>Register</h1>
         <form action="">
            Your UserName:<br>
            <input type="text" class="userInput"><br><br>
            Your Email: <br>
            <input type="text" class="userInput"> <br><br>
            Your Address: <br>
            <input type="text" class="userInput"> <br><br>
             Your Phone number: <br>
            <input type="number" class="userInput"> <br><br>
             Your Password: <br>
            <input type="password" class="userInput"> <br><br>
            Confirmed Password: <br>
            <input type="password" class="userInput"> <br><br>
            
            <span class="warning">{{Warning}}</span><br>
         </form>
        
    </div><!--End Login Page-->
    

    
   <div id="bot">
        <div id="legalcopy">
            <p class="legal"><strong>Thank you for your business!</strong><br>Please try to login after register. 
            </p>
        </div>
    
    </div><!--End LoginBot-->
    <div>
        <div>
            <button type="button" @click="RegisterUser">Register</button> 
            <router-link to="/login">
            <button type="button" class="view-order">Back to Login</button> 
            </router-link>
        </div>
    </div><!--End Login-->

</div>

</template>

<script>
import NavBar from './NavBar.vue';
import http from "../http-common";
import router from "../router/index";
export default {
    
    name: "registerPage",
    components:{
         NavBar
    },
    data(){
        return{
            Warning:"",
            userList:[],
        }
    },
    methods:{
        RegisterUser(){
            var user =  document.getElementsByClassName("userInput");

            // validation

            // 1. check empty blank brfore actually register
            for (let i=0; i< user.length ;i++){
                if (user[i].value==""){
                    this.Warning="No empty space allowed";
                    return;
                }
            }

            // 2. check if user name or Email is repeated. If yes, warn user 

             for (let i=0; i< this.userList.length ;i++){
                if (this.userList[i].userName==user[0].value){
                    this.Warning="This user name is existed, please retry";
                    return;
                }
                 if (this.userList[i].userEmail==user[1].value){
                    this.Warning="This email is existed, please retry";
                    return;
                }

            }

            // 3. check if password = confirmed password
            if (user[4].value!=user[5].value){
                 this.Warning="Password & Password confirmed not match, please retry";
                 return;
            }

            // All condition satisfied, create user into database and back to login page 
            // 1. Create user obj 

            let newUser={
                userName: user[0].value,
                userPassword: user[4].value,
                userPhoneNumber: user[3].value,
                userAddress:user[2].value,
                userEmail:user[1].value
            }

            // 2. Put data in database 
             http.post("/users",newUser).catch(e=>e.response.data);
            // 3. back to login page 
            router.push("/login");
            console.log("Account creating success");
            alert("Account has been successfully created");

        },
    },
    mounted(){

        // get all user and put in list 
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
/**new  */
.warning{
    color: red;
}

</style>