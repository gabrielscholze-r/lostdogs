import React from 'react';
import './index.css'
import logo from '../../assets/dogr-logo.png'
import { useHistory } from 'react-router-dom';

function Homepage() {
    let history = useHistory()
    return (
        <div className="Homepage">
            <div className="logo py-5">
                <img src={logo} alt="dorg-logo" className="dogr-logo"/>
            </div>
            <div className="description">
                <h3>Um lugar para procurar seu melhor amigo que se perdeu.</h3>
            </div>
            <div className="navigation-buttons my-5">
                <button className="login-button my-4" onClick={() => {history.push('/Login'); window.location.reload(false)}}>ENTRAR</button>
                <p className="register-button" onClick={() => {history.push('/Register'); window.location.reload(false)}}>Novo aqui? Cadastre-se!</p>
            </div>
        </div>
    );
}

export default Homepage;