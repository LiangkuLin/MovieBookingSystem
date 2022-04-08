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
         <h1>Add Movie</h1>
         <form action="">
            Movie Title:<br>
            <input type="text" class="userInput"><br><br>
            Movie Discription: <br>
            <input type="text" class="userInput"> <br><br>
            Movie Duration (Min): <br>
            <input type="number" class="userInput"> <br><br>
            Movie Category: <br>
            <input type="text" class="userInput"> <br><br>
            ReleaseDate: <br>
            <input type="date" class="userInput"> <br><br>
            <span class="warning">{{Warning}}</span><br>
         </form>
        
    </div><!--End Login Page-->
    

    
   <div id="bot">
        <div id="legalcopy">
            <p class="legal"><strong>Thank you for your business!</strong><br>Please contact Carrie if any error happens. 
            </p>
        </div>
    
    </div><!--End LoginBot-->
    <div>
        <div>
            <button type="button" @click="AddMovie">Add Movie</button> 
            <router-link to="/editMovie">
            <button type="button" class="view-order">Cancel</button> 
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
           
        }
    },
    methods:{
        AddMovie(){
            var userInput= document.getElementsByClassName("userInput");

            // Validation first 
            // 1. Check empty
            for (let i=0;i< userInput.length;i++){
                if (userInput[i].value==""){
                    this.Warning="No empty blank allowed"
                    return;
                }
            }
            // 2. Check Duration is valid (Mins > 0) 
            if (userInput[2].value*1<=0){
                this.Warning="Movie duration is not valid"
                return;
            }


            // Create Movie obj and input to database 
            let newMovie={
                title:userInput[0].value,
                description:userInput[1].value,
                durationMins:userInput[2].value,
                category:userInput[3].value,
                releaseDate:userInput[4].value
            };

            http.post("/movies",newMovie);
            alert("Movie has successfully created");
            router.push("/editMovie");
          
            
        },
    },
    mounted(){
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