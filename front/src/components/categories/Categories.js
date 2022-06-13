import React from 'react'
import Category from './Category/Category'


const Categories = (props) => {
    const categories = props.categories.map(category => (
        <Category 
        id={categories.id}
        category={categories.category}
        title={categories.title}
        description={categories.description}
        />
    ));


  return (
    <>
     {/* <ul> 
       {Categories}
    </ul> */}
    </>
  )
}

export default Categories