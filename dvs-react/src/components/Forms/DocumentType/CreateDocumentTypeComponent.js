import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

import logo from "../../../images/home.png";
const CreateDocumentTypeComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Naujo dokumento tipo kūrimas
        </h2>

        <h5 className="display-6 normal-padding gray-collor ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="second-navigation">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/doctypes"} className="second-navigation">
            Dokumentų tipai
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/newdoctype"} className="second-navigation">
            Naujo dokumento tipo kūrimas
          </Link>
        </h5>
        <h3 className="display-6 ">Naujo dokumento tipo kūrimas</h3>
        <h5>Dokumento tipo pavadinimas</h5>
        <input
          onChange={props.onTitleChange}
          className="form-control col-4"
          type="text"
          placeholder="Įveskite dokumento tipo pavadinimą"
        />

        {/* <div className="form-group" /> */}

        <button
          onClick={props.onSubmit}
          className="btn btn-outline-success m-2"
        >
          Kurti
        </button>
      </div>
      <div className="container">{props.launchAlert}</div>
    </div>
  );
};

export default CreateDocumentTypeComponent;
