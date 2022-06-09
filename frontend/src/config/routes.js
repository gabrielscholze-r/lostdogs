import React, { useContext } from 'react';
import { Switch, Route } from 'react-router-dom'
import { useHistory } from 'react-router-dom';
import { useCookies } from 'react-cookie';
import Homepage from '../pages/Homepage';
import Login from '../pages/Login';
import Register from '../pages/Register';
import MainPage from '../pages/MainPage';
import AuthContext from './auth';

function Rotas() {
    const [isLogged, setLogged] = useContext(AuthContext)
    const [cookies, setCookies] = useCookies(['auth'])
    let history = useHistory()
    function rota(c) {
        if (isLogged) {
            return (
                <Switch>
                    <Route path="/Home">
                        <MainPage />
                    </Route>
                </Switch>
            )
        }
        else{
            if(cookies.log==1){
                setLogged(true)       
            }
            return (
                <Switch>
                    <Route exact path="/">
                        <Homepage />
                    </Route>
                    <Route path="/Login">
                        <Login />
                    </Route>
                    <Route path="/Register">
                        <Register />
                    </Route>
                </Switch>
            )
        }
       
    }
    return (
        <>
            {rota(cookies)}
        </>
    );
}

export default Rotas;