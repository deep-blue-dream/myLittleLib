import Content from '../components/content';

export default function HomePage() {
  return (
  // 현재 홈페이지에 메인에서만 반응형으로 변경되도록 함. 
  // 현재 sideNavigation의 data.js의 아이콘 클릭에 따라서 링크관련된 data 전달되도록 조치해놓음.
  <>
  <Content title="Home" />
  </>
  );
}
