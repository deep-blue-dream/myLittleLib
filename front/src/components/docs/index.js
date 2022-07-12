
export default function Docs() {
  return (
    <div className="rounded-3xl max-w-full text-white bg-gray-800">
      <div className='flex flex-row'>
        <img src="/images/2.png" width={200} height={90} alt="MylittleLib_Logo" />
      </div>

      <section className="px-3 md:px-8">
        <h2 className="text-2xl font-medium"><strong>00. 🔵 팀원 소개 및 역할</strong></h2>
        <br/>
        <hr width="100%"/>
        <ol className="list-disc pl-6 mt-4">
          <li className="mb-6">      
            <a href='https://github.com/deep-blue-dream'>  
              <strong className='text-amber-200'>🔴 윤종섭</strong></a>   : 총괄 팀장, 프로젝트 일정 관리, 팀원 일정 관리
              <div>
                <strong>- FE (메인)</strong> &nbsp;: FE 서비스 구조 디자인(Architect), Google Login API 연결 및 세션관리, 컴포넌트 디자인, LightHouse 서비스 성능 평가
                <br/>
                <strong>- BE (서브)</strong> &nbsp;: BE 데이터 구조 디자인(ERD), CRUD 구조 확인 및 POSTMAN 확인
                <br/>
                <strong>- GIT (서브)</strong> : Git/GitHub Repository Version 관리. Git Branch 운영. Git Commit Rule 선정
              </div>
          </li>
          <li className="mb-6">
            <a href='https://github.com/wonillin'>
              <strong className='text-amber-200'>🟢 최원일</strong></a> : 비주얼 팀장❤️ (팀 복지)  <br/> 
              <div> 
                <strong>- FE (메인)</strong> &nbsp;: Next-Auth를 통한 Social Login 구현 등 라이브러리 적용, 전반적인 페이지 디자인 구성 및 기능 구현, 로고 제작 
                <br/>
                <strong> - BE (서브)</strong> &nbsp;:  BE 데이터 구조 디자인(ERD), CRUD 구조 확인
                <br/>
                <strong> - Notion (서브)</strong> : Notion 기능명세서 페이지 제작 
              </div>
          </li>
          <li className="mb-6">
          <a href='https://github.com/soulchicken'>  
              <strong className='text-amber-200'>🟠 김동현</strong></a>   : 백엔드 팀장
              <div>
                <strong>- BE (메인)</strong> &nbsp;: BE 디자인 패턴 아키텍트. 프로젝트 아키텍트 제작. Table과 기술명세서 작성. Model Class Entity 연결. DTO 패턴을 사용한 JSON 데이터 반환
                <br/>
                <strong>- FE (서브)</strong> &nbsp;: BE에서 받아온 유저의 카테고리, 북마크를 페이지에 출력하는 기능 구현.
                <br/>
                <strong> - GIT (서브)</strong> : Git/GitHub 총괄. Git Branch 관리. GitHub 레포지토리 관리. (+ gitignore 관리)
              </div>
          </li>
          <li className="mb-6">
            <a href='https://github.com/solhee-hwang'>
              <strong className='text-amber-200'>🟣 황솔희</strong></a> : 데이터베이스 팀장  <div>
                <strong> - BE &nbsp;(메인)</strong>  : ERD 작성 및 테이블 연결. 테이블들의 CRUD 작성. builder 패턴을 통한 코드 단순화. 기본 예외 처리. BE 디자인 패턴 재구축, DTO 패턴을 통한 Entity 직접 사용 방지
                <br />
                <strong> - FE &nbsp;(서브)</strong> : 서버측 데이터 받아오기 및 클라이언트 측에서 입력 된 회원 정보 데이터베이스에 등록
                <br />
                <strong> - GIT (서브)</strong> : 깃 버전 관리 , git commit rule 관리, git issue 생성 제안
                
              
              </div>
          </li>
          <li className="mb-6">
            <a href='https://github.com/gun-0208'>
              <strong className='text-amber-200'>🟡 강건</strong></a> : 데이터 통신 팀장, 예외처리 및 트러블 슈팅 총괄
              <div>
                <strong> - FE &nbsp;(메인)</strong> : google API간의 데이터 통신 및 세션관리. 프론트엔드 코드 리팩토링, 예외발생에 대한 처리 및 에러 확인
                <br/>
                <strong>- BE &nbsp;(서브)</strong> : 프론트/백엔드 서버 연결 및 데이터 송수신 기능 구현, DB데이터 기능의 역할에 따라 분기/적용
                <br/>
                <strong> - GIT (서브)</strong> : Git Branch 관리. GitHub 레포지토리 관리.
                </div>
          </li>
        </ol>  
      </section>
      
      <section className="px-2 md:px-8">
        <h2 className="text-2xl font-bold">01. 프로젝트 개요</h2>
        <br/>
        <hr width="100%"/>
        <ol className="list-disc pl-6 mt-4">
          <li className="mb-6">
            <strong>프로젝트 명</strong>-
            My Little Library
            <strong>주제</strong>-
            인터넷 브라우저 환경에서 사용자의 URL 활용을 위한 웹서비스 환경 구현을 주제로
            북마크 카테고리 및 리스트를 등록 관리 할 수 있는 통합 서비스를 디자인하였습니다. 
          </li>
          <li className="mb-6">
            <strong>개요</strong> -
            구글 이메일을 활용하여 로그인 및 회원가입을 할 수 있으며 등록된 유저는 자주 활용하는 북마크를 카테고리별 리스트를 등록하여
            <br/> 
          </li>
        </ol>
      </section>

      <section className="px-3 md:px-8 my-16">
        <h2 className="text-2xl font-bold">02. 기술 스택</h2>
        <br/>
        <hr width="100%"/>
          <div>
            <div className="mt-8 flex justify-start">
              <div className="pr-3"> 
                <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white"/>
              </div>  
              <div className="pr-3">
                <img src="http://img.shields.io/badge/-Java 11-007396?style=for-the-badge&logo=Java&logoColor=white"/>  
              </div>
              <div className="pr-3">
                <img src="http://img.shields.io/badge/-SPRING BOOT 2.7.0-white?style=for-the-badge&logo=Spring Boot&logoColor=6DB33F"/>  
              </div>
              <div className="pr-3">
                <img src="http://img.shields.io/badge/SPRING 5.3.20-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/MYSQL 8.0.28-4479A1?style=for-the-badge&logo=MYSQL&logoColor=white"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/-intelliJ-9060e8?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"/>
            </div>
              
            </div>

            <div className="mt-3 flex justify-start">
              <div className="pr-3">
               <img src="https://img.shields.io/badge/-JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=black"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/-React 18.1.0-50E3C2?style=for-the-badge&logo=react&logoColor=black"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/Next.JS 12.1.6-5b5b5b?style=for-the-badge&logo=Next.js&logoColor=white"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/Next Auth-4479A1?style=for-the-badge&logo=AdGuard&logoColor=white"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/VCode-007ACC?style=for-the-badge&logo=Visual Studio Code&logoColor=white"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/-Git-F05032?style=for-the-badge&logo=git&logoColor=ffffff"/>
              </div>
              <div className="pr-3">
                <img src="https://img.shields.io/badge/-GitHub-000000?style=for-the-badge&logo=GitHub"/>
              </div>
              

            </div>
            </div>
        
      </section>
      <section className="px-3 md:px-8 my-16">
        <h2 className="text-2xl font-bold">03. 서비스 아키텍처</h2>
        <br/>
        <hr width="100%"/>
        <div className=" flex justify-center pt-10">
          <img src="/images/archi.png" width={1050} height={1050} alt="MylittleLib_Arch" />
        </div>


      </section>

      <section className="px-2 md:px-8">
        <h2 className="text-2xl font-bold">04. 도메인 용어 정의</h2>
        <br/>
        <hr width="90%"/>
        <ol className="list-disc pl-6 mt-4">
          <li className="mb-6">
              <strong>서비스</strong>-
              서비스는 어플리케이션에서 제공하는 기능을 의미한다. 
              본 서비스의 주요 목적은 방문자 및 가입자에게 <br/> 쾌적한 공부 환경 
              제공 및 북마크 자동 등록 및 카테고리 등록 기능이며, 
              그 외 보조 기능들을 다양하게 제공하고 있다.
          </li>
          <li className="mb-6">
            <strong>가입자</strong> -
            방문자는 어플리케이션에 로그인 양식을 제출하지 않았거나 회원 가입 절차를 진행하지 않은 유저를 의미한다. <br/>
            방문자는 메인 페이지에서만 제공하는 서비스를 이용할 수 있으며 가입자에게 제공되는 서비스를 이용하는데 제한을 가지고 있다.
          </li>
          <li className="mb-6">
            <strong>방문자</strong> -
            방문자는 어플리케이션에 로그인 양식을 제출하지 않았거나 회원 가입 절차를 진행하지 않은 유저를 의미한다.<br/> 
            방문자는 메인 페이지에서만 제공하는 서비스를 이용할 수 있으며 가입자에게 제공되는 서비스를 이용하는데 제한을 가지고 있다.
          </li>
          <li className="mb-6">
            <strong>메인페이지</strong> -
            주요 서비스를 이용할 수 있는 웹 페이지를 의미한다. 시계, 날씨, Todo리스트, <br/>
            로그인 기능들이 있으며 방문자 및 가입자는 메인페이지를 활용하여 목적에 맞는 어플리케이션을 사용할 수 있다.
          </li>
          <li className="mb-6">
            <strong>북마크</strong> -
            주요 서비스를 이용할 수 있는 웹 페이지를 의미한다. 시계, 날씨, Todo리스트, <br/>
            로그인 기능들이 있으며 방문자 및 가입자는 메인페이지를 활용하여 목적에 맞는 어플리케이션을 사용할 수 있다.
          </li>
          <li className="mb-6">
            <strong>카테고리</strong> -
            가입자가 등록한 북마크의 주제/목적/내용 등을 규격화 하여 제공하는 목록이다. <br/>
            가입자 또는 방문자는 공개된 북마크에 한하여 카테고리 별 북마크 키워드를 검색할 수 있다.
          </li>
          <li className="mb-6">
            <strong>테이블</strong> -
            가입자가 등록하고자 하는 북마크를 행렬화 하여 각각 제목,카테고리, <br/>
            설명을 데이터 베이스에 저장 및 수정, 삭제할 수 있도록 제공하는 양식을 의미한다.
          </li>
          <li className="mb-6 text-gray-500">
            <strong>친구</strong> -
            사전적인 의미로 자기와 가까우며 정이 두터운 사람이다. 도메인상에서의 의미는 <br/>
            가입자와 가입자 간에 연관관계를 설정하여 서로의 정보와 카테고리(북마크)를 열람할 수 있도록 도와주는 관계를 의미한다.
          </li>
          <li className="mb-6 text-gray-500">
            <strong>좋아요</strong> -
            페이스북 등 소셜 네트워크 서비스-이하 SNS-에서 공감, 또는 추천의 의미로 사용하는 기능이다.
          </li>
          <li className="mb-6 text-gray-500">
            <strong>TodoList</strong> -
            해야 할 일의 목록을 뜻한다. 하는 것, 해야할 것을 알기 쉽게 시각화하여 작업의 우선순위를 매기고 <br/>
            시간관리를 쉽게 하기 위해 사용한다. 가입자는 TodoList를 사용하여 서비스를 효율적으로 사용하도록 돕는데 목적이 있다.
          </li>
          <li className="mb-6 text-gray-500">
            <strong>권한</strong> -
            가입자는 공개된 카테고리의 북마크를 검색할 수 있으며, <br/>
            자신이 등록한 카테고리와 북마크를 다른 방문자 및 가입자의 열람 여부를 결정할 수 있다.
          </li>

        </ol>
      </section>

      <section className="px-3 md:px-8 my-16">
<h2 className="text-2xl font-bold">05. UI 목업</h2>
<br/>
<div className=" flex justify-center pt-10">
          <img src="/images/UI.JPG" width={1050} height={1050} alt="UI 목업" />
        </div>
</section>


<section className="px-3 md:px-8 my-16">
<h2 className="text-2xl font-bold">06. DATABASE</h2>
<br/>
<img src ="./front/public/images/Erd.png" alt= "ERD 테이블"/>
</section>
<section className="px-3 md:px-8 my-16">
<h2 className="text-2xl font-bold">07. 기술 명세</h2>
<br/>
<a href='https://documenter.getpostman.com/view/21185841/UzBjt8jV
'>  <br/>
    <strong className='text-amber-200'>API DOCS</strong> : POST MAN API DOCS

  </a>
  <div className=" flex justify-center pt-10">
          <img src="/images/기능명세.png" width={1050} height={1050} alt="기능 명세서" />
        </div>
</section>

      <section className="px-3 md:px-8 my-16">
        <h2 className="text-2xl font-bold">08. 시연 영상</h2>
        <br/>
        <hr width="90%"/>
          발표시 영상 참고
      </section>

      <section className="px-2 md:px-8">
        <h2 className="text-2xl font-bold">09. 트러블 슈팅</h2>
        <br/>
        <hr width="90%"/>
        <ol className="list-disc pl-6 mt-4">
          <li className="mb-6">
            <strong className='text-amber-200'>1) BE - Entity 순환참조</strong>
            <div className="text-amber-300 font-bold"><a href="https://thalals.tistory.com/303"><strong>- 참고 링크 ← 클릭</strong></a></div>
            <div>- Entity를 JSON으로 변환할때 생기는 이슈. 테이블 참조로 생긴 무한 재귀이다.</div>
            <div>- @JsonIgnore 어노테이션을 사용하거나 DTO 패턴을 사용하여 해결해야한다.</div>
            
            <div>- DTO 패턴을 통해 바로 객체를 내보내지 않고 API로 보낼 객체를 따로 세팅했다.</div>
          </li>
          <li className="mb-6">
  <strong className='text-amber-200'>FE - 백엔드 서버로 부터 데이터 받아오는 과정에서의 문제</strong>

  <div>

</div> - 1단계 : serverSideProps()등의 메서드를 통해 초기 렌더링 시userEmail과 매칭되는 데이터를 받아오려고 했으나, 인자 값을 넣어주는 단계가 필요하기 때문에 사용 어려움 확인.
<div>
- 2단계 : fetch 메서드의 .then을 통해 데이터를 받아오는 것 까지 확인. 이를 반환하면 Promise로 감싸져 객체 내에 있는 value접근하지 못함. setState()로 값을 변경하면 컴포넌트가 무한 렌더링하면서 루프에 빠지는 문제 발생.</div>
<div>
- 3단계 : useEffect() 메서드를 사용하여 데이터를 받아오고, setState()를 해주었더니 값이 한번 저장되고, 해결 됨.
</div>
</li>
<li className="mb-6">
  <strong className='text-amber-200'>FE - Google Login API를 이용한 로그인 세션 관련</strong>
  <div>
- API를 이용해 로그인을 하고, 이 Email주소가 DB의 Email과 일치하는지 확인하는 과정을 구현. Google 로그인 후 Session이 생성되는 시기 불확실로, 일치여부 확인단계보다 늦게 생성되어, session이 null로, email을 담지 못하는 문제 발생. </div>
<div>- 대체방안으로 로그인이 실행되고 메인 홈페이지로 가기 전에 다른 페이지에서 거쳐가도록 재구현. </div>
<div>- 추후에 보완하여 메인으로 바로 접속해도 Session이 생성되도록 구현하는 것이 목표. </div> 

</li>
        </ol>
      </section>

      <section className="px-3 md:px-8 my-16">
        <h2 className="text-2xl font-medium"><strong>10. 느낀 점</strong></h2>
        <br/>
        <hr width="90%"/>
        <ol className="list-disc pl-6 mt-4">
          <li className="mb-6">      
            <a href='https://github.com/deep-blue-dream'>  
              <strong className='text-amber-200'>윤종섭</strong>  </a>: 열정있는 사람들 만나서 함께 배우는 멋진 시간을 가졌습니다. 백엔드도, 프론트도 각각의 어려움이 있다는 것을 느꼈고, 데이터의 이동을 컨트롤 하는 것에 대한 어려움을 크게 느꼈습니다. 활용할 수 있는 기능들은 넘쳐나지만 문제없이 녹여내는 게 참 어렵구나 싶어요! 경험을 더 쌓아서 보다 제대로 된 서비스를 구현해보고 싶습니다!
             
          </li>
          <li className="mb-6">
            <a href='https://github.com/wonillin'>
              <strong className='text-amber-200'>최원일</strong> </a> : 코딩으로 밤을 지샜던 한 주였읍니다... 라이브러리를 이용해서 많은 기능을 구현해 볼 수 있어서 재밌었습니다 ! MyLittleLab forever...💖
     
          </li>
          <li className="mb-6">
            <a href='https://github.com/soulchicken'>
              <strong className='text-amber-200'>김동현</strong> </a> : 좋은 팀. 좋은 경험이었습니다.👍 모두가 백엔드고 프론트였습니다. 조금만 더 저희가 JS, Next를 했다면 더 재밌는 기능들을 넣을 수 있었을 것 같습니다. 아쉬움은 남지만 그래도 너무 많이 배웠습니다. 더 공부하고 싶어지는게 많아지네요.

          </li>
          <li className="mb-6">
            <a href='https://github.com/solhee-hwang'>
              <strong className='text-amber-200'>황솔희</strong>  </a>: 마지막까지 promise는 날 괴롭힌다😭 백엔드보다 프론트가 훨씬 어렵다고 느꼈던 프로젝트였습니다,, 백엔드에서 예외처리를 좀 더 세밀하게 할 필요성을 느끼게 해준 프로젝트였습니다.
   
          </li>
          <li className="mb-6">
            <a href='https://github.com/gun-0208'>
              <strong className='text-amber-200'>강건</strong>  </a>:  프론트/백엔드 서버간 통신으로 next.js에서 비동기 함수를 사용하면서 삽질을 많이 했던 것 같습니다. 앞으로 어떤 부분에서 더 공부가 필요한지 알 수 있는 계기가 되었습니다. 원래는 개인적인 사정으로 혼자 프로젝트를 진행하다가 중간에 합류하여 처음부터 같이 하지 못한게 쪼금 아쉽지만 짧은 기간에도 정말 많은 것을 공유했고, 이번 프로젝트를 통해 다시한번 건강과 협업의 중요성을 느꼈습니다!
          </li>
        </ol>  
      </section>
    <div className='mt-6'>.</div>  
    </div>

    
  );
}
