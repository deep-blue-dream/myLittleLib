import React from 'react';

const BookMarkButton = (props) => {
  return (
    <div className="m-auto">
      <div className="flex justify-between mb-4 pt-2 relative">
        <div className="flex items-center ">
          <button className="object-center w-10 h-10 rounded-full border-none  flex justify-center items-center bg-opacity-20 bg-white">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              color="gray"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
              className="feather feather-plus"
              onClick={props.BookClicked}
            >
              <path d="M12 5v14M5 12h14" />
            </svg>
          </button>
        </div>
      </div>
    </div>
  );
};

export default BookMarkButton;
