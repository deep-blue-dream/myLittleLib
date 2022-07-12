import React from 'react'
import Category from './Category/Category'
import { useState } from 'react';


const CategoryList = (props) => {
 
    const a = props.categoryProps;
    const [categoryIndex, setCategoryIndex] = useState();
    
    const clickHandler = (id) => {
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