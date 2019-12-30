<template>
    <div>
        <ul> <v-if> <router-link :to="'/tag/'+tag.name">{{tag.name}}</router-link></v-if></ul>
        <ul>
            <v-if>
                <oneTag
                        v-for="child in tag.childCategory" :key="child.idtag"  :tag="child">

                </oneTag>
            </v-if>
        </ul>
    </div>


</template>

<script>
    export default {
        name: 'oneTag',
        props: ['tag'],
        msg:'/tag/root'
    }
</script>