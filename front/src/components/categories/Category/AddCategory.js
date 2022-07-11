import React from 'react'
import React, { useState } from 'react';



const AddCategory = () => {

    //카테고리에 들어갈 form 항목을 state로 관리
    const [category, setCategory] = useState("");
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");


    const [modalOn, setModalOn] = useState(false);
    const clicked = () => {
      setModalOn(true)
    }


  return (
    <>

    {modalOn && < Modal setModalOn={setModalOn} setChoice={setChoice} />}
    
    </>
  )
}

export default AddCategory