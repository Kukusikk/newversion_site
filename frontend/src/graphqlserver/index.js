// 1
import { ApolloClient } from 'apollo-client'
import { HttpLink } from 'apollo-link-http'
import { InMemoryCache } from 'apollo-cache-inmemory'
import 'tachyons'
import Vue from 'vue'
// 2
import VueApollo from 'vue-apollo'
//import router from "@/router";


Vue.config.productionTip = false

// 3
const httpLink = new HttpLink({
    // You should use an absolute URL here
    uri: 'http://localhost:8080/graphql'
})

// 4
const apolloClient = new ApolloClient({
    link: httpLink,
    cache: new InMemoryCache(),
    connectToDevTools: true
})

// 5
Vue.use(VueApollo)

// 6
const apolloProvider = new VueApollo({
    defaultClient: apolloClient,
    defaultOptions: {
        $loadingKey: 'loading'
    }
})

export default apolloProvider

/* eslint-disable no-new */
