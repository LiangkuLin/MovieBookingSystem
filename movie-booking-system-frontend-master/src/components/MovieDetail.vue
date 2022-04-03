<template>
    <div>
        <NavBar/>
        <MovieInfo/>
        <ShowList/>
        
    </div>

</template>

<script>
import MovieInfo from '../components/MovieInfo.vue'
import ShowList from '../components/ShowList.vue'
import NavBar from './NavBar.vue'
export default {
    name: "MovieDetail",
    components:{
        MovieInfo,
        ShowList,
        NavBar
    }
}
</script>
<style scoped>

</style>