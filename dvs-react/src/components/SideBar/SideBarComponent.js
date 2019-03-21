import React, { Component } from "react";
import { NavLink } from "react-router-dom";
import homeIcon from "../../images/home-icon.png";
import documents from "../../images/documentsIcon.png";
import documentSubmit from "../../images/documentSubmitIcon.png";
import adminIcon from "../../images/adminIcon.png";
import statistics from "../../images/statistics.png";

class SideBarComponent extends Component {
  render() {
    return (
      <div className="sidebar-style">
        <ul id="side-bar-appear" className="nav navbar-nav mr-auto ">
          <li>
            <NavLink activeClassName={"active"} exact={true} to={"/"}>
              <img
                src={homeIcon}
                width="20"
                height="17"
                alt="home"
                className="sidebar-icon logo"
              />
              Pradinis puslapis
            </NavLink>
          </li>

          <li>
            <NavLink activeClassName={"active"} to={"/docs"}>
              <img
                src={documents}
                width="20"
                height="20"
                alt="home"
                className="sidebar-icon logo"
              />
              Dokumentai
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName={"active"} to={"/docsforreview"}>
              <img
                src={documents}
                width="20"
                height="20"
                alt="home"
                className="sidebar-icon logo"
              />
              Dokumentai peržiūrai
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName={"active"} to={"/upload"}>
              <img
                src={documentSubmit}
                width="20"
                height="20"
                alt="home"
                className="sidebar-icon logo"
              />
              Dokumento įkėlimas
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName={"active"} to={"/statistics"}>
              <img
                src={statistics}
                width="20"
                height="20"
                alt="home"
                className="sidebar-icon logo"
              />
              Statistika
            </NavLink>
          </li>

          <li className="space-border" />

          <li>
            <NavLink activeClassName={"active"} to={"/admin"}>
              <img
                src={adminIcon}
                width="20"
                height="20"
                alt="home"
                className="sidebar-icon logo"
              />
              Administratoriaus rolė
            </NavLink>
          </li>
        </ul>
      </div>
    );
  }
}

export default SideBarComponent;
