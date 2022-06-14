import React, {useState} from 'react';
import {GOOGLE_AUTH_URL} from '../lib/api/env';


const signupModal = ({ setSignUpModalOn }) => {
    const [password,setPassword] = useState('');
    const [passwordCheck,setPasswordCheck] = useState('');
    const [passwordError,setPasswordError] = useState(false);
    

    const onSubmit = (e) => {
        e.preventDefault();
        /**검증 로직 만들기
         * 1. 비밀번호와 비밀번호 체크가 다를 경우를 검증한다 */
        if(password !== passwordCheck){
            return setPasswordError(true);
        }
    };

    const onChangePassword = (e) => {
        setPassword(e.target.value);
    };
    const onChangePasswordChk = (e) => {
        //비밀번호를 입력할때마다 password 를 검증하는 함수
        setPasswordError(e.target.value !== password);
        setPasswordCheck(e.target.value);
    };

    const handleCancelClick = () => {
        setSignUpModalOn(false)
    }
    
return (
   
    <div className=" bg-black bg-opacity-95 opacity-100 fixed inset-0 z-50 ">
    <div className="flex h-screen justify-center items-center">
      <div className="relative bg-white rounded-lg shadow dark:bg-gray-700 w-4/12">
          <button type="button" onClick={handleCancelClick} className="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" dataModalToggle="authentication-modal">
              <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fillRule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clipRule="evenodd"></path></svg>  
          </button>
          <div className="py-6 px-6 lg:px-8">
              <h3 className="mb-4 text-xl font-medium text-gray-900 dark:text-white">회원가입</h3>
              <form className="space-y-6" action="#" onSubmit={onSubmit}>
                  <div>
                      <input type="text" name="id" id="id" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="아이디" required />
                  </div>
                  <div>
                      <input type="password" name="password" placeholder="비밀번호" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" 
                       value={password} required onChange={onChangePassword} />
                  </div>
                  <div>
                      <input type="password" name="password-check" placeholder="비밀번호 확인" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" 
                       value={passwordCheck} required onChange={onChangePasswordChk} />
                       {passwordError && <div style={{color : 'white'}}>비밀번호가 일치하지 않습니다.</div>}
                    </div>
                    <div>
                      <input type="email" name="email" id="email" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="이메일" required="" />
                    </div>
                    <button type="submit" className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">회원가입</button>
                    </form>
                    <br>
                    </br>
                    
                    <div>
                    {/* google API 관련 코드 */}
                    <a href={GOOGLE_AUTH_URL}>
                        <button className="border h-10 inline-flex items-center justify-center rounded-lg shadow-md bg-white text-gray-700 w-full">
                            <img
                            src="https://aid-frontend.prod.atl-paas.net/atlassian-id/front-end/3.4.2/static/media/google-logo.c21ca9d1.svg"
                            className="mr-3 w-4"/>
                            <span className="font-semibold text-sm" >구글로 회원가입</span>
                        </button>
                    </a>
                </div>
          </div>
      </div>
    </div>
 </div>
)};

export default signupModal
