<template>
    <div>
        <NavBar/>
    </div>
    
  <div id="invoice-POS">
    
    <center id="top">
      <div class="logo"></div>
      <div class="info"> 
        <h2>Movie Tickes Invoice</h2>
      </div><!--End Info-->
    </center><!--End InvoiceTop-->
    
    <div id="mid">
      <div class="info">
        <h2>Contact Info</h2>
        <p> Customer name: Carrie<br>Phone Number: 7786826932<br>Email : carriechen188@gmai.com<br></p>
      </div>
    </div><!--End Invoice Mid-->
    
    <div id="bot">

        <div id="table">
            <table>
                <tr class="tabletitle">
                    <td class="item"><h2>Ticket ID</h2></td>
                    <td class="Hours"><h2>Seat ID</h2></td>
                    <td class="Rate"><h2>Sub Total</h2></td>
                </tr>

                <tr class="service">
                    <td class="tableitem"><p class="itemtext">Ticket 1</p></td>
                    <td class="tableitem"><p class="itemtext">0101</p></td>
                    <td class="tableitem"><p class="itemtext">$35.00</p></td>
                </tr>

                <tr class="service">
                    <td class="tableitem"><p class="itemtext">Ticket 2</p></td>
                    <td class="tableitem"><p class="itemtext">0103</p></td>
                    <td class="tableitem"><p class="itemtext">$25.00</p></td>
                </tr>

                <tr class="service">
                    <td class="tableitem"><p class="itemtext">Ticket 3</p></td>
                    <td class="tableitem"><p class="itemtext">0105</p></td>
                    <td class="tableitem"><p class="itemtext">$35.00</p></td>
                </tr>
                <tr class="service">
                    <td class="tableitem"><p class="itemtext">Ticket 4</p></td>
                    <td class="tableitem"><p class="itemtext">0110</p></td>
                    <td class="tableitem"><p class="itemtext">$50.00</p></td>
                </tr>


                <tr class="tabletitle">
                    <td></td>
                    <td class="Rate"><h2>tax</h2></td>
                    <td class="payment"><h2>$19.25</h2></td>
                </tr>

                <tr class="tabletitle">
                    <td></td>
                    <td class="Rate"><h2>Total</h2></td>
                    <td class="payment"><h2>$644.25</h2></td>
                </tr>
            </table>
        </div><!--End Table-->

        <div id="legalcopy">
            <p class="legal"><strong>Thank you for your business!</strong><br>Payment is expected within 31 days; please process this invoice within that time. There will be a 5% interest charge per month on late invoices. 
            </p>
        </div>
    
    </div><!--End InvoiceBot-->
        <div>
            <router-link to="/">
            <button type="button" class="log-out">Logout</button>
            </router-link>
            <router-link to="orders">
            <button type="button" class="view-order">View Orders</button>
            </router-link>
        </div>
  </div><!--End Invoice-->

</template>

<script>
import NavBar from './NavBar.vue'
export default {
    name: "OrderDetail",
    components: {
        NavBar
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

</style>