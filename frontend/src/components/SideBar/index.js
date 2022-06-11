import React from 'react';
import './index.css'
import { UilSignout, UilUser, UilUsersAlt } from '@iconscout/react-unicons'

function SideBar() {
  return (
    <div className="SideBar">
      <div className="signout-container pt-5">
        <UilUser size="70" className="signout-icon" />
        <label className="signout-text">PROFILE</label>
      </div>
      <div className="signout-container  mt-1 pt-5">
        <UilUsersAlt size="70" className="signout-icon" />
        <label className="signout-text">FRIENDS</label>
      </div>
      <div className="signout-container last-opt  mt-1 pt-5">
        <UilSignout size="70" className="signout-icon" />
        <label className="signout-text">SIGNOUT</label>
      </div>

    </div>
  );
}

export default SideBar;