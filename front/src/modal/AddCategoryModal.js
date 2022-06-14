import React, {useState} from 'react';
import { useRouter } from 'next/router';
import { postCategoryAPI } from '../lib/api/category';



const AddCategoryModal = ({ setModalOn}) => {
    
    // AddCategoryModal의 입력 form을 state로 관리
    const [category, setCategory] = useState("");
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    
    // 라우터로 관리하기 위함
    const router = useRouter();
    
    // 입력받은 form 보내기 위한 함수 작성
    const categoryChangeHandler = (event) =>{
        setCategory(event.target.value);
        setTitle(event.target.value);
        setDescription(event.target.value);
    }
    
    
    // AddCategory 함수 작성
    const AddCategory = () =>{
        const data = {
            category: category,
            title: title,
            description: description
        };
        postCategoryAPI(data);
    }

    // 버튼 입력시 발생하는 이벤트 핸들러
    const commitClickHandler = () => {
        setModalOn(false)
        // 이곳에 라우터 보내는 작업 진행? push함수 쓰는거.
        AddCategory();
    }
    const cancelClickHandler = () => {
        setModalOn(false)
    }
    // 버튼 입력시 발생하는 이벤트 핸들러 종료
    
    return (
        <div className="bg-black bg-opacity-95 opacity-100 fixed inset-0 z-50">
            <div className="flex h-screen justify-center items-center ">
                <div className="flex-col justify-center  bg-gray-900 py-10 px-20 border-4 border-white rounded-xl ">
                    <div className="py-6 px-6 lg:px-8">
                        {/* 양식 작성 시작 */}
                    <h3 className="mb-4 text-xl font-medium text-gray-900 dark:text-white">나만의 북마크 폴더 등록</h3>
                        <form className="space-y-3" action="#">
                            <div>
                                <label Htmlfor="category" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">주제</label>
                                <input type="text" name="category" id="category" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="음악/유튜브" required=""/>
                            </div>
                            <div>
                                <label Htmlfor="title" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">제목</label>
                                <input type="text" name="title" id="title" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="멜로디 전용" required=""/>
                            </div>
                            <div>
                                <label Htmlfor="description" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">설명</label>
                                <input type="text" name="description" id="description" placeholder="공부할 때 듣기 좋은 음악 리스트" className="box-border w-72 h-40 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required=""/>
                            </div>
                                <div className="flex justify-between">
                                    {/* 공개여부 체크박스 설치예정 */}
                                    {/* <div class="flex items-start">
                                    <div class="flex items-center h-5"> */}
                                        {/* <input id="remember" type="checkbox" value="" class="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300 dark:bg-gray-600 dark:border-gray-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800" required=""/>
                                    </div>
                                        <label for="remember" class="ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Remember me</label>
                                    </div>
                                        <a href="#" class="text-sm text-blue-700 hover:underline dark:text-blue-500">Lost Password?</a> */}
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