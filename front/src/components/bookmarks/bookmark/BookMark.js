import React, {useState} from 'react';

const BookMark = (props) => {
    // console.log(props);
  const [isBookRendered, setIsBookRenderd] = useState(false);
  

  const selectBookMarkHandler = (props) => {
        window.open(`${props.bookMarkURL}`)
    }

    return (
    <>
    {/* 버튼 형식으로 바꾸기 위해 button 추가함 */}
        <button onClick={()=>{window.open(`${props.bookMarkURL}`)}} className="w-full ">
            {/* <div className="w-full md:w-4/12"> */}
            {/* 북마크1 설정 */}
            <div>
            <div className="border-t solid border-gray-700 p-4 flex 2xl:items-start w-full hover:bg-gray-700">
                <div className="pl-4 w-full">
                <div className="flex items-center justify-between w-full">
                    <div className="text-white font-medium">{props.title}</div>
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
                    {props.description}
                </p>
                </div>
            </div>
            </div>
        </button>
    </>
// 카테고리 버튼 확인용 더미데이터 종료
  )
}

export default BookMark