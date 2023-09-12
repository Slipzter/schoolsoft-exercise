"use client"

import React, { useState } from 'react';
import UserCard, { User } from './UserCard';

function App() {
  const [userData, setUserData] = useState('');
  const [apiResponse, setApiResponse] = useState('');
  const [userArray, setUserArray] = useState([]);
  const [nthNumber, setNthNumber] = useState('');

  const baseURL = "http://localhost:8081/api/methods";

  const getRequest = (endpoint: string) => {
    clear();
    fetch(baseURL + endpoint, {
      method: 'GET',
    })
      .then((response) => response.json())
      .then((data) => {
        setUserArray(data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const postRequest = (endpoint: string, inputType: string) => {
    clear();
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

  const postReqNthNumber = (endpoint: string, inputType1: string, inputType2: string) => {
    clear();
    const numbers: number[] = userData.split(',').map((char) => parseInt(char.trim()));
    console.log(numbers.toLocaleString());
    fetch(baseURL + endpoint, {
      method: 'POST',
      headers:  {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `${inputType1}=${numbers.toLocaleString()}&${inputType2}=${nthNumber}`,
    })
      .then((response) => response.text())
      .then((data) => {
        setApiResponse(data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const clear = () => {
    setUserArray([]);
    setApiResponse('');
  }
  

  return (
    <div className='container'>
      <header className='main__header'>
        <h1 className='main__title'>Schoolsoft Coding Exercise</h1>
      </header>
      <main className='main__content'>
        <section className='input-top'> 
          <input
            type="text"
            placeholder="Input Here"
            value={userData}
            onChange={(e) => setUserData(e.target.value)}
            className='input-top__field input'
          />
          <div className='top-buttons'>
            <button className='button' onClick={() => postRequest('/reversestring', 'string')}>Reverse Your Input</button>
            <button className='button' onClick={() => postRequest('/ispalindrome', 'string')}>Check If Your Input Is A Palindrome</button>
            <button className='button' onClick={() => postRequest('/padnumberwithzeroes', 'number')}>Pad Number With Zeroes</button>
          </div>
          <input
            type="text"
            placeholder="Nth Number Here"
            value={nthNumber}
            onChange={(e) => setNthNumber(e.target.value)}
            className='input-bottom__field input'
          />
          <button className='button' onClick={() => postReqNthNumber('/findnthlargestnumber', 'numbers', 'nthlargestnumber')}>Find The Nth Largest Number From Your Input</button>
        </section>
        <aside className="main__output">
          <div className='main__output-text'>
            {apiResponse ? <article className='main__output-string'>{apiResponse.replaceAll('\"', "")}</article> : userArray.map((user: User) => {
              return <UserCard id={user.id} firstname={user.firstname} palindrome={user.palindrome} lastname={user.lastname} age={user.age} username={user.username} />
            })}
          </div>
          <div className='main__output-buttons'>
            <button className='button' onClick={() => getRequest('/users')}>Get Users</button>
            <button className='button' onClick={() => getRequest('/userswithreversednames')}>Get Users With Reversed First Names</button>
            <button className='button clear-button' onClick={clear}>Clear</button>
          </div>
        </aside>
      </main>
      <footer className='main__footer'>
        <h5 className='dev-name'>Tim Hansson Meng</h5>
        <a className='link' href="https://github.com/Slipzter"><img className='github-logo' src="github.png" /></a>
        <a className='link' href="https://www.linkedin.com/in/tim-hansson-meng-b9087b118/"><img className='linkedin-logo' src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" /></a>
      </footer>
    </div>
  );
}

export default App;
