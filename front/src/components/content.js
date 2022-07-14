import AddCatoryModal from '../modal/AddCategoryModal';
import { useState } from 'react';
import React from 'react';
import CategoryList from './categories/CategoryList';
import BookMarkList from './bookmarks/BookMarkList';
import AddBookMarkModal from '../modal/AddBookMarkModal';
import { useSession } from 'next-auth/react';

import Docs from './docs/index';
import Button from './button';
import BookMarkButton from './bookmarks/BookMarkButton';
import Header from './Header';

const Content = (props) => {
  const categoryProps = props.properties;

  let email;

  const [modalOn, setModalOn] = useState(false);
  const [bookModalOn, setBookModalOn] = useState(false);
  const { data: session, status } = useSession();

  const [currCategory, setCurrCategory] = useState('');
  const [currBookMark, setCurrBookMark] = useState([]);

  const clicked = () => {
    setModalOn(true);
  };
  const BookClicked = () => {
    setBookModalOn(true);
  };

  const clickHandler = (id) => {
    setCurrCategory(id);
    categoryProps.forEach((element) => {
      if (element.categoryIndex == id) {
        setCurrBookMark(element.bookmarkDTOList);
      }
    });
  };

  if (status === 'authenticated') {
    email = session.user.email;
  }

  if (session !== null && props.signin === true) {
    return (
      // 컨텐츠 부분 헤더 디자인
      <div className="flex flex-wrap">
        <div className="w-full lg:w-8/12 bg-gray-800 py-6 px-6 rounded-3xl">

          <Header session={session}/>

          <CategoryList
            categoryProps={categoryProps}
            clickHandler={clickHandler}
          />
          <div className="flex flex-wrap">
            {/* 박스 flex 적용 tailwind */}
            {/* 유저가 가지고 있는 카테고리 컨텐츠 등록 박스 시작 */}

            {/* /categorydata = {category} */}
            {/* 유저가 가지고 있는 카테고리 컨텐츠 등록 박스 종료 */}

            {/* 새 카테고리 등록하기 */}
            <div className="w-full md:w-4/12">
              <div className="p-2">
                <div className="p-4 rounded-3xl bg-red-200">
                  <div className="flex items-center justify-b"></div>
                  <div className="text-center mb-4 mt-5">
                    <p className="text-base font-bold opacity-80">
                      새 카테고리 등록하기
                    </p>
                  </div>
                  {/* 버튼 중앙 정렬 div wrap 기능 line 100~101,122~123 - */}
                  {/* TailwindCss는 className으로 css적용하기 때문에 w-12등의 className이 지원되지 않아 Wrapper Div를 활용하여 버튼 중앙정렬을 시킬 수 있다. */}
                  
                  <Button clicked={clicked} />
                </div>
              </div>
              {/* modal 부분 작성중 */}
              {modalOn && (
                <AddCatoryModal setModalOn={setModalOn} email={email} />
              )}
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
              <BookMarkList bookMarkData={currBookMark} />
              {/* 북마크 리스트 1 종료*/}

              {/* 구분선 생성 */}
              <div className="border-t solid border-gray-700  flex 2xl:items-start w-full hover:bg-gray-700"></div>
              {/* 구분선 완료 */}

              <p className="text-base font-bold opacity-40 mt-4 text-white text-center">
                새 북마크 등록하기
              </p>
              {/* {currCategory ? : } */}
              
              <div className="flex max-h-45">
                <BookMarkButton BookClicked = {BookClicked}/>
                
                {/* modal 부분 작성중 */}
                {bookModalOn && (
                  <AddBookMarkModal
                    setBookModalOn={setBookModalOn}
                    currCategory={currCategory}
                    categoryProps={categoryProps}
                    email={email}
                  />
                )}
                {/* modal 부분 작성 완료 */}
              </div>
              {/* 북마크 등록 버튼 종료 */}
            </div>
          </div>
        </div>
      </div>
    );
  }

  return <Docs />;
};

export default Content;