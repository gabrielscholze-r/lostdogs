import React, { useState } from 'react';
import { Alert } from 'react-bootstrap';
import Header from '../../components/Header';
import API from '../../config/API'
import './index.css'
function Login() {
  const [alertMessage, setMessage] = useState("")
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  function Login(){
    if (username=="" | password==""){
      setMessage("FILL ALL THE FIELDS!")
    }
    else{
      try{
        var response = API.get('/auth',{
          username,
          password
        })
      }
      catch (error){
        console.log(error)
      }
      
    }

    
  }

  return (
    <div className="Login">
        <Header/>
        <div className="login-form-container p-3">
          <h3 id="login-title">LOGIN</h3>
          <input type="text" className="text-input my-3" placeholder='Username' onChange={e => setUsername(e.target.value)}/>
          <input type="password" className="text-input my-3" placeholder='Password' onChange={e => setPassword(e.target.value)}/>
          <button className="login-button mt-5 mb-2" onClick={e => Login()}>ENTER</button>
          <p className='error-message'>{alertMessage}</p>
        </div>
    </div>
  );
}

export default Login;