import baseURL from '.';

//POST 카테고리 등록 API
export const postBookMarkAPI = (data) => fetch(`${baseURL}/bookmark`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});



