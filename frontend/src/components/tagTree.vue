{link.iduser}}  -
<template>
    <div>

        <oneTag
                :tag="findRootTag">eeeeeeeeeeee
        </oneTag>
    </div>
</template>

<script>
    import oneTag from './oneTag'
    import { FINDROOTTAG } from '../constants/graphql'

    export default {
        name: 'tagTree',
        data () {
            return {
                findRootTag: {},
                loading: 0
            }
        },
        components: {
            oneTag
        },
        apollo: {
            findRootTag: {
                query: FINDROOTTAG
            }
        }
    }
</script>