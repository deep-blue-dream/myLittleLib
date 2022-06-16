const Category = (props) => {
  
  const selectCategoryHandler = () => {
    //   버튼 선택시 북마크 리스트 받아오는 함수? -북마크 리스트 작동 함수
}

  
    return (
    <>
    <button onClick={selectCategoryHandler} className="w-full md:w-4/12">
          <div className="p-2">
            {/* 박스1 설정 */}
            <div
              className="p-4 rounded-3xl"
              style={{ backgroundColor: '#fee4cb' }}
              >
              <div className="flex items-center justify-b">
                <span className="text-sm">{props.id}</span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-70">{props.title}</p>
                <p className="text-sm opacity-70 mt-2">{props.description}</p>
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
    </button>
    </>
  )
}

export default Category