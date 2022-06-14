import React from 'react'
import Category from './Category/Category'


const CategoryList = (props) => {
    // console.log(props); 값 넘어오는 것은 확인
    const categories = props.categorydata.map(category => (
        <Category key={category.id}
        id={category.id}
        category = {category.category}
        title={category.title}
        description={category.description}
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