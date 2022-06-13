import AddCatoryModal from "../modal/AddCategoryModal";
import { useState } from "react";
import React from "react";
// import Modal from "../modal/modaltest";
// import categories from "./categories/Categories";

// 시간 표시 부분 설정 시작

let now = new Date();
const week = ['일', '월', '화', '수', '목', '금', '토'];
let dayOfWeek = week[now.getDay()];
let todayYear = now.getFullYear();
let todayMonth = (now.getMonth() + 1) > 9 ? (now.getMonth() + 1) : '0' + (now.getMonth()+ 1);
let todayDate = now.getDate() > 9? now.getDate() : '0' + now.getDate();
// 시간표시 부분 설정 완료

const Content = ({ title }) => {
  
  // modal test 부분 작성중
  const [modalOn, setModalOn] = useState(false);
  const [choice, setChoice] = useState(false)
  const clicked = () => {
  setModalOn(true)
}
  // modal test 부분 작성 완료
 
  return(
  <div className="flex flex-wrap">
    <div className="w-full lg:w-8/12 bg-gray-800 py-6 px-6 rounded-3xl">
      <div className="flex justify-between text-white items-center mb-8">
        <p className="text-4xl  font-bold">{title}</p>
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
      <div className="flex flex-wrap">
        {/* 박스1 */}
        <div className="w-full md:w-4/12">
          <div className="p-2">
            {/* 박스1 설정 */}
            <div
              className="p-4 rounded-3xl"
              // 색상 설정
              style={{ backgroundColor: '#fee4cb' }}
            >
              <div className="flex items-center justify-b">
                <span className="text-sm">카테고리 키워드</span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-70">북마크 리스트 타이틀</p>
                <p className="text-sm opacity-70 mt-2">북마크 설명</p>
              </div>
              <div>
                <p className="text-sm font-bold m-0">진척상황</p>
                <div className="w-full h-1 rounded-md overflow-hidden bg-white my-2 mx-0">
                  <span className="block h-1 rounded-md bg-yellow-700 w-6/12" />
                </div>
                <p className="text-right m-0 text-sm font-bold">내가설정</p>
              </div>
            </div>
          </div>
        </div>
        {/* 박스2 시작 */}
        <div className="w-full md:w-4/12 ">
          <div className="p-2">
            {/* 박스2 설정 */}
            <div className="max-h-45  p-4 rounded-3xl bg-gray-300">
              <div className="flex items-center justify-b">
                <span className="text-sm">카테고리 키워드 </span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-70">북마크 리스트 타이틀2</p>
                <p className="text-sm opacity-70 mt-2">Description</p>
              </div>
              <div>
                <p className="text-sm font-bold m-0">Progress</p>
                <div className="w-full h-1 rounded-md overflow-hidden bg-white my-2 mx-0">
                  <span className="block h-1 rounded-md bg-indigo-700 w-5/12" />
                </div>
                <p className="text-right m-0 text-sm font-bold">50%</p>
              </div>
            </div>
          </div>
        </div>
        {/* 박스2 종료 */}
        {/* 박스3 시작*/}
        <div className="w-full md:w-4/12">
          <div className="p-2">
            {/* 박스3 설정 */}
            <div className="max-h-45  p-4 rounded-3xl bg-green-200">
              <div className="flex items-center justify-b">
                <span className="text-sm">카테고리 키워드3</span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-70">북마크 리스트 타이틀3</p>
                <p className="text-sm opacity-70 mt-2">북마크 설명3</p>
              </div>
              <div>
                <p className="text-sm font-bold m-0">진척상황3</p>
                <div className="w-full h-1 rounded-md overflow-hidden bg-white my-2 mx-0">
                  <span className="block h-1 rounded-md bg-yellow-700 w-6/12" />
                </div>
                <p className="text-right m-0 text-sm font-bold">50%</p>
              </div>
            </div>
          </div>
        </div>
        {/* 박스3 종료 */}
        {/* 박스4 시작 */}

        
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
              {/* https://blog.chosunghyun.com/kr-tailwind-css-docs-basic-study/ */}
              <div className="flex max-h-45">
                <div className="m-auto">
                  
              <div className="flex justify-between mb-4 pt-2 relative">
                <div className="flex items-center ">
                  <button className="object-center w-20 h-20 rounded-full border-none  flex justify-center items-center bg-white">
                    
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
                      className="feather feather-plus"
                      onClick={clicked}>
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
        {/* 박스 생성을 컨테이너로 작업, 추가시 컨테이너 추가하는 방식으로 진행+List 및 flex 조건으로 생성하도록 코드 */}
      </div>
    </div>

    {/* 북마크 리스트 추가 */}
    <div className="w-full mt-8 lg:mt-0 lg:w-4/12 lg:pl-4">
      <div className="bg-gray-800 rounded-3xl px-6 pt-6">
        <div className="flex text-white text-2xl pb-6 font-bold">
          <p>북마크 리스트</p>
        </div>
        <div>
          <div className="border-t solid border-gray-700 p-4 flex 2xl:items-start w-full hover:bg-gray-700">
            <img
              src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80"
              alt="profile image"
              className="object-cover w-10 h-10 rounded-full"
            />
            <div className="pl-4 w-full">
              <div className="flex items-center justify-between w-full">
                <div className="text-white font-medium">Stephanie</div>
                <div className="flex justify-center items-center cursor-pointer h-7 w-7">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="20"
                    height="20"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    className="text-white"
                  >
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </div>
              </div>
              <p className="my-2 text-sm text-gray-400">
                I got your first assignment. It was quite good. 🥳 We can
                continue with the next assignment.
              </p>
              <p className="text-right text-gray-400 text-sm">Dec, 12</p>
            </div>
          </div>
          <div className="border-t solid border-gray-700 p-4 flex 2xl:items-start w-full hover:bg-gray-700">
            <img
              src="https://images.unsplash.com/photo-1600486913747-55e5470d6f40?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80"
              alt="profile image"
              className="object-cover w-10 h-10 rounded-full"
            />
            <div className="pl-4 w-full">
              <div className="flex items-center justify-between w-full">
                <div className="text-white font-medium">Mark</div>
                <div className="flex justify-center items-center cursor-pointer h-7 w-7">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="20"
                    height="20"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    className="text-white"
                  >
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </div>
              </div>
              <p className="my-2 text-sm text-gray-400">
                Hey, can tell me about progress of project? I'm waiting for your
                response.
              </p>
              <p className="text-right text-gray-400 text-sm">Dec, 12</p>
            </div>
          </div>
          <div className="border-t solid border-gray-700 p-4 flex 2xl:items-start w-full hover:bg-gray-700">
            <img
              src="https://images.unsplash.com/photo-1543965170-4c01a586684e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDZ8fG1hbnxlbnwwfDB8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60"
              alt="profile image"
              className="object-cover w-10 h-10 rounded-full"
            />
            <div className="pl-4 w-full">
              <div className="flex items-center justify-between w-full">
                <div className="text-white font-medium">David</div>
                <div className="flex justify-center items-center cursor-pointer h-7 w-7">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="20"
                    height="20"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    className="text-white"
                  >
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </div>
              </div>
              <p className="my-2 text-sm text-gray-400">
                Hey, can tell me about progress of project? I'm waiting for your
                response.
              </p>
              <p className="text-right text-gray-400 text-sm">Dec, 12</p>
            </div>
          </div>
          <div className="border-t solid border-gray-700 p-4 flex 2xl:items-start w-full hover:bg-gray-700">
            <img
              src="https://images.unsplash.com/photo-1533993192821-2cce3a8267d1?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTl8fHdvbWFuJTIwbW9kZXJufGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60"
              alt="profile image"
              className="object-cover w-10 h-10 rounded-full"
            />
            <div className="pl-4 w-full">
              <div className="flex items-center justify-between w-full">
                <div className="text-white font-medium">Mark</div>
                <div className="flex justify-center items-center cursor-pointer h-7 w-7">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="20"
                    height="20"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    className="text-white"
                  >
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </div>
              </div>
              <p className="my-2 text-sm text-gray-400">
                I am really impressed! Can't wait to see the final result.
              </p>
              <p className="text-right text-gray-400 text-sm">Dec, 12</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  )
  };
  

export default Content;
