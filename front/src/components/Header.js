import React from 'react';

const Header = (props) => {
  let now = new Date();
  const week = ['일', '월', '화', '수', '목', '금', '토'];
  let dayOfWeek = week[now.getDay()];
  let todayYear = now.getFullYear();
  let todayMonth =
    now.getMonth() + 1 > 9 ? now.getMonth() + 1 : '0' + (now.getMonth() + 1);
  let todayDate = now.getDate() > 9 ? now.getDate() : '0' + now.getDate();
  return (
    <>
      <div className="flex justify-between text-white items-center mb-8">
        {/* <p className="text-4xl  font-bold">{title}</p> */}
        <p className="text-2xl text-yellow-300 font-bold">
          {todayYear -
            2000 +
            '.' +
            todayMonth +
            '.' +
            todayDate +
            '.' +
            dayOfWeek +
            '요일'}
        </p>
      </div>
      <div className="flex flex-wrap justify-between items-center pb-8">
        <div className="flex flex-wrap text-white">
          <div className="pr-10">
            <div className="text-2xl font-bold">
              안녕하세요, {props.session && props.session.user.name}님!
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Header;
