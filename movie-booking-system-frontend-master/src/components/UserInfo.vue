<template>
<!-- this component may nor may not be used -->
    <div>
        <NavBar/>
        <div class="user-info">

        </div>
        <OrderList/>
    </div>
</template>

<script>
import NavBar from './NavBar.vue'
import OrderList from './OrderList.vue'
export default {
    name: "UserInfo",
    components: {
        NavBar,
        OrderList
    }

    
}
</script>
<style scoped>

</style>