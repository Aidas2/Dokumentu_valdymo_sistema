import React, { Component } from "react";
import { Link } from "react-router-dom";

class LandingPage extends Component {
  render() {
    return (
      <div className="container-fluid ">
        <h1 className="display-6">
          Sveiki prisijungę prie dokumentų Valdymo sistemos
        </h1>

        <input
          className="form-control"
          type="text"
          placeholder="prisijungimo vardas"
        />

        <input
          className="form-control"
          type="password"
          placeholder="slaptažodis"
        />

        <Link to="/" className="btn btn-warning m-2">
          Prisijungti
        </Link>
      </div>
    );
  }
}

export default LandingPage;
