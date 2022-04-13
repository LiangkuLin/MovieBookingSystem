<template>
  <div>
    <NavBar />
  </div>

  <div class="table-wrapper">
    <h1>Your Reservations</h1>
    <table class="fl-table">
      <thead>
        <tr>
          <th>Movie</th>
          <th>Screen</th>
          <th>Tickets</th>
          <th>Total Cost</th>
          <th>Edit</th>
        </tr>
      </thead>
      <tbody v-for="order in orders" :key="order.reservationId">
        <tr>
          <!--suggestion: move the show_id property to the reservation class in order to get movie info for the order  -->
          <td>{{ order.movie + ""}}</td>
          <td>{{ order.screens+"" }}</td>
          <td>{{ order.numberOfTickets }}</td>
          <td>{{ order.totalCost }}$</td>
          <td>
            <div class="edit-button">
              <router-link to="/orderdetail">
                <button type="submit" class="view-detail">View Details</button>
              </router-link>
              <form action="#">
                <button type="button" class="cancle"  @click="DeleteOrder(order)">Cancle</button>
              </form>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";
import http from "../http-common.js";
// new
import router from "../router/index";

export default {
  name: "OrderList",
  components: {
    NavBar,
  },
  data() {
    return {
      orders: [],
      user: "",
      movieList: [],
      screnList:[],
    };
  },
  methods: {
      DeleteOrder(order){

         this.user = JSON.parse(sessionStorage.getItem("LoginUserID"));
         let userID = this.user.userId;
            console.log("DDDDD:"+ JSON.stringify(order));
        http.put(`/users/${userID}/reservation/${order.reservationId}`)
        .then((res)=>console.log("RES: "+res.data))
        .catch(e=>console.log(e.response.data));
      
        alert("Delete Success");
        router.go(0);
      }
  },
  mounted() {
    // This page should be login first, this is the method to filter the unlogin user
    if (sessionStorage.getItem("LoginUserID") == null) {
      alert("Please login to use this function");
      router.push("/login");
      return;
    }

    // Get user ID in  order to use controller
    this.user = JSON.parse(sessionStorage.getItem("LoginUserID"));
    let userID = this.user.userId;
    console.log("userID: " + userID * 1);

    http
      .get("/reservations/" + userID * 1)
      .then((response) => {
        this.orders = response.data;
        console.log("order: " + this.orders + this.orders.length);
        console.log("Check: " + this.orders.length);
        for (let i = 0; i < this.orders.length; i++) {
          console.log("reservationId : " + this.orders[i].reservationId);
          // this.orders[i].movie=this.getMovieList(this.orders[i].reservationId*1); // this should be array
          http
            .get("/reservationsGetMovie/" + this.orders[i].reservationId)
            .then((res) => {
                //console.log(res.data);
                console.log(this.orders[i]);
                this.orders[i].movie = res.data;
                console.log(this.orders[i].movie);
                //this.orders[i].movie = res.data;
                this.movieList = this.orders[i].movie;
            
                console.log("fuck?" + this.movieList);
            })
                .catch((e) => console.log(e.res.data));


            http
            .get("/reservationsGetScreen/" + this.orders[i].reservationId)
            .then((res) => {
              console.log(this.orders[i]);
              this.orders[i].screens = res.data;
              console.log(this.orders[i].screens);
              this.screnList = this.orders[i].screens;
              console.log("fuck?" + this.movieList);
            })
            .catch((e) => console.log(e.res.data));

        }
        console.log("movieList: " + this.movieList);
      })
      .catch((e) => {
        console.log(e.response.data);
      });

    // new 
         
        
  },
};
</script>
<style scoped>
* {
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
}
body {
  font-family: Helvetica;
  -webkit-font-smoothing: antialiased;
  background: rgba(71, 147, 227, 1);
}
h2 {
  text-align: center;
  font-size: 18px;
  text-transform: uppercase;
  letter-spacing: 1px;
  color: white;
  padding: 30px 0;
}

/* Table Styles */

.table-wrapper {
  margin: 10px 70px 70px;
  box-shadow: 0px 35px 50px rgba(0, 0, 0, 0.2);
}

.fl-table {
  border-radius: 5px;
  font-size: 12px;
  font-weight: normal;
  border: none;
  border-collapse: collapse;
  width: 100%;
  max-width: 100%;
  white-space: nowrap;
  background-color: rgb(224, 219, 219);
}

.fl-table td,
.fl-table th {
  text-align: center;
  padding: 8px;
}

.fl-table td {
  border-right: 1px solid #f8f8f8;
  font-size: 12px;
}

.fl-table thead th {
  color: #ffffff;
  background: #4fc3a1;
}

.fl-table thead th:nth-child(odd) {
  color: #ffffff;
  background: #324960;
}

.fl-table tr:nth-child(even) {
  background: #f8f8f8;
}

/* Responsive */

@media (max-width: 767px) {
  .fl-table {
    display: block;
    width: 100%;
  }
  .table-wrapper:before {
    content: "Scroll horizontally >";
    display: block;
    text-align: right;
    font-size: 11px;
    color: white;
    padding: 0 0 10px;
  }
  .fl-table thead,
  .fl-table tbody,
  .fl-table thead th {
    display: block;
  }
  .fl-table thead th:last-child {
    border-bottom: none;
  }
  .fl-table thead {
    float: left;
  }
  .fl-table tbody {
    width: auto;
    position: relative;
    overflow-x: auto;
  }
  .fl-table td,
  .fl-table th {
    padding: 20px 0.625em 0.625em 0.625em;
    height: 60px;
    vertical-align: middle;
    box-sizing: border-box;
    overflow-x: hidden;
    overflow-y: auto;
    width: 120px;
    font-size: 13px;
    text-overflow: ellipsis;
  }
  .fl-table thead th {
    text-align: left;
    border-bottom: 1px solid #f7f7f9;
  }
  .fl-table tbody tr {
    display: table-cell;
  }
  .fl-table tbody tr:nth-child(odd) {
    background: none;
  }
  .fl-table tr:nth-child(even) {
    background: transparent;
  }
  .fl-table tr td:nth-child(odd) {
    background: #f8f8f8;
    border-right: 1px solid #e6e4e4;
  }
  .fl-table tr td:nth-child(even) {
    border-right: 1px solid #e6e4e4;
  }
  .fl-table tbody td {
    display: block;
    text-align: center;
  }
}

button {
  /* display: flex; */
  margin: 10px;
  width: 100px;
  height: 30px;
  border-radius: 8px;
  border-color: #eee;
}
.view-detail {
  background: #4fc3a1;
}
.cancle {
  background: #c5c9c8;
}
</style>