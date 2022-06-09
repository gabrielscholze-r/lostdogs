import React from 'react';
import './index.css'
import logo from '../../assets/dogr-logo.png'
import { useHistory} from 'react-router-dom';
import { getValue } from '@testing-library/user-event/dist/utils';
import { useCookies } from 'react-cookie';

function Homepage() {
    const [cookie, setCookies] = useCookies(["auth"])
    let history = useHistory()

    function redirect(value){
        console.log(value)
        history.push(`/${value}`)
        window.location.reload(false)
    }

    return (
        <div className="Homepage">
            <div className="logo py-5">
                <img src={logo} alt="dorg-logo" className="dogr-logo"/>
            </div>
            <div className="description">
                <h3>Um lugar para procurar seu melhor amigo que se perdeu.</h3>
            </div>
            <div className="navigation-buttons my-5">
                <button className="login-button my-4"  value="Login" onClick={e => redirect(e.target.value)}>ENTRAR</button>
                <p className="register-button" value="Register" onClick={e => redirect(e.target.value)}>Novo aqui? Cadastre-se!</p>
            </div>
        </div>
    );
}

export default Homepage;