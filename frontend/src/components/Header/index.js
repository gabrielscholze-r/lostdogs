import React from 'react';
import logo from '../../assets/dogr-logo.png';
import './index.css'
function Header() {
  return (
    <header class="header-component">
        <img src={logo} alt="dogr-logo" className="dogr-logo"/>
    </header>
    );
}

export default Header;