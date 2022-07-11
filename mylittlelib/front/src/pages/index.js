import Content from '../components/content';
import { useState, useEffect } from 'react';
import { getSession, useSession } from 'next-auth/react';
import { postSignUpAPI } from '../lib/api/user';


const HomePage = () => {  
  
  const { data: session, status} = useSession();
  // console.log("주냐",[session?.user.email][0]);
  const [properties, setProperties] = useState([]);
  const [signin, setSignin] = useState({});
  console.log("세션임 ",session);
  console.log("이메일 벗김",session?.user.email);
  
  const userEmail ={
    email : "deepbluedream8714@gmail.com"
  }
  // console.log("이메일 벗김", session?.user.email);
  // const userEmail = status === "authenticated" ? session.email : ""
  // wait(3000);
  const Email = {
    email : session?.user.email
  }

  useEffect(async () => {
    const res = await fetch('http://localhost:8080/category/totalinfo',{
      method:'POST',
      headers : {
          'Content-Type':'application/json'
      },
      body: JSON.stringify(Email)
    }); 

    const responsedData = await res.json();
    
    setProperties(responsedData);
  
  }, []);

  useEffect(async () => {
      const res = await fetch('http://localhost:8080/user/signin', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(Email),
      });
      const userResponseData = await res.json();
      setSignin(userResponseData);
      console.log("50번째 줄",userResponseData);
      console.log(typeof(userResponseData));
      
    }, []);


  // singin.error or singin.signedIn
  console.log("55번쨰 줄",signin.error);
  // if(signin.error )
  console.log("57번째 줄", signin.error === "login failed");


  console.log("로그인:", signin.signedIn);
  console.log("뭐가 진짜야", session == null || signin.signedIn);

  if (session === null) {
    return (
      <Content signin={signin.signedIn} properties={properties} title="Status" /> 
      )
    }
    return (     
      <Content signin={signin.signedIn} title="Docs" properties={properties} />
   )
  
    
}

export default HomePage;
