// 1
import gql from 'graphql-tag'

// 2
export const ALL_LINKS_QUERY = gql`
query AllLinksQuery {
  testList (testname2: "firsttestname", testname1:"secondtestname"){
    iduser
    login
    phone
    photo
  }
}
  `

export const FINDALLTAGS_QUERY = gql`
query findAllTags {
  findAllTags {
    idtag
    level
    name
  }
}
  `

/*export const FINDROOTTAG = gql`
query{
  findRootTag{
    childCategory{
      childCategory{
        childCategory{
          childCategory{
            childCategory{
              idtag
              level
              name
            }
            idtag
            level
            name
          }
          idtag
          level
          name
        }
        idtag
        level
        name
      }
      idtag
      level
      name
    }
    idtag
    level
    name
  }
}
  `



*/


export const FINDROOTTAG = gql`
query findRootTag {
  findRootTag{
    childCategory{
      childCategory{
        childCategory{
          childCategory{
            childCategory{
              idtag
              level
              name
            }
            idtag
            level
            name
          }
          idtag
          level
          name
        }
        idtag
        level
        name
      }
      idtag
      level
      name
    }
    idtag
    level
    name
  }
}`




