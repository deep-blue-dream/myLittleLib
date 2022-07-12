import React, { useState } from 'react';
import { useRouter } from 'next/router';
import { postBookMarkAPI } from '../lib/api/bookmark';

const AddBookMarkModal = (props) => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [bookMarkURL, setBookMarkURL] = useState('');

  // 라우터로 관리하기 위함
  const router = useRouter();

  const bookMarkTitleChangeHandler = (event) => {
    setTitle(event.target.value);
  };
  const bookMarkDesChangeHandler = (event) => {
    setDescription(event.target.value);
  };

  const bookMarkURLChangeHandler = (event) => {
    setBookMarkURL(event.target.value);
  };

  const AddBookMark = () => {
    const data = {
      categorytitle: props.categoryProps[props.currCategory - 1].categoryTitle, //임의의 유저 번호 부여, BE 요청 방식과 naming 동일하게 진행
      bookmarkTitle: title, //BE 요청 방식과 naming 동일하게 진행
      description: description, //BE 요청 방식과 naming 동일하게 진행
      bookmarkUrl: bookMarkURL
    };
      postBookMarkAPI(data);

  };

  // 버튼 입력시 발생하는 이벤트 핸들러
  const bookMarkCommitClickHandler = () => {
    props.setBookModalOn(false);
    // 이곳에 라우터 보내는 작업 진행? push함수 쓰는거.
    AddBookMark();
  };
  const bookMarkCancelClickHandler = () => {
    props.setBookModalOn(false);
  };
  // 버튼 입력시 발생하는 이벤트 핸들러 종료

  return (
    <div className="bg-black bg-opacity-95 opacity-100 fixed inset-0 z-50">
      <div className="flex h-screen justify-center items-center ">
        <div className="flex-col justify-center  bg-gray-900 py-10 px-20 border-4 border-white rounded-xl ">
          <div className="py-6 px-6 lg:px-8">
            {/* 양식 작성 시작 */}
            <h3 className="mb-4 text-xl font-medium text-gray-900 dark:text-white">
              나만의 북마크 등록
            </h3>
            <form className="space-y-3" action="#">
              <div>
                <label
                  htmlFor="title"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                >
                  제목
                </label>
                <input
                  type="text"
                  name="title"
                  id="title"
                  placeholder="제목을 입력해주세요!"
                  className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                  onChange={bookMarkTitleChangeHandler}
                  required=""
                />
              </div>
              <div>
                <label
                  htmlFor="description"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                >
                  설명
                </label>
                <input
                  type="text"
                  name="description"
                  id="description"
                  placeholder="행복코딩을 위한 동영상 강의 모음"
                  className="box-border w-72 h-40 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                  onChange={bookMarkDesChangeHandler}
                  required=""
                />
              </div>
              <div>
                <label
                  htmlFor="bookmarkURL"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                >
                  URL
                </label>
                <input
                  type="text"
                  name="bookmarkURL"
                  id="bookmarkURL"
                  placeholder="북마크 URL을 입력해주세요"
                  className="box-border w-72 h-40 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                  onChange={bookMarkURLChangeHandler}
                  required=""
                />
              </div>
              <div className="flex justify-between">
                <div className="flex">
                  <button
                    onClick={bookMarkCommitClickHandler}
                    className=" rounded px-4 py-2 text-white  bg-green-400 "
                  >
                    {' '}
                    등록
                  </button>
                  <button
                    onClick={bookMarkCancelClickHandler}
                    className="rounded px-4 py-2 ml-4 text-white bg-blue-500 "
                  >
                    취소
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddBookMarkModal;
