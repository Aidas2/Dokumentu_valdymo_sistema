import React, { Component } from "react";
// import { Link } from "react-router-dom";
import logo from "../../images/home.png";
import LogoutContainer from "../login/LogoutContainer";
import adminIcon from "../../images/adminIcon.png";

class NavigationComponent extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-md navbar-dark  navigation-style">
        {/*  
        <div className="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
          <Link to={"/"} className="nav-link logo ">
            <img src={logo} width="40" height="20" alt="home" />
          </Link>

          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/docs"} className="nav-link">
                Dokumentai
              </Link>
            </li>{" "}
            <li className="nav-item">
              <Link to={"/upload"} className="nav-link">
                Dokumento įkėlimas
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/history"} className="nav-link">
                Istorija
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/admin"} className="nav-link">
                Administratoriaus rolė
              </Link>
            </li>
          </ul>
        </div>
*/}
        <div className="navbar-collapse collapse w-100 order-3 dual-collapse2 navigation-right-padding">
          <ul className="navbar-nav ml-auto">
            <li className="nav-item">
              <div className="dropdown">
                <span className="dot" />
                Prisijungęs vartotojas
                <div className="dropdown-content">
                  <a href="https://www.google.com/">Nustatymai</a>
                  <LogoutContainer />
                  {/* <a href="http://localhost:8081/login?logout/">Atsijungti</a> */}
                </div>
              </div>
            </li>
          </ul>
          <LogoutContainer />
          {/* <Link to={"/logout"} className="nav-link">
            Atsijungti
          </Link> */}
        </div>
      </nav>
    );
  }
}

export default NavigationComponent;
