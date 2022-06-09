import React, { useContext, useState } from 'react';
import { Alert } from 'react-bootstrap';
import { useCookies } from 'react-cookie';
import { useHistory } from 'react-router-dom';
import Header from '../../components/Header';
import API from '../../config/API'
import AuthContext from '../../config/auth';
import './index.css'
function Login() {
  const [isLogged, setLogged] = useContext(AuthContext)
  const [cookeis, setCookies] = useCookies(['auth'])
  const [alertMessage, setMessage] = useState("")
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  let history = useHistory()
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
      if (response.data) {
        setLogged(true)
        setCookies('log', 1, { path: "/" })
        history.push('/Home')
        window.location.reload(false)
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
        <p className='error-message'>{alertMessage}</p>
        <input type="text" className="text-input my-3" placeholder='Username' onChange={e => setEmail(e.target.value)} />
        <input type="password" className="text-input my-3" placeholder='Password' onChange={e => setPassword(e.target.value)} />
        <button className="login-button mt-3 mb-3" onClick={e => Login()}>ENTER</button>
        <button className="back-button mt-3 mb-4"  onClick={e =>{ history.push('/'); window.location.reload(false)}}>VOLTAR</button>
      </div>
    </div>
  );
}

export default Login;