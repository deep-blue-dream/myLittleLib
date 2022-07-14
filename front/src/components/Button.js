import React from 'react';

const Button = (props) => {
  return (
    <div className="flex max-h-45">
      <div className="m-auto">
        <div className="flex justify-between mb-4 pt-2 relative">
          <div className="flex items-center ">
            <button
              className="object-center w-20 h-20 rounded-full border-none  flex justify-center items-center bg-white"
              onClick={props.clicked}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="feather feather-plus"
              >
                <path d="M12 5v14M5 12h14" />
              </svg>
            </button>
          </div>
        </div>
        {/* 버튼 중앙 정렬 div wrap 기능 종료  */}
      </div>
    </div>
  );
};

export default Button;
