import React from 'react';
import Header from '../../components/Header';
import './index.css'

function Register() {
    return (
        <div className="Register">
            <Header/>
            <h3 id="login-title" className="mb-3">REGISTER</h3>
            <input type="text" placeholder='Name' className="text-input-register my-2 mt-3"/>
            <input type="text" placeholder='Email' className="text-input-register my-2"/>
            <input type="text" placeholder='Confirm Email' className="text-input-register my-2"/>
            <input type="text" placeholder='Phone' className="text-input-register my-2"/>
            <input type="text" placeholder='Password' className="text-input-register my-2"/>           
            <input type="text" placeholder='Confirm Password' className="text-input-register my-2"/>
            <button className="create-account-button px-3 my-2 mb-3">Create Account</button>
        </div>
    );
}

export default Register;