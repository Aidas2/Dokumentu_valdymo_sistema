import React, { Component } from "react";
import { Link } from "react-router-dom";

import logo from "../../images/home.png";

class SideBarComponent extends Component {
  render() {
    return (
      <div className="sidebar-style">
        <nav>
          <input type="checkbox" id="box" />
          <label id="container" for="box">
            <div id="button" className="vl">
              <ul id="login" className="navbar-nav mr-auto">
                <li className="nav-item ">
                  <Link
                    to={"/docs"}
                    className="nav-link side-bar-navigation-style"
                  >
                    Dokumentai
                  </Link>
                </li>
                <li className="nav-item">
                  <Link
                    to={"/upload"}
                    className="nav-link side-bar-navigation-style"
                  >
                    Dokumento įkėlimas
                  </Link>
                </li>
                <li className="nav-item">
                  <Link
                    to={"/history"}
                    className="nav-link side-bar-navigation-style"
                  >
                    Istorija
                  </Link>
                </li>
                <li className="nav-item">
                  <Link
                    to={"/admin"}
                    className="nav-link side-bar-navigation-style"
                  >
                    Administratoriaus rolė
                  </Link>
                </li>
              </ul>
            </div>
          </label>
        </nav>
      </div>
    );
  }
}

export default SideBarComponent;
