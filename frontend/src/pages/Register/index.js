import React, { useState } from 'react';
import Header from '../../components/Header';
import API from '../../config/API';
import './index.css'

function Register() {
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [email2, setEmail2] = useState("")
    const [phone, setPhone] = useState("")
    const [password, setPassword] = useState("")
    const [password2, setPassword2] = useState("")
    const [msg, setMSG] = useState("")


    async function CreateAccount() {
        if (email !== email2) {
            setMSG("Emails do not match")
        }
        else if (password!==password2){
            setMSG("Passwords do not match")
        }
        else{
            const response = await API.post('/person', {
                userName: name,
                email,
                phone,
                password
            }).catch(e => {
                setMSG("Email already exists")
                setEmail("")
                setEmail2("")
            })
            // push para homepage
        }
        
    }


    return (
        <div className="Register">
            <Header />
            <h3 id="login-title" className="mb-3">REGISTER</h3>
            <h4 className='error-message'>{msg}</h4>
            <input type="text" placeholder='Name' className="text-input-register my-2 mt-3" onChange={e => { setName(e.target.value) }} />
            <input type="text" placeholder='Email' className="text-input-register my-2" value={email} onChange={e => { setEmail(e.target.value) }} />
            <input type="text" placeholder='Confirm Email' className="text-input-register my-2" value={email2} onChange={e => { setEmail2(e.target.value) }} />
            <input type="text" placeholder='Phone' className="text-input-register my-2" onChange={e => { setPhone(e.target.value) }} />
            <input type="password" placeholder='Password' className="text-input-register my-2" onChange={e => { setPassword(e.target.value) }} />
            <input type="password" placeholder='Confirm Password' className="text-input-register my-2" onChange={e => { setPassword2(e.target.value) }} />
            <button className="create-account-button px-3 my-2 mb-3" onClick={() => {CreateAccount()}}>Create Account</button>
        </div>
    );
}

export default Register;