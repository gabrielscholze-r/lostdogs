import React from 'react';
import logo from '../../assets/dogr-logo.png';
import './index.css'
function Header() {
  return (
    <div class="header-component">
        <img src={logo} alt="dogr-logo" className="dogr-logo"/>
    </div>
    );
}

export default Header;