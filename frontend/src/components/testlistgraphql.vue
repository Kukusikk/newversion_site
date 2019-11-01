{link.iduser}}  -
<template>
    <div>
        <testgraphql
                v-for="link in testList" :key="link.iduser" :link="link">
        </testgraphql>
    </div>
</template>

<script>
    import testgraphql from './testgraphql'
    import { ALL_LINKS_QUERY } from '../constants/graphql'

    export default {
        name: 'testlistgraphql',
        data () {
            return {
                testList: [],
                loading: 0
            }
        },
        components: {
            testgraphql
        },
        apollo: {
            testList: {
                query: ALL_LINKS_QUERY
            }
        }
    }
</script>