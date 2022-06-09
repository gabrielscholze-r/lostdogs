import React from 'react';
import './index.css'
import { UilSignout } from '@iconscout/react-unicons'

function SideBar() {
  return (
      <div className="SideBar">
        <nav className="signout-container p-2 mt-1">
          <UilSignout size="70" className="signout-icon"/>
          <label className="signout-text">SIGNOUT</label>
        </nav>
        
      </div>
  );
}

export default SideBar;