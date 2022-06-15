import Content from '../components/content';
import { useState } from 'react';
import { useSession } from 'next-auth/react';

const HomePage = (props) => {  
  const { data: session} = useSession();
  const [cate, setCate] = useState([]);
  const userCategories = props.categories;
  // const userBookMarks = props.userInfo.userBookMarks;
  const userBookMarks = props.userBookMarks;

  if (session == null) {
  return (
  <Content title="Home" category={[]}/>
 
    )
  }

  return (
  <>
  <Content title="Home"category={userCategories}/>
  
  {/* bookMarkData = {userBookMarks} */}
  </>
  )
}
export const getServerSideProps = async () => {
  try {
    const res = await fetch('http://localhost:8080/totalinfo',{
      method:'POST',
      headers : {
          'Content-Type':'application/json'
      },
      body: JSON.stringify(data)
    });
    const categories = await res.json();
    console.log(categories);
    
    return { 
      // props: {categoriesTest}
      props: { categories } 
      // 그 프로퍼티의 값은 객체
    }

  } catch (error) { 
    console.log(error);
    return { props: {} }
    }
  }
// 1. 서버에서 받아온 category.json 데이터 props로 전달 작업
export default HomePage;
