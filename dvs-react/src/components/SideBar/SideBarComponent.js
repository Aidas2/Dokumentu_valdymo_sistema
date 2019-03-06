import React, { Component } from "react";
import { Link } from "react-router-dom";
import collapse_icon from "../../images/collapse-icon.png";

class SideBarComponent extends Component {
  render() {
    return (
      <div className="sidebar-style">
        <nav>
          <input type="checkbox" id="side-bar-box" />
          <label id="side-bar-container" htmlFor="side-bar-box">
            <img
              src={collapse_icon}
              className="side-bar-logo"
              alt="collaped icon"
            />

            <ul id="side-bar-appear" className="navbar-nav mr-auto">
              <li className="nav-item ">
                <Link to={"/docs"} className="nav-link ">
                  Dokumentai
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/upload"} className="nav-link ">
                  Dokumento įkėlimas
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/history"} className="nav-link ">
                  Istorija
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link ">
                  Administratoriaus rolė
                </Link>
              </li>
            </ul>
          </label>
        </nav>
      </div>
    );
  }
}

export default SideBarComponent;
