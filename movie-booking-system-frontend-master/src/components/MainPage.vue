<template>
    <NavBar/>
    <h1>Welcome to Movie Booking System</h1>
    <SearchBar/>
    <MovieList/>
    
</template>

<script>
import SearchBar from './SearchBar.vue'
import MovieList from  './MovieList.vue'
import NavBar from './NavBar.vue'
export default {
    name: "MainPage",
    components: {
        SearchBar,
        MovieList,
        NavBar
    },
}
</script>

<style scoped>

</style>