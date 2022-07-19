import Content from '../components/content';
import { useState, useEffect } from 'react';
import { getSession, useSession } from 'next-auth/react';
import { postSignUpAPI } from '../lib/api/user';


const HomePage = () => {  
  
  const { data: session, status} = useSession();
  const [properties, setProperties] = useState([]);
  const [signin, setSignin] = useState({});

  const Email = {
    email : session?.user.email
  }

  // useEffect(async () => {
  //   const res = await fetch('http://localhost:8080/category/totalinfo',{
  //     method:'POST',
  //     headers : {
  //         'Content-Type':'application/json'
  //     },
  //     body: JSON.stringify(Email)
  //   }); 

  //   const responsedData = await res.json();
    
  //   setProperties(responsedData);
  
  // }, []);

  // useEffect(async () => {
  //     const res = await fetch('http://localhost:8080/user/signin', {
  //       method: 'POST',
  //       headers: {
  //         'Content-Type': 'application/json',
  //       },
  //       body: JSON.stringify(Email),
  //     });
  //     const userResponseData = await res.json();
  //     setSignin(userResponseData);
  //   }, []);


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
