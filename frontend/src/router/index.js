import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Authorization from '../views/Authorization.vue'
import Registration from '../views/Registration.vue'
import Profile from '../views/Profile.vue'
import Cart from '../views/Cart.vue'
import Tag from '../views/Tag.vue'
import Createpost from '../views/Createpost.vue'
import Product from '../views/Product.vue'


Vue.use(VueRouter)

//здесь прописываются все маршруты и компоненты на которые ведут эти пути

const routes = [
    //авторизация
  {
    path: '/authorization',
    name: 'authorization',
    component: Authorization
  },
    //регистрация
  {
    path: '/registration',
    name: 'registration',
    component: Registration
  },
  //профиль
  {
    path: '/profile/:login',
    name: 'profile',
    component: Profile
  },
  //корзина
  {
    path: '/cart/:login',
    name: 'home',
    component: Cart
  },
  //продукт
  {
    path: '/product/:id',
    name: 'product',
    component: Product
  },

  //переход по тэгу
  {
    path: '/tag/:name',
    name: 'tag',
    component: Tag
  },

    //домашняя страница
  {
    path: '/',
    component: Home
  },
    //путь создания нового поста
  {
    path: '/Сreatepost',
    name: 'Сreatepost',
    component: Createpost
    }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
