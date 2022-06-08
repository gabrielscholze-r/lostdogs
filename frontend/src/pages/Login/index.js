import React, { useState } from 'react';
import { Alert } from 'react-bootstrap';
import { useCookies } from 'react-cookie';
import Header from '../../components/Header';
import API from '../../config/API'
import './index.css'
function Login() {
  const [cookeis, setCookies] = useCookies(['auth'])
  const [alertMessage, setMessage] = useState("")
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")

  async function Login() {
    if (email == "" | password == "") {
      setMessage("FILL ALL THE FIELDS!")
    }
    else {
      var response = await API.post('/person/auth',null, {params: {
        email,
        password
      }})
      console.log(response)
      if (response) {
        setCookies('log', 1, { path: "/" })
      }
      else {
        setCookies('log', 0, { path: "/" })
        setMessage("Password or Email incorrect")
      }

    }


  }

  return (
    <div className="Login">
      <Header />
      <div className="login-form-container p-3">
        <h3 id="login-title">LOGIN</h3>
        <input type="text" className="text-input my-3" placeholder='Username' onChange={e => setEmail(e.target.value)} />
        <input type="password" className="text-input my-3" placeholder='Password' onChange={e => setPassword(e.target.value)} />
        <button className="login-button mt-5 mb-2" onClick={e => Login()}>ENTER</button>
        <p className='error-message'>{alertMessage}</p>
      </div>
    </div>
  );
}

export default Login;