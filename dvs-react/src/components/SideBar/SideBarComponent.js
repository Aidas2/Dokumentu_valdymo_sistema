import React, { Component } from "react";
import { Link } from "react-router-dom";

import logo from "../../images/home.png";

class SideBarComponent extends Component {
  render() {
    return (
      <div className="sidebar-style">
        <nav className="navbar ">
          <Link to={"/"} className="nav-link logo">
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

          <div className="navbar-collapse collapse w-100 order-3 dual-collapse2">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/"} className="nav-link">
                  Prisijungęs vartotojas
                </Link>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    );
  }
}

export default SideBarComponent;
