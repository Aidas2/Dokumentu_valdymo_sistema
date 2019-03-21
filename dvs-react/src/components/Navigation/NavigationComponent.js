import React, { Component } from "react";
// import { Link } from "react-router-dom";
import logo from "../../images/home.png";
import LogoutContainer from "../login/LogoutContainer";
import adminIcon from "../../images/adminIcon.png";
import ServicesContext from "../context/ServicesContext";

class NavigationComponent extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-md navbar-dark  navigation-style">
        <div className="navbar-collapse collapse w-100 order-3 dual-collapse2 navigation-right-padding">
          <ul className="navbar-nav ml-auto">
            <li className="nav-item">
              <div className="dropdown">
                <span className="dot" />
                Prisijungęs vartotojas:{" "}
                <ServicesContext.Consumer>
                  {userNameObject => {
                    return <span> {userNameObject.userFromContext.name}</span>;
                  }}
                </ServicesContext.Consumer>
                <LogoutContainer />
              </div>
            </li>
          </ul>
        </div>
      </nav>
    );
  }
}

export default NavigationComponent;
