<template>
    <div>
        <NavBar/>
    </div>
    
  <div id="invoice-POS">
    
    <center id="top">
      <div class="logo"></div>
      <div class="info"> 
      </div><!--End Info-->
    </center><!--End Login top-->
    
    <div id="mid">
         <h1>Add Show</h1>
         <form action="">
            date:<br>
            <input type="date" class="userInput"><br><br>
            startTime: <br>
            <input type="time" class="userInput"> <br><br>
            endTime: <br>
            <input type="time" class="userInput"> <br><br>
            movie: <br>
            <div class="userInput" >{{movieObj.title}}</div><br>
            screen: <br>
            <select  class="userInput" value="Select Screen here" @change="OnChangeScreen">
                <option  v-for="screen in screens" :key="screen.message" v-bind:value="screen.id">{{screen.name}}</option>
            </select><br><br>
            <span class="warning">{{Warning}}</span><br>
         </form>
         <br>
        
    </div><!--End Login Page-->
    

    
   <div id="bot">
        <div id="legalcopy">
            <p class="legal"><strong>Thank you for your business!</strong><br>Please contact Carrie if any error happens. 
            </p>
        </div>
    
    </div><!--End LoginBot-->
    <div>
        <div>
            <button type="button" @click="AddShow">Add Show</button> 
            <router-link to="/editMovie">
            <button type="button" class="view-order">Cancel</button> 
            </router-link>
        </div>
    </div><!--End Login-->

</div>

</template>

<script>
import http from "../http-common";
import router from "../router/index";
export default{
    data(){
        return{
             movieID:"",
             movieObj:"",
             screens:"",
             Warning:"",
             selectedScreenId:"",
             showObjList:"",
             showObj:""
        }
    },
    methods:{
        AddShow(){
            var userInput=document.getElementsByClassName("userInput");
            //  Validation 
            // 1. check empty 
            for (let i=0; i<userInput.length;i++){
               if (userInput[i].value==""){
                   this.Warning="All blank should be filled";
                   return;
               }
            }

            // Make A new ShowObj And Input to database 
            let newShow={
                date:userInput[0].value,
                startTime:userInput[1].value,
                endTime:userInput[2].value
            };
            console.log(newShow.date);
            console.log(newShow.startTime);
            console.log(newShow.endTime);

            this.showObj=newShow;
            console.log("newShow"+this.showObj);

            // Put the movieID into ShowController.tempMovieID
            // Put the ScreenID into ShowController.tempScreenID
            http.post("/PutMovieID?id="+this.movieID);
            http.post("/PutScreenID?id="+this.selectedScreenId);
          

            // put in database 
            http.post("/shows",newShow).catch((e)=>e.response.data);
            alert("Show added success");
            router.push("/editMovie");              
        },
        OnChangeScreen(){
            var userInput=document.getElementsByClassName("userInput");
          
            this.selectedScreenId=userInput[4].value*1;
            console.log(this.selectedScreenId);
        },

        sleep(milliseconds) {
        const date = Date.now();
        let currentDate = null;
        do {
        currentDate = Date.now();
        } while (currentDate - date < milliseconds);
}

    },
    mounted(){
        // Get movie by the id from edit movie
        this.movieID=localStorage.getItem("thisMovie");  
        http.get("/movies/"+this.movieID)
        .then((response)=>
            this.movieObj= response.data
        ).catch((e)=>console.log(e.response.data))

        // Get All screens 
        http.get("/screens")
        .then((response)=>
        this.screens=response.data
        ).catch((e)=>console.log(e.response.data))
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