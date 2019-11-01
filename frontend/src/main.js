import Vue from 'vue'
import App from './App.vue'

import apolloProvider from './graphqlserver'
import router from './router'
import tagTree from './components/tagTree'
import testlistgraphql from './components/testlistgraphql'

Vue.config.productionTip = false

Vue.component('testlistgraphql', testlistgraphql);
Vue.component('tagTree', tagTree);

new Vue({
  router,
  provide: apolloProvider.provide(),

  render: h => h(App)
}).$mount('#app')



