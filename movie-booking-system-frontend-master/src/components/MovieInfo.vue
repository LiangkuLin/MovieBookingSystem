<template>
<div class="table-wrapper">
    <figure class="movie">
        <div class="movie__hero">
            <img src="https://www.mensjournal.com/wp-content/uploads/2018/10/rambo-main-3.jpg?quality=86&strip=all" alt="Rambo" class="movie__img">
        </div>
        <div class="movie__content">
            <div class="movie__title">
            <h1 class="heading__primary">Movie Name: {{movie.title}} <i class="fas fa-fire"></i></h1>
            <div class="movie__tag movie__tag--1">{{movie.category}}</div>
            <div class="movie__tag movie__tag--2">{{movie.category}}</div>
            </div>
            <p class="movie__description">
            Description: {{movie.description}}
            </p>
            <div class="movie__details">
            <p class="movie__detail"><span class="icons icons-red"><i class="fas fa-camera-retro"></i> </span>Duration:</p>
            <p class="movie__detail"><span class="icons icons-grey"><i class="fas fa-clock"></i> </span>{{movie.durationMins}}</p>
            <p class="movie__detail"><span class="icons icons-yellow"><i class="fas fa-file-invoice-dollar"></i>
                </span> &#9734; &#9734; &#9734; &#9734; &#9734; </p>
            </div>
        </div>
    </figure>
</div>


</template>

<script>
import http from "../http-common.js";

export default {
    name: "MovieInfro",
    components: {

    },
    data(){
        return {
            movie: {}
        };
    },
    methods(){
        
    },
    mounted(){
         http
        .get("/movies/7")
        .then((response) => {
                this.movie = response.data;
                console.log(this.movie);
            }
        ).catch(
            (e) => {
                console.log(e.response.data);
            }
        );
    }

    
}
</script>
<style scoped>
    /*  
background-color: #A9C9FF;
background-image: linear-gradient(180deg, #A9C9FF 0%, #FFBBEC 100%);

*/
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 300;
    color: #444;
    background:linear-gradient(to right bottom, #4FC3A1 0%, #FFBBEC 100%); 
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

.movie {
    /* max-width: 1000px; */
    border-radius: 5px;
    display: flex;
    box-shadow: 0 5px 20px 10px rgba(0, 0, 0, .2);
   overflow: hidden;
}

.movie__hero {
  flex: 0 0 45%;
}

.movie__img {
    width: 100%;
    display: block;
}

.movie__content {
    background-color: #fff;
    flex: 1;
    padding: 35px 30px;
    display: flex;
    flex-direction: column;
}

.movie__title {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.heading__primary {
    font-size: 26px;
    margin-right: auto;
    color: #4FC3A1;
}

.fa-fire {
    color: salmon;
}

.movie__tag {
    font-size: 15px;
    color: #fff;
  padding: 2px 7px;
  border-radius: 100px;
  margin-right: 8px;
  display: block;
  text-transform: uppercase;

}

.movie__tag--1 {
  background-color: #A9C9FF;
}

.movie__tag--2 {
    background-color:#4FC3A1;
}

.movie__description {
    font-size: 15px;
}

.movie__details {
    display: flex;
    margin: auto;
}

.movie__detail {
   font-size: 15px;
   margin-right: 20px;
   display: flex;
   align-items: center;
   
}

.icons i {
    margin-right: 3px;
    font-size: 18px;
}

.icons-red {
    color: salmon;
}
.icons-grey {
    color: grey;
}

.icons-yellow {
    color: rgb(190, 190, 71);

}
/* for show list */
*{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}
body{
    font-family: Helvetica;
    -webkit-font-smoothing: antialiased;
    background: rgba( 71, 147, 227, 1);
}
h2{
    text-align: center;
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: white;
    padding: 30px 0;
}

/* Table Styles */

.table-wrapper{
    margin: 10px 70px 70px;
    box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
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
    background-color: white;
}

.fl-table td, .fl-table th {
    text-align: center;
    padding: 8px;
}

.fl-table td {
    border-right: 1px solid #f8f8f8;
    font-size: 12px;
}

.fl-table thead th {
    color: #ffffff;
    background: #4FC3A1;
}


.fl-table thead th:nth-child(odd) {
    color: #ffffff;
    background: #324960;
}

.fl-table tr:nth-child(even) {
    background: #F8F8F8;
}

/* Responsive */

@media (max-width: 767px) {
    .fl-table {
        display: block;
        width: 100%;
    }
    .table-wrapper:before{
        content: "Scroll horizontally >";
        display: block;
        text-align: right;
        font-size: 11px;
        color: white;
        padding: 0 0 10px;
    }
    .fl-table thead, .fl-table tbody, .fl-table thead th {
        display: block;
    }
    .fl-table thead th:last-child{
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
    .fl-table td, .fl-table th {
        padding: 20px .625em .625em .625em;
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
        background: #F8F8F8;
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tr td:nth-child(even) {
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tbody td {
        display: block;
        text-align: center;
    }
   
}

</style>