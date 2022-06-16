import Content from '../components/content';
import { useState, useEffect } from 'react';
import { getSession, useSession } from 'next-auth/react';
import { postSignUpAPI } from '../lib/api/user';


const HomePage = () => {  

  const { data: session} = useSession();
  // console.log("주냐",[session?.user.email][0]);
  const [properties, setProperties] = useState({});

  // [session?.user.email][0]
  
  const userEmail ={
    email : "deepbluedream8714@gmail.com"
  }

  useEffect(async () => {
    const res = await fetch('http://localhost:8080/category/totalinfo',{
      method:'POST',
      headers : {
          'Content-Type':'application/json'
      },
      body: JSON.stringify(userEmail)
    }); 

    const responsedData = await res.json();
    
    setProperties(responsedData);
  
  }, []);

  const signup = () => {
    const data = {
      email: session?.user.email,
    };
    postSignUpAPI(data);
    console.log("실행됨?");
  };
  
  if (session == null) {
    return (
      <Content title="Home" />
      )
  }
    return (     
   <Content properties={properties} title="status" /> 
   )
  
    
}

export default HomePage;
