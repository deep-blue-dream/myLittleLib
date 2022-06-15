import baseURL from '.';

//POST 카테고리 등록 API
export const postSignInAPI = async (data) => {

    const res = await fetch(`${baseURL}/user/signin`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const user =  await res.json();

    // user.then(result => result);

    // console.log(user);
    return user;

}



