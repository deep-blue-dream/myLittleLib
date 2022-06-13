import React, {useState} from 'react';

// 카테고리 버튼 자동 생성 부분 작성중(더미 데이터)
const categories = [
    { id: 1, category: 'JAVA(카테고리 키워드)', title: '자바 공부', description: '자바 공부 유튜브 영상들만 모음-생활코딩'},
    { id: 2, category: 'MUSIC(카테고리 키워드)', title: '노래 목록', description: '힐링 음악 유튜브 영상들만 모음'}
  ];

const Category = (props) => {
  const [isRendered, setIsRenderd] = useState(false);
  
  const selectCategoryHandler = () => {
    //   버튼 선택시 북마크 리스트 받아오는 함수? -북마크 리스트 작동 함수
}

  
    return (
    // 이곳에 구현내용 붙여넣기
    // 카테고리 버튼 자동 생성 부분 작성중(더미데이터)
    <>
    {/* 버튼 형식으로 바꾸기 위해 button 추가함 */}
    <button onClick={selectCategoryHandler} className="w-full md:w-4/12">
        {/* <div className="w-full md:w-4/12"> */}
          <div className="p-2">
            {/* 박스1 설정 */}
            <div
              className="p-4 rounded-3xl"
              // 색상 설정
              style={{ backgroundColor: '#fee4cb' }}
              >
              <div className="flex items-center justify-b">
                <span className="text-sm">{categories.title}.{categories.category}</span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-70">{categories.title}</p>
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
        {/* </div> */}
    </button>

    </>
// 카테고리 버튼 확인용 더미데이터 종료
  )
}

export default Category