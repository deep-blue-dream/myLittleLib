import React from 'react'
import Category from './Category/Category'
import { useState } from 'react';


const CategoryList = (props) => {
    // 더미
    // console.log(props.categoryProps);
    const a = props.categoryProps;
    const [categoryIndex, setCategoryIndex] = useState();
    
    const clickHandler = (id) => {
      
      // setCategoryIndex(key);
      // console.log("클릭핸들러 키",props.categoyProps.categoryIndex);
      // console.log("클릭핸들러 키", id);
      props.clickHandler(id);
    }

    const categories = a.map(category => (
        <Category clickHandler={clickHandler} key={category.categoryIndex}
        id={category.categoryIndex}
        title={category.categoryTitle}
        description={category.categoryDescription}
        />
    ));


  return (
    <>
     <ul>
        {/*버튼  onclick이벤트시 북마크 불러오는 과정 진행 카테고리 title값 ? 검색 조건에 따라서 */ }
       {categories}
    </ul>
    </>
  )
}


export default CategoryList