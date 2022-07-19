import React, {useState} from 'react';

const LoginModal = ({setLoginModalOn}) => {

    const [username, setUsername] = useState('')
    const [password,setPassword] = useState('')
    const [token, setToken] = useState('')
    
const loginApi = (data) => fetch('http://localhost:8080/login', {
    method: "POST",
    headers : {
        'Content-Type': 'application/json'
    },
    body : JSON.stringify(data)
}).then(res => setToken(res.headers.get("Authorization")));


    const handleCancelClick = () => {
        setLoginModalOn(false)
    }

    const usernameHandler = (event) => {
        setUsername(event.target.value)
    }
    
    const passwordHandler = (event) => {
        setPassword(event.target.value)
    }

    const loginHandler = () => {
        const payload = {
            username:username,
            password:password
        }
        
        loginApi(payload)

        console.log("token:" , token)
    }


    return (
        <div className=" bg-black bg-opacity-95 opacity-100 fixed inset-0 z-50 ">
          <div className="flex h-screen justify-center items-center">
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700 w-4/12">
                {/* 엑스 버튼 클릭시 발생 이벤트*/}
                <button type="button" onClick={handleCancelClick} className="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="authentication-modal">
                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>  
                </button>
                <div class="py-6 px-6 lg:px-8">
                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">로그인</h3>
                    <form class="space-y-6">
                        <div>
                            <label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">아이디</label>
                            <input type="text" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="아이디 입력" required 
                            onChange={usernameHandler}/>
                        </div>
                        <div>
                            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">비밀번호</label>
                            <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required 
                            onChange ={passwordHandler}/>
                        </div>
                        <button type="button" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" onClick = {loginHandler}>로그인</button>
                    </form>
                </div>
            </div>
        </div>
    </div>   
)};

export default LoginModal


// const exApi = (data) => fetch('http://localhost:8080/ex', {
//     method: "POST",
//     headers : {
//         'Authorization' : token,
//         'Content-Type': 'application/json'
//     },
//     body : JSON.stringify(data)
// }).then();