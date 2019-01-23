import React, { Component } from "react";
import { Link } from "react-router-dom";

class NavigationComponent extends Component {
  render() {
    return (
      <div>
        <nav className="nav justify-content-end">
          <Link to={"/"} className="nav-link">
            home
          </Link>
          <Link to={"/holidays"} className="nav-link">
            holidays
          </Link>
          <Link to={"/admin"} className="nav-link">
            holiday administration
          </Link>
        </nav>
      </div>
    );
  }
}

export default NavigationComponent;
