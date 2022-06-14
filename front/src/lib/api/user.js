import baseURL from '.';

//POST 카테고리 등록 API
export const postSignInAPI = (data) => fetch(`${baseURL}/user/signin`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});



