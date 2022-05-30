import React from 'react';
import './index.css'
import logo from '../../assets/dogr-logo.png'

function Homepage() {
    return (
        <div className="Homepage">
            <div className="logo py-5">
                <img src={logo} alt="dorg-logo" className="dogr-logo"/>
            </div>
            <div className="description">
                <h3>Um lugar para procurar seu melhor amigo que se perdeu.</h3>
            </div>
            <div className="navigation-buttons my-5">
                <button className="login-button my-4">ENTRAR</button>
                <p className="register-button ">Novo aqui? Cadastre-se!</p>
            </div>
        </div>
    );
}

export default Homepage;