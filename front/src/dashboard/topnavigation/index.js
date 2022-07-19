import { useToggle } from '../provider/context';
import { useMemo, useState,useEffect } from 'react';
import SignUpModal from '../../modal/SignUpModal';
import { findCategoryAPI } from '../../lib/api/category';
import { Router, useRouter } from 'next/router';
import { useSession } from "next-auth/react"
import { signIn, signOut } from 'next-auth/react'
import LoginModal from '../../modal/LoginModal';



export default function TopNavigation() {
  const router = useRouter();
  const [loginModalOn, setLoginModalOn] = useState(false);
  // const [signUpModalOn, setSignUpModalOn] = useState(false);
  const [userInfo2, setUserInfo2] = useState({});
  const [search, setSearch] = useState("");
  const [getsearch, setgetSearch] = useState("");
  const [properties, setProperties] = useState("");

  const loginClicked = () => {
    setLoginModalOn(true)
  }

  // const signUpClicked = () => {
  //   setSignUpModalOn(true)
  // }
  

  const searchHandler = (event) =>{
        setSearch(event.target.value);
  }
  const handleOnSubmit = (e) => {
    e.preventDefault();
    setgetSearch(search);
    findCategory();
    setSearch("");
    setgetSearch("");
    }


  // 세션 확인
  const { data: session, status } = useSession();

  const findCategory = async () =>{
        const data = {
            categoryTitle: search, //임의의 유저 번호 부여, BE 요청 방식과 naming 동일하게 진행
 
    };

    findCategoryAPI(data).then(res => {
      const reponse = res.json();
      setProperties(reponse); 
      console.log("54",properties);

}).catch();
    router.replace("/admin/status");
    return {
      props : {properties}
    }
  }


 
  
  const { toggle } = useToggle();
  if (session) {
    return (
      <header className="h-20 items-center relative z-10">
        <div className="flex flex-center flex-col h-full justify-center mx-auto relative px-3 text-white z-10">
          <div className="flex items-center pl-1 relative w-full sm:ml-0 sm:pr-2 lg:max-w-68">
            <div className="flex group h-full items-center relative w-12">
              <button
                type="button"
                aria-expanded="false"
                aria-label="Toggle sidenav"
                onClick={toggle}
                className="text-4xl text-white focus:outline-none"
              >
                &#8801;
              </button>
            </div>
            <div className="container flex left-0 relative w-3/4">
              <div className="group hidden items-center ml-8 relative w-full md:flex lg:w-72">
                <div className="absolute block cursor-pointer flex items-center justify-center h-10 p-3 pr-2 text-gray-500 text-sm uppercase w-auto sm:hidden">
                  <svg
                    fill="none"
                    className="h-5 relative w-5"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                  >
                    <path d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" />
                  </svg>
                </div>
                <svg
                  className="absolute fill-current h-4 hidden left-0 ml-4 pointer-events-none text-gray-500 w-4 group-hover:text-gray-400 sm:block"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 20 20"
                >
                  <path d="M12.9 14.32a8 8 0 1 1 1.41-1.41l5.35 5.33-1.42 1.42-5.33-5.34zM8 14A6 6 0 1 0 8 2a6 6 0 0 0 0 12z" />
                </svg>
                <input
                  
                  type="text"
                  className="bg-gray-800 block leading-normal pl-10 py-1.5 pr-4 ring-opacity-90 rounded-2xl text-gray-400 w-full focus:border-transparent focus:outline-none focus:ring-2 focus:ring-blue-500"
                  placeholder="검색"
                />
              </div>
            </div>
            <div className="flex items-center justify-end ml-5 p-1 relative w-full sm:mr-0 sm:right-auto">
              <div className="pr-5">
                <svg
                  onClick={()=>signOut()} 
                  className="w-6 h-6" 
                  fill="none" 
                  stroke="currentColor" 
                  viewBox="0 0 24 24" 
                  xmlns="http://www.w3.org/2000/svg"
                >
                <path 
                  strokeLinecap="round" 
                  strokeLinejoin="round" 
                  strokeWidth="2" 
                  d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"
                >
                </path>
                </svg>
              </div>
                <div>
                  {session && (<img
                  src={session.user.image}
                  alt="profile image"
                  className="object-cover w-10 h-10 rounded-full"
                  />)}
                </div>
            </div>
          </div>
        </div>
      </header>
    );
    }

  return (
    <header className="h-20 items-center relative z-10">
      <div className="flex flex-center flex-col h-full justify-center mx-auto relative px-3 text-white z-10">
        <div className="flex items-center pl-1 relative w-full sm:ml-0 sm:pr-2 lg:max-w-68">
          <div className="flex group h-full items-center relative w-12">
            <button
              type="button"
              aria-expanded="false"
              aria-label="Toggle sidenav"
              onClick={toggle}
              className="text-4xl text-white focus:outline-none"
            >
              &#8801;
            </button>
          </div>
          <div className="container flex left-0 relative w-3/4">
            <div className="group hidden items-center ml-8 relative w-full md:flex lg:w-72">
              <div className="absolute block cursor-pointer flex items-center justify-center h-10 p-3 pr-2 text-gray-500 text-sm uppercase w-auto sm:hidden">
                <svg
                  fill="none"
                  className="h-5 relative w-5"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
              </div>
              <svg
                className="absolute fill-current h-4 hidden left-0 ml-4 pointer-events-none text-gray-500 w-4 group-hover:text-gray-400 sm:block"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 20 20"
              >
                <path d="M12.9 14.32a8 8 0 1 1 1.41-1.41l5.35 5.33-1.42 1.42-5.33-5.34zM8 14A6 6 0 1 0 8 2a6 6 0 0 0 0 12z" />
              </svg>
              <form onSubmit={handleOnSubmit}>

              <input
                type="text"
                  onChange={searchHandler}
                  value={search}
                className="bg-gray-800 block leading-normal pl-10 py-1.5 pr-4 ring-opacity-90 rounded-2xl text-gray-400 w-full focus:border-transparent focus:outline-none focus:ring-2 focus:ring-blue-500"
                placeholder="검색"
                />
              </form>
            </div>
          </div>
          <div className="flex items-center justify-end ml-5 p-1 relative w-full sm:mr-0 sm:right-auto">
         
            {/* 회원가입 버튼 */}
              <svg 
                onClick={loginClicked}
                className="w-6 h-6" 
                fill="none" 
                stroke="currentColor" 
                viewBox="0 0 24 24" 
                xmlns="http://www.w3.org/2000/svg">
                <path 
                  strokeLinecap="round" 
                  strokeLinejoin="round" 
                  strokeWidth="2" 
                  d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1"/>
                </svg>
                {/* {signUpModalOn && < SignUpModal setSignUpModalOn={setSignUpModalOn}/>} */}
                {loginModalOn && < LoginModal setLoginModalOn={setLoginModalOn}/>}
          </div>
        </div>
      </div>
    </header>
  );
}
