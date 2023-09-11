"use client"

import React, { useState } from 'react';

function App() {
  const [userData, setUserData] = useState('');
  const [apiResponse, setApiResponse] = useState('');
  const [nthNumber, setNthNumber] = useState('');

  const baseURL = "http://localhost:8081/api/methods";

  const getRequest = (endpoint: string) => {
    fetch(baseURL + endpoint, {
      method: 'GET',
    })
      .then((response) => response.json())
      .then((data) => {
        setApiResponse(JSON.stringify(data));
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const postRequest = (endpoint: string, inputType: string) => {
    fetch(baseURL + endpoint, {
      method: 'POST',
      headers:  {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `${inputType}=${userData}`,
    })
      .then((response) => response.text())
      .then((data) => {
        setApiResponse(JSON.stringify(data));
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const postRequest2 = (endpoint: string, inputType1: string, inputType2: string) => {
    const numbers: number[] = userData.split(',').map((char) => parseInt(char.trim()));
    console.log(numbers.toLocaleString());
    fetch(baseURL + endpoint, {
      method: 'POST',
      headers:  {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `${inputType1}=${numbers.toLocaleString()}&nthlargestnumber=${nthNumber}`,
    })
      .then((response) => response.text())
      .then((data) => {
        setApiResponse(JSON.stringify(data));
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const clear = () => {
    setApiResponse('');
  }
  

  return (
    <main className='main'>
      <header className='main__header'>
        <h1 className='main__title'>Schoolsoft Coding Exercise</h1>
      </header>
      <section className='input-top'>
        <input
          type="text"
          placeholder="Write Here"
          value={userData}
          onChange={(e) => setUserData(e.target.value)}
        />
        <div className='top-buttons'>
          <button className='button' onClick={() => getRequest('/users')}>Get Users</button>
          <button className='button' onClick={() => getRequest('/userswithreversednames')}>Get Users With Reversed First Names</button>
          <button className='button' onClick={() => postRequest('/reversestring', 'string')}>Reverse Your Input</button>
          <button className='button' onClick={() => postRequest('/ispalindrome', 'string')}>Check If Your Input Is A Palindrome</button>
          <button className='button' onClick={() => postRequest('/padnumberwithzeroes', 'number')}>Pad Number With Zeroes</button>
          <button className='button' onClick={clear}>Clear</button>
        </div>
      </section>
      <input
        type="text"
        placeholder="Nth Number Here"
        value={nthNumber}
        onChange={(e) => setNthNumber(e.target.value)}
      />
      <button onClick={() => postRequest2('/findnthlargestnumber', 'numbers', 'nthlargestnumber')}>Find The Nth Largest Number</button>
      <article id="apiResponse">{apiResponse}</article>
      <footer className='main__footer'>
        <h5 className='dev-name'>Tim Hansson Meng</h5>
        <a href="https://github.com/Slipzter"><img className='github-logo' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" /></a>
        <a href="https://github.com/Slipzter"><img className='linkedin-logo' src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" /></a>
      </footer>
    </main>
  );
}

export default App;
