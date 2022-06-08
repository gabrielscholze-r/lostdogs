import React from 'react';
import { Switch, Route } from 'react-router-dom'
import { useHistory } from 'react-router-dom';
import { useCookies } from 'react-cookie';
import Homepage from '../pages/Homepage';
import Login from '../pages/Login';
import Register from '../pages/Register';
import MainPage from '../pages/MainPage';

function Rotas() {
    const [cookies, setCookies] = useCookies(['auth'])
    function rota(c) {
        if (c == 1) {
            return (
                <>
                    <MainPage/>
                </>
            )
        }
        return (
            <Switch>
                <Route exact path="/">
                    <Homepage/>
                </Route>
                <Route path="/Login">
                    <Login/>
                </Route>
                <Route path="/Register">
                    <Register/>
                </Route>
            </Switch>
        )
    }
    return (
        <>
            {rota(cookies)}
        </>
    );
}

export default Rotas;