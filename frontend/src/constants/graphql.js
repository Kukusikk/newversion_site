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