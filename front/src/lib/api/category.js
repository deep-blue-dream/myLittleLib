import baseURL from '.';

//POST 카테고리 등록 API
export const postCategoryAPI = (data) => fetch(`${baseURL}/category/save`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});

export const findCategoryAPI = (data) => fetch(`${baseURL}/category/search`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});





