import React, { Component } from "react";
import { Link } from "react-router-dom";

import main_icon from "../images/main_icon.png";

const LandingPage = props => {
  return (
    <div className="container-fluid main-container  ">
      <div class="row justify-content-between">
        <div class=" col-lg-6 col-xl-6 col-md-6 ">
          <div>
            <img src={main_icon} class=" center-block picture-padding" />
          </div>
        </div>
        <div
          class=" col-lg-4 col-xl-4 col-md-5
           login-style"
        >
          <h1 className="display-6 ">Įveskite prisijungimo informaciją</h1>
          <input
            className="form-control login-form-style "
            type="text"
            onChange={props.onReadUsername}
            placeholder="Įveskite prisijungimo vardą "
          />
          <input
            className="form-control login-form-style"
            type="password"
            placeholder="Jūsų slaptažodis"
          />

          <button
            onClick={props.onSaveUsername}
            className="btn btn-outline-success login-button"
          >
            Prisijungti
          </button>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
