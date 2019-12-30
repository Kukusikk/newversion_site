<template>
    <div>
        <table>
            <tr>
                <td  width="20%" align="left"><input type="radio" id="price" value="price" v-model="SortingPrinciple">
                                              <label for="price">По стоимости </label>
                                              <br>
                                              <input type="radio" id="popularity" value="popularity" v-model="SortingPrinciple">
                                              <label for="popularity">По популярности</label>
                                              <br>
                                              <input type="radio" id="date" value="age" v-model="SortingPrinciple">
                                              <label for="date">По дате</label>
                                               <br></td>
                <td  width="75%" align="left"><input v-model="nameabs" placeholder="поиск по объявлению"></td>
                <td  width="5%" align="left"><button v-on:click="counter += 1">Поиск</button></td>
            </tr>
            <tr>

            <td  width="20%" align="left">
                <p><input v-model="toprice" placeholder="верхняя цена"></p>
                <p> <input v-model="lowprice" placeholder="нижняя цена"></p>
            </td>
                <td  width="80%" align="left">
                    <p>Тэг</p>
                    <p>здестъь будет выпадающий список тэгов но потом  <button v-on:click="counter += 1">Добавить тэг</button></p>

                </td>
            </tr>
        </table>


    </div>


</template>

<script>
    export default {
        name: 'searchLine',
        props: ['zz'],
        data () {
            return {
                SortingPrinciple: '',
                nameabs: '',
                toprice:0,
                lowprice:0,
                tag:{
                    idtag:'',
                    nameTag:''
                }
            }
        },
    }
</script>