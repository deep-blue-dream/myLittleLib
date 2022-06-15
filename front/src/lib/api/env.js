// import dotenv from "dotenv"
// dotenv.config()

const API_KEY = process.env.NEXT_PUBLIC_GOOGLE_CLIENT_ID;
const API_KEY2 = process.env.REACT_APP_GOOGLE_CLIENT_SECRET;

export const OAUTH_REDIRECT_URI = "http://localhost:3000/"

export const GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth?client_id=" + API_KEY + 
                                "&redirect_uri=" + OAUTH_REDIRECT_URI +
                                "&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile" + 
                                "&response_type=token" + 
                                "&include_granted_scopes=true";

export default GOOGLE_AUTH_URL;
    