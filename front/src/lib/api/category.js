import baseURL from '.';

//POST 카테고리 등록 API
export const postCategoryAPI = (data) => fetch(`${baseURL}/user/category`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});