import React, { Component } from "react";
import { Link } from "react-router-dom";

const LandingPage = props => {
  return (
    <div className="container-fluid ml-2 ">
      <h1 className="display-6 ">
        Sveiki prisijungę prie dokumentų Valdymo sistemos
      </h1>

      <input
        className="form-control col-3 m-2"
        type="text"
        onChange={props.onReadUsername}
        placeholder="prisijungimo vardas"
      />

      <input
        className="form-control col-3 m-2"
        type="password"
        placeholder="slaptažodis"
      />

      <button onClick={props.onSaveUsername} className="btn btn-warning m-2">
        Prisijungti
      </button>
    </div>
  );
};

export default LandingPage;
