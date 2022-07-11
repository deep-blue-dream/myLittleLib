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
       {categories}
    </ul>
    </>
  )
}


export default CategoryList