import { createWebHashHistory, createRouter } from "vue-router"
import MainPage from "../components/MainPage"
import MovieDetail from "../components/MovieDetail"
import SeatPage from "../components/SeatPage"
import UserInfo from "../components/UserInfo"
import OrderList from "../components/OrderList"
import OrderDetail from "../components/OrderDetail"

// new 
import LoginPage from "../components/LoginPage"
import registerPage from "../components/RegisterPage"
import EditMovie from "../components/EditMovie"
import AddMovie from "../components/AddMovie"
import AddShow from "../components/AddShow"


const routes = [
    {
        path: "/",
        name: "MainPage",
        component: MainPage
    }, 
    {
        path: "/moviedetail",
        name: "MovieDetail",
        component: MovieDetail
    }, 
    {
        path: "/seats",
        name: "SeatPage",
        component: SeatPage
    }, 
    {
        path: "/userinfo",
        name: "UserInfo",
        component: UserInfo
    }, 
    {
        /// need to include a dynamic param id
        path: "/orders",
        name: "OrderList",
        component: OrderList
    },
    {
        /// need to include a dynamic param id
        path: "/orderdetail",
        name: "OrderDetail",
        component: OrderDetail
    },


    // new
    {
        path: "/login",
        name: "Login",
        component: LoginPage
    },
    {
        path: "/register",
        name: "Register",
        component: registerPage
    },
    {
        path: "/editMovie",
        name: "EditMovie",
        component: EditMovie
    },
    {
        path: "/addmovie",
        name: "Addmovie",
        component: AddMovie
    },
    {
        path: "/addShow",
        name: "AddShow",
        component: AddShow
    }

];
const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

export default router;