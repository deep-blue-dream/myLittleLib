import React from 'react'
import React, { useState } from 'react';



const AddBookMark = () => {

    const [bookMark, setBookMark] = useState("");
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");


    const [modalOn, setModalOn] = useState(false);
    const clicked = () => {
        setModalOn(true)
    }


  return (
    <>

    {modalOn && < Modal setModalOn={setModalOn} />}
    
    </>
  )
}

export default AddBookMark