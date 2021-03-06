import baseURL from '.';

export const postSignInAPI = data => fetch(`${baseURL}/user/signin`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});
export const postSignUpAPI = data => fetch(`${baseURL}/user/signup`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
});
