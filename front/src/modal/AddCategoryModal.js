import React, {useState} from 'react';
import { useRouter } from 'next/router';
import { postCategoryAPI } from '../lib/api/category';



const AddCategoryModal = (props) => {
        
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    
    const router = useRouter();
    
    const categoryTitleChangeHandler = (event) =>{
        setTitle(event.target.value);
    }
    const categoryDesChangeHandler = (event) =>{
        setDescription(event.target.value);
    }
        
    
    // AddCategory 함수 작성
    const AddCategory = () =>{
        const data = {
            email: props.email, //임의의 유저 번호 부여, BE 요청 방식과 naming 동일하게 진행
            categoryTitle: title, //BE 요청 방식과 naming 동일하게 진행
            categoryDescription: description //BE 요청 방식과 naming 동일하게 진행
            
        };
        postCategoryAPI(data);
        router.replace("/admin/status");
    }

   
    const commitClickHandler = () => {
        props.setModalOn(false)
        AddCategory();
    }
    const cancelClickHandler = () => {
        props.setModalOn(false)
    }
    
    return (
        <div className="bg-black bg-opacity-95 opacity-100 fixed inset-0 z-50">
            <div className="flex h-screen justify-center items-center ">
                <div className="flex-col justify-center  bg-gray-900 py-10 px-20 border-4 border-white rounded-xl ">
                    <div className="py-6 px-6 lg:px-8">
                        {/* 양식 작성 시작 */}
                    <h3 className="mb-4 text-xl font-medium text-gray-900 dark:text-white">나만의 카테고리 등록</h3>
                        <form className="space-y-3" action="#">
                            <div>
                                <label htmlFor="title" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">제목</label>
                                <input type="text" name="title" id="title" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" onChange={categoryTitleChangeHandler} placeholder="카테고리의 제목을 입력해주세요" required=""/>
                            </div>
                            <div>
                                <label htmlFor="description" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">설명</label>
                                <input type="text" name="description" id="description" placeholder="카테고리의 설명을 입력해주세요" className="box-border w-72 h-40 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" onChange={categoryDesChangeHandler} required=""/>
                            </div>
                                <div className="flex justify-between">
                                    {/* 공개여부 체크박스 설치예정 */}
                                    {/* <div className="flex items-start">
                                    <div className="flex items-center h-5"> */}
                                        {/* <input id="remember" type="checkbox" value="" className="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300 dark:bg-gray-600 dark:border-gray-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800" required=""/>
                                    </div>
                                        <label for="remember" className="ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Remember me</label>
                                    </div>
                                        <a href="#" className="text-sm text-blue-700 hover:underline dark:text-blue-500">Lost Password?</a> */}
                                <div className="flex">
                                    <button onClick={commitClickHandler} className=" rounded px-4 py-2 text-white  bg-green-400 "> 등록</button>
                                    <button onClick={cancelClickHandler} className="rounded px-4 py-2 ml-4 text-white bg-blue-500 ">취소</button>
                                </div>
                            </div>
                        </form>    
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AddCategoryModal