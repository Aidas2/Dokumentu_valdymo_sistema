import React, { Component } from "react";
import { Link } from "react-router-dom";
const LogoutComponent = props => {
  return (
    <div className="dropdown-content">
      <a href="https://www.google.com/">Nustatymai</a>
      <Link to="" onClick={props.onClick}>
        Atsijungti
      </Link>
    </div>
  );
};

export default LogoutComponent;
