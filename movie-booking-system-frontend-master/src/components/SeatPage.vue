<template>
    <div>
        <NavBar/>
        <div class="seats">
            <ul class="showcase">
                <li>
                    <div class="seat"></div>
                    <small>Available</small>
                </li>
                <li>
                    <div class="seat selected"></div>
                    <small>Selected</small>
                </li>
                <li>
                    <div class="seat sold"></div>
                    <small>Sold</small>
                </li>
            </ul>
            <div class="container">
                <div class="screen"></div>
                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat"  @click="select"></div>
                    <div class="seat" @click="select"></div>
                </div>

                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                </div>
                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                </div>
                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                </div>
                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                </div>
                <div class="row">
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat" @click="select"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat" @click="select"></div>
                </div>
                </div>
            <p class="text">You have selected <span id="count">0</span> seat for a price of RS.<span id="total">0</span></p>
            <router-link to="/orderdetail"><button type="submit">Buy Tickets</button></router-link> 
        </div>

    </div>
    

</template>

<script>
import NavBar from './NavBar.vue'

export default {
    name: "SeatPage",
    components: {
        NavBar
    },
    data(){
        return {
            count: 0
        };
    },
    methods:{
        select(e) {
                if (
                    e.target.classList.contains("seat") &&
                    !e.target.classList.contains("sold")
                ) {
                    e.target.classList.toggle("selected");
                    // this.getElementById("count").innerText =  8888;
                    this.count +=1;
                    // updateSelectedCount();
                }
         },
        // updateSelectedCount(){
            
        // }

    },
    mounted(){

    }

    
}
</script>
<style scoped>
.seats {
  box-sizing: border-box;
}

.seats {
  background-color: rgb(155, 150, 150);
  color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  font-family: "Lato", sans-serif;
  margin-top: 80px;
  box-sizing: border-box;
  border-radius: 50px;
}

.movie-container {
  margin: 10px 0;
}

.movie-container select {
  background-color: #fff;
  border: 0;
  border-radius: 5px;
  font-size: 16px;
  margin-left: 10px;
  padding: 5px 15px 5px 15px;
  -moz-appearance: none;
  -webkit-appearance: none;
  appearance: none;
}

.container {
  perspective: 1000px;
  margin-bottom: 30px;
}

.seat {
  background-color: #444451;
  height: 26px;
  width: 32px;
  margin: 3px;
  font-size: 50px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  
}

.seat.selected {
  background-color: green;
}

.seat.sold {
  background-color: #fff;
}

.seat:nth-of-type(2) {
  margin-right: 18px;
}

.seat:nth-last-of-type(2) {
  margin-left: 18px;
}

.seat:not(.sold):hover {
  cursor: pointer;
  transform: scale(1.2);
}

.showcase .seat:not(.sold):hover {
  cursor: default;
  transform: scale(1);
}

.showcase {
  background: rgba(0, 0, 0, 0.1);
  padding: 5px 10px;
  border-radius: 5px;
  color: #777;
  list-style-type: none;
  display: flex;
  justify-content: space-between;
}

.showcase li {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 10px;
}
.showcase li small {
  margin-left: 2px;
}

.row {
  display: flex;
}

.screen {
  background-color: #fff;
  height: 120px;
  width: 100%;
  margin: 15px 0;
  transform: rotateX(-48deg);
  box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
}

p.text{
    margin: 5px 0;
}

p.text span{
    color: green;
}

button {
    text-decoration: none;
    margin-top: 20px;
    border-radius: 20px;
    height: 40px;
    width: 200px;
    border-color: rgb(216, 213, 213);
    background: #4FC3A1;
  

}
</style>