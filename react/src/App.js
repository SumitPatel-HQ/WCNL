import React, { useRef } from 'react';


function FocusInput() {
  const inputRef = useRef(null);


  const handleFocus = () => {
    inputRef.current.focus();
  };


  return (
    <div style={{ padding: '50px', textAlign: 'center' }}>
      <h2 style={{ color: 'blue' }}>Click Button to Focus Input</h2>
     
      <input
        ref={inputRef}
        type="text"
        placeholder="Type here..."
      />
      <br />
     
      <button
        onClick={handleFocus}
      >
        Focus Input
      </button>
    </div>
  );
}


export default FocusInput;
