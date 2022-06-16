import React from 'react'
import Category from './Category/Category'


const CategoryList = (props) => {
    // 더미
    const a = [{id:'g', category:'1',title:'1',description:1}]


    const categories = a.map(category => (
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
        {/*버튼  onclick이벤트시 북마크 불러오는 과정 진행 카테고리 title값 ? 검색 조건에 따라서 */ }
       {categories}
    </ul>
    </>
  )
}


export default CategoryList