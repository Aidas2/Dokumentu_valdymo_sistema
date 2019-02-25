import React, { Component } from "react";
import { Link } from "react-router-dom";

import logo from "../../images/home.png";

class NavigationComponent extends Component {
  render() {
    return (
      <nav class="navbar navbar-expand-md navbar-dark bg-dark navigation-style">
        <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
          <Link to={"/"} className="nav-link logo">
            <img src={logo} width="40" height="20" />
          </Link>

          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <Link to={"/upload"} className="nav-link">
                Dokumento įkėlimas
              </Link>
            </li>
            <li class="nav-item">
              <Link to={"/history"} className="nav-link">
                Istorija
              </Link>
            </li>
            <li class="nav-item">
              <Link to={"/admin"} className="nav-link">
                Administratoriaus rolė
              </Link>
            </li>
          </ul>
        </div>

        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <Link to={"/"} className="nav-link">
                Prisijungęs vartotojas
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    );
  }
}

export default NavigationComponent;

{
  /*      <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <Link to={"/"} className="nav-link">
            Pradinis puslapis
          </Link>

          <Link to={"/upload"} className="nav-link">
            Dokumento įkėlimas
          </Link>

          <Link to={"/history"} className="nav-link">
            Istorija
          </Link>

          <Link to={"/admin"} className="nav-link">
            Administratoriaus prisijungimas
          </Link>
        </nav>
     
    */
}
