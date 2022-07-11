import NextAuth from 'next-auth'
import GoogleProvider from "next-auth/providers/google"

export default NextAuth({
  providers: [
    GoogleProvider({
        clientId: process.env.GOOGLE_CLIENT_ID,
        clientSecret: process.env.GOOGLE_CLIENT_SECRET
    })
  ],
  // A database is optional, but required to persist accounts in a database
  database: process.env.DATABASE_URL,
  secret: process.env.SECRET

})
