import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";

const UserDetailsComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h6 className="display-6 normal-padding">vartotojai</h6>
        <h5 className="display-6 normal-padding gray-collor ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="explorer">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/users"} className="explorer">
            Vartotojai
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/newuser"} className="explorer">
            Naujo vartotojo kūrimas
          </Link>
        </h5>
        <h3 className="display-6 ">Naujo vartotojo kūrimas</h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Vardas</h5>
          </div>
          <div className="col">
            <h5>Pavardė</h5>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Unikalus vardas sistemoje</h5>
          </div>
          <div className="col">
            <h5>Elektroninoi pašto adresas</h5>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Įdarbinimo data</h5>
          </div>
          <div className="col">
            <h5>Prisijungimo slaptažodis</h5>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Administratoriaus rolė</h5>
          </div>
          <div className="col">
            <h5>Vartotojo grupė</h5>

            <span className="italic-style-small">
              Pasirinktos grupės: {props.userGroupsTitles}
            </span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserDetailsComponent;
