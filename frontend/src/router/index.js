import Vue from 'vue'
import VueRouter from 'vue-router'




var Home = require('./views/Home.vue')
var Createadverciment = require('./views/Createadverciment.vue')


Vue.use(VueRouter)



const routes = [
  {
    path: '/home',
    component: Home
  },
  {
    path: '/createadverciment',
    component: Createadverciment
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
