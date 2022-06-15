import React from 'react'
import React, { useState } from 'react';



const AddBookMark = () => {

    //카테고리에 들어갈 form 항목을 state로 관리
    const [bookMark, setBookMark] = useState("");
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");


    // modal test 부분 작성중
    const [modalOn, setModalOn] = useState(false);
    const clicked = () => {
        setModalOn(true)
    }
  // modal test 부분 작성 완료


  return (
    <>

    {modalOn && < Modal setModalOn={setModalOn} />}
    
    </>
  )
}

export default AddBookMark