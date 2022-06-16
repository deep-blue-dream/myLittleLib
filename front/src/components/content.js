import AddCatoryModal from "../modal/AddCategoryModal";
import { useState } from "react";
import React from "react";
import CategoryList from "./categories/CategoryList";
import BookMarkList from "./bookmarks/BookMarkList";
import AddBookMarkModal from "../modal/AddBookMarkModal";
import { useSession } from "next-auth/react"

import { Router, useRouter } from "next/router";
import Docs from './docs/index';


// 시간표시 부분 설정 완료
let now = new Date();
const week = ['일', '월', '화', '수', '목', '금', '토'];
let dayOfWeek = week[now.getDay()];
let todayYear = now.getFullYear();
let todayMonth = (now.getMonth() + 1) > 9 ? (now.getMonth() + 1) : '0' + (now.getMonth()+ 1);
let todayDate = now.getDate() > 9? now.getDate() : '0' + now.getDate();



const Content = (props) => {
  const categoryProps = props.properties;
  const bookMarkProps = [];

  // props.properties.bookmarkDTOList.forEach(element => {
  //   bookMarkProps.push(element);
  // });

  console.log(bookMarkProps);

  // console.log(props.properties);
  let email;

  const router = useRouter();
  const [modalOn, setModalOn] = useState(false);
  const [choice, setChoice] = useState(false)
  const [bookModalOn, setBookModalOn] = useState(false);
  const [userEmail,setUserEmail] = useState({});
  const { data: session, status } = useSession();

  const [currCategory, setCurrCategory] = useState('');
  const [currBookMark, setCurrBookMark] = useState([]);

  const clicked = () => {
    setModalOn(true)
  }
  const BookClicked = () => {
      setBookModalOn(true)
  }

  const clickHandler = (id) => {
    setCurrCategory(id);
    categoryProps.forEach(element => {
      if (element.categoryIndex == id){
        setCurrBookMark(element.bookmarkDTOList);
        console.log("58번줄",element.bookmarkDTOList);
      }
    });
    // setCurrBookMark(categoryProps[id-1].bookmarkDTOList);
  }

  // const testAPI = async (data) => {
  //     const res = await postSignInAPI(data);
  //     const user = await res.json();
      // console.log('여기', user);
  //     return user;
  // }

  
 
  if (status === "authenticated") {email = session.user.email;};
  
  const data = {
      email : email
    };

  // const user = testAPI(data);
  // const res = user.then(result => result);
  // const res2 = res.then(result => result);
  
  
  if(session) { 

  return( 
  // 컨텐츠 부분 헤더 디자인
  <div className="flex flex-wrap">
    <div className="w-full lg:w-8/12 bg-gray-800 py-6 px-6 rounded-3xl">
      <div className="flex justify-between text-white items-center mb-8">
        {/* <p className="text-4xl  font-bold">{title}</p> */}
        <p className="text-2xl text-yellow-300 font-bold">{(todayYear-2000) + '.' + todayMonth + '.' + todayDate + '.' + dayOfWeek + '요일' }</p>
      </div>
      <div className="flex flex-wrap justify-between items-center pb-8">
        <div className="flex flex-wrap text-white">
          <div className="pr-10">
            <div className="text-2xl font-bold">뮤직 플레이어</div>
            <div className="">볼륨바</div>
          </div>
        </div>
      </div>
      {/* 헤더 디자인 종료 */}


      <div className="flex flex-wrap">
      {/* 박스 flex 적용 tailwind */}
      {/* 유저가 가지고 있는 카테고리 컨텐츠 등록 박스 시작 */}
      <CategoryList categoryProps={categoryProps} clickHandler = {clickHandler}/> 
      {/* /categorydata = {category} */}
      {/* 유저가 가지고 있는 카테고리 컨텐츠 등록 박스 종료 */}

        {/* 새 카테고리 등록하기 */}    
        <div className="w-full md:w-4/12">
          <div className="p-2">
            <div className="p-4 rounded-3xl bg-red-200">
              <div className="flex items-center justify-b">
                </div>
                  <div className="text-center mb-4 mt-5">
                  <p className="text-base font-bold opacity-80">새 카테고리 등록하기</p>
                </div>
                  {/* 버튼 중앙 정렬 div wrap 기능 line 100~101,122~123 - */}
                  {/* TailwindCss는 className으로 css적용하기 때문에 w-12등의 className이 지원되지 않아 Wrapper Div를 활용하여 버튼 중앙정렬을 시킬 수 있다. */}
                <div className="flex max-h-45">
                  <div className="m-auto">
                    <div className="flex justify-between mb-4 pt-2 relative">
                      <div className="flex items-center ">
                        <button className="object-center w-20 h-20 rounded-full border-none  flex justify-center items-center bg-white" onClick={clicked}>
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            strokeWidth="2"
                            strokeLinecap="round"
                            strokeLinejoin="round"
                            className="feather feather-plus">
                            <path d="M12 5v14M5 12h14" />
                          </svg>
                        </button>
                      </div>
                    </div>
                    {/* 버튼 중앙 정렬 div wrap 기능 종료  */}

                  </div>
                </div>
              </div>
            </div>
            {/* modal 부분 작성중 */}
            {modalOn && < AddCatoryModal setModalOn={setModalOn} setChoice={setChoice} />}
            {/* modal 부분 작성 완료 */}
          </div>
          {/* 박스 종료 */}
        </div>
      </div>
    {/* 북마크 리스트 추가 */}
    <div className="w-full mt-8 lg:mt-0 lg:w-4/12 lg:pl-4">
      <div className="bg-gray-800 rounded-3xl px-6 pt-6">
        <div className="flex text-white text-2xl pb-6 font-bold">
          <p>북마크 리스트</p>
        </div>
        {/* 북마크 리스트 시작 */}
        <div>
        <BookMarkList  bookMarkData= {currBookMark} />
          {/* 북마크 리스트 1 종료*/}


          {/* 구분선 생성 */}
          <div className="border-t solid border-gray-700  flex 2xl:items-start w-full hover:bg-gray-700"></div>
          {/* 구분선 완료 */}

          
          <p className="text-base font-bold opacity-40 mt-4 text-white text-center">새 북마크 등록하기</p>
          <div className="flex max-h-45">
            <div className="m-auto">
              <div className="flex justify-between mb-4 pt-2 relative">
                <div className="flex items-center ">
                  <button className="object-center w-10 h-10 rounded-full border-none  flex justify-center items-center bg-opacity-20 bg-white">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      color="gray"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="2"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-plus"
                      onClick={BookClicked}>
                      <path d="M12 5v14M5 12h14" />
                    </svg>
                  </button>
                </div>
              </div>
            </div>
            {/* modal 부분 작성중 */}
            {bookModalOn && < AddBookMarkModal setBookModalOn={setBookModalOn} />}
            {/* modal 부분 작성 완료 */}
          </div>
          {/* 북마크 등록 버튼 종료 */}
          
        </div>
      </div>
    </div>
  </div>
  )
  };



return (
  <Docs /> 
);
}


export default Content;
