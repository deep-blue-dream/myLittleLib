import React from 'react'
import BookMark from './bookmark/BookMark'


const BookMarkList = (props) => {

    const bookMarkList = props.bookMarkData.map(bookMark => (
        <BookMark key={bookMark.id}
        id={bookMark.bookmarkIndex}
        title={bookMark.bookmarkTitle}
        description={bookMark.description}
        bookMarkURL={bookMark.bookmarkUrl}
        />
    ));


  return (
    <>
     <ul> 
       {bookMarkList}
    </ul>
    </>
  )
}

export default BookMarkList