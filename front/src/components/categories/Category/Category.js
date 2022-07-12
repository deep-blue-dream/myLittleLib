const Category = (props) => {

  
  const selectCategoryHandler = () => {
    props.clickHandler(props.id);
  }
  const cateColorList = [[218, 184, 139],
  [243, 233, 221],[205, 240, 234],
  [253, 246, 236],[249, 249, 249],
  [183, 202, 219],[255, 230, 230],
  [242, 209, 209],[218, 234, 241],
  [198, 220, 228],[241, 225, 166],
  [244, 187, 187],[246, 227, 197],
  [246, 227, 197],[186, 171, 218],
  [249, 206, 238]];

  const randoms = () => {
    return parseInt(Math.random()*(cateColorList.length));
  }
  let n = randoms();
  let r = cateColorList[n][0];
  let g = cateColorList[n][1];
  let b = cateColorList[n][2];
    return (
    <>
    <button onClick={selectCategoryHandler} className="w-full md:w-4/12">
          <div className="p-2">
            {/* 박스1 설정 */}
            <div
              className="p-4 rounded-3xl"
              style={{ backgroundColor: `rgba(${r},${g},${b})` }}
              >
              <div className="flex items-center justify-b">
                <span className="text-md font-bold opacity-70 ">{props.id}번 카테고리</span>
              </div>
              <div className="text-center mb-4 mt-5">
                <p className="text-base font-bold opacity-100  ">{props.title} </p>
                <p className="text-sm opacity-70 mt-2 truncate">{props.description}</p>
              </div>
              <div>
                <p className="text-sm font-bold m-0 text-black">진척상황</p>
                <div className="w-full h-1 rounded-md overflow-hidden bg-white my-2 mx-0">
                  <span className="block h-1 rounded-md bg-green-700 w-12/12" />
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