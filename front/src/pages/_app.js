import { SessionProvider } from "next-auth/react"
import Head from 'next/head';
import 'tailwindcss/tailwind.css';
import DashboardLayout from '../dashboard/layout';



function MyApp({ Component, pageProps }) {
  return (
    <SessionProvider session={pageProps.session}>
      <Head>
        <meta charset="UTF-8"/>
        <meta name="keyword" content="HTML, meta, tag, element, reference"/>
        <meta name="description" content="HTML meta tag page"/>
        <meta name="author" content="Team-MyLittleLab"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>MyLittleLibrary</title>
      </Head>
      <DashboardLayout>
        <Component {...pageProps} />
      </DashboardLayout>
    </SessionProvider>
  );
}

export default MyApp;
