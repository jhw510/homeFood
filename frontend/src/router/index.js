import Vue from "vue";
import VueRouter from "vue-router";
import Join from "../components/Join";
import Login from "../components/Login";
import HelloWorld from "../components/HelloWorld";
import SearchPage from "../components/SearchPage";
import Test from "../components/Test";

Vue.use(VueRouter);

export  default  new VueRouter({
    mode:"history",
    base:process.env.BASE_URL,
    routes:[
        {path:"/join",component: Join},
        {path:"/",component: HelloWorld},
        {path:"/login",component: Login},
        {path:"/searchPage", component: SearchPage},
        {path: "/food",component: Test},
    ]
});
