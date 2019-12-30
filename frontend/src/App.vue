

<template>
  <div id="app">

      <table width="100%" >
        <tr>
          <td  width="33.3%" align="left"><router-link to="/Сreatepost">Разместить объявление</router-link></td>
          <td width="33.3%" align="center"><router-link to="/">Главная</router-link></td>
          <td width="33.3%" align="right"> тут будет компонент контекстная кнопка но она еще не сделана</td>
        </tr>
      </table>

      <table width="100%" >
        <tr>
          <td  width="5%" ></td>
          <td width="65%" align="center"><router-view/></td>
          <td width="30%" align="left">  <tagTree></tagTree> </td>
        </tr>
      </table>
      <p>поле для тестирования:<testlistgraphql></testlistgraphql>></p>





  </div>
</template>


