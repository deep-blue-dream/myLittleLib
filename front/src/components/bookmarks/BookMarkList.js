import React from 'react'
import BookMark from './bookmark/BookMark'


const BookMarkList = (props) => {

    const bookMarkList = props.bookMarkData.map(bookMark => (
        <BookMark key={bookMark.id}
        id={bookMark.id}
        bookMark = {bookMark}
        title={bookMark.title}
        description={bookMark.description}
        bookMarkURL={bookMark.bookMarkURL}
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