import React, { Component } from "react";
import { Link } from "react-router-dom";

class NavigationComponent extends Component {
  render() {
    return (
      <div>
        <nav className="nav justify-content-end">
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
      </div>
    );
  }
}

export default NavigationComponent;
