import React, {useState} from 'react';



const Modal = ({ setModalOn, setChoice }) => {
    // 버튼 입력시 발생하는 이벤트 핸들러
    const commitClickHandler = () => {
        setChoice(true)
        setModalOn(false)
    }
    const cancelClickHandler = () => {
        setChoice(false)
        setModalOn(false)
    }


    // 버튼 입력시 발생하는 이벤트 핸들러 종료

    return (

        <div className="   bg-transparent opacity-100 fixed inset-0 z-50   ">
            <div className="flex h-screen justify-center items-center ">
                <div className="flex-col justify-center  bg-white py-12 px-24 border-4 border-sky-500 rounded-xl ">
                    <div className="flex  text-lg  text-zinc-600   mb-10" >Are you sure ?</div>
                    <div className="flex">
                        <button onClick={commitClickHandler} className=" rounded px-4 py-2 text-white  bg-green-400 ">카테고리 등록</button>
                        <button onClick={cancelClickHandler} className="rounded px-4 py-2 ml-4 text-white bg-blue-500 ">취소</button>
                    </div>

                </div>
            </div>
        </div>

    );
}

export default Modal