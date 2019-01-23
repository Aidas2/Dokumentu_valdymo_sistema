import React from "react";
import { NavLink } from "react-router-dom";

import "./Navigation.css";

const Navigation = () => {
  return (
    <div className="navigation">
      <ul className="navigation_ul">
        <li>
          <NavLink to="/">
            <div>Services</div>
          </NavLink>
        </li>
        <li>
          <NavLink to="/providers">
            <div>Providers</div>
          </NavLink>
        </li>
        {/* <li>
          <NavLink to="/uploader">
            <div>Image uploader</div>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin">
            <div>Admin Panel</div>
          </NavLink>
        </li> */}
      </ul>
    </div>
  );
};

export default Navigation;
