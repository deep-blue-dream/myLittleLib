import Content from '../components/content';



const HomePage = () => {
  const categoriesDummyData = [
    { id: 1, category: 'JAVA(카테고리 키워드)', title: '자바 공부', description: '자바 공부 유튜브 영상들만 모음-생활코딩'},
    { id: 2, category: 'MUSIC(카테고리 키워드)', title: '노래 목록', description: '힐링 음악 유튜브 영상들만 모음'},
    { id: 3, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 4, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 5, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 6, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 7, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 8, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'},
    { id: 9, category: 'GUITAR(카테고리 키워드)', title: '기타 강좌', description: '취미 공부용 기타 동영상'}
  ];
  
  return (
  // 현재 홈페이지에 메인에서만 반응형으로 변경되도록 함. 
  // 현재 sideNavigation의 data.js의 아이콘 클릭에 따라서 링크관련된 data 전달되도록 조치해놓음.
  <>
  <Content title="Home" category={categoriesDummyData}  />
  </>
  );
}

// 1. 서버에서 받아온 category.json 데이터 props로 전달 작업

export const getServerSideProps = async () => {
  // 카테고리 버튼 자동 생성 부분 작성중(더미 데이터)
    const categoriesDummyData = [
      { id: 1, category: 'JAVA(카테고리 키워드)', title: '자바 공부', description: '자바 공부 유튜브 영상들만 모음-생활코딩'},
      { id: 2, category: 'MUSIC(카테고리 키워드)', title: '노래 목록', description: '힐링 음악 유튜브 영상들만 모음'}
    ];

  
  try {
    // const res = await fetch('http://localhost:8080/api/users/categories');
    // const categories = await res.json();
    // console.log(categories);
    const categoriesTest = categoriesDummyData;
    

    return { // 객체를 반환
      props: {categoriesTest}
      // props: { categories } // 그 객체는 props라는 이름의 프로퍼티를 가지고 있고
      // 그 프로퍼티의 값은 객체
    }

  } catch (error) { //Exceptrion e 와 동일
    console.log(error);
    return { props: {} }
  }
};
export default HomePage;
