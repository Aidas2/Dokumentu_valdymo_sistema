import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";

const DocumentDetailsComponent = props => {
  var {
    id,
    author,
    documentState,
    documentTypeTitle,
    title,
    description,
    creationDate,
    submissionDate,
    confirmationDate,
    rejectionDate,
    reviewer,
    rejectionReason,
    path
  } = props.documentDetails;
  return (
    <div>
      <div className="container-fluid m-2">
        <h6 className="display-6 normal-padding" />
        <h5 className="display-6 normal-padding gray-collor ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="explorer">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/docs"} className="explorer">
            Dokumentai
          </Link>
          &ensp;/ &ensp;
          {/* <Link to={"/admin/newuser"} className="explorer">
            Naujo vartotojo kūrimas
          </Link> */}
        </h5>
        <h3 className="display-6 ">
          Dokumento &nbsp;"
          <strong>{title}"&nbsp;</strong>
          inforamcija
        </h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Pavadinimas</h5>
            <h4>{}</h4>
          </div>
          <div className="col">
            <h5>Autorius</h5>
            <h4>{} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Tipas</h5>
            <h4>{}</h4>
          </div>
          <div className="col">
            <h5>Aprašymas</h5>
            <h4>{} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Būsena</h5>
            <h4>{}</h4>
          </div>
          <div className="col">
            <h5>Priedai</h5>
            <h4>{} </h4>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DocumentDetailsComponent;
