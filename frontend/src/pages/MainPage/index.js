import React, { useContext } from 'react';
import { useCookies } from 'react-cookie';
import { useHistory } from 'react-router-dom';
import Feed from '../../components/Feed';
import Header from '../../components/Header';
import SideBar from '../../components/SideBar';
import AuthContext from '../../config/auth';
import './index.css';


function MainPage() {
    const [isLogged, setLogged] = useContext(AuthContext)
    let history = useHistory()
    const [cookie, setCookies] = useCookies(["auth"])
    return (
        <div>
            <Header />
            <div className="MainPage">
                <div className='SideMenu-component'>
                    <SideBar/>
                </div>
                <div className='Feed-component'>
                    <Feed/>
                </div>
            </div>
        </div>
    );
}

export default MainPage;