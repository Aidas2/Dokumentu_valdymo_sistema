import React, { Component } from "react";
import { Link } from "react-router-dom";

import styles from "./styles.css";

import main_icon from "../images/main_icon.png";

const LandingPage = props => {
  return (
    <div className="container-fluid main-container  ">
      <div class="row ">
        <div class=" col-md-offset-1 col-md-6 content col-lg-6 ">
          <div>
            <img src={main_icon} class=" center-block picture-padding" />
          </div>
        </div>
        <div
          class="col-md-offset-1 col-md-6 content col-lg-6
           login-style"
        >
          <h6 className="display-6 ">Prisijungimas</h6>
          <input
            className="form-control "
            type="text"
            onChange={props.onReadUsername}
            placeholder="prisijungimo vardas"
          />
          <input
            className="form-control"
            type="password"
            placeholder="slaptažodis"
          />
          <button
            onClick={props.onSaveUsername}
            className="btn btn-outline-success m-2 "
          >
            Prisijungti
          </button>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
