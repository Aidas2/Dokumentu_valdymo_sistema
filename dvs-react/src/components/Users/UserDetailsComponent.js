import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";

const UserDetailsComponent = props => {
  var {
    administrator,
    emailAddress,
    firstName,
    hireDate,
    lastName,
    username
    // userGroups
  } = props.userDetails;

  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">Vartotojai</h2>
        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="second-navigation">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/users"} className="second-navigation">
            Vartotojai
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/newuser"} className="second-navigation">
            Naujo vartotojo kūrimas
          </Link>
        </h5>
        <h3 className="display-6 ">
          Vartotojo&nbsp;
          <strong>
            {firstName} {lastName}
          </strong>{" "}
          informacija
        </h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Vardas</h5>
            <h4>{firstName}</h4>
          </div>
          <div className="col">
            <h5>Pavardė</h5>
            <h4>{lastName}</h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Unikalus vardas sistemoje</h5>
            <h4>{username}</h4>
          </div>
          <div className="col">
            <h5>Elektroninoi pašto adresas</h5>
            <h4>{emailAddress}</h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Įdarbinimo data</h5>
            <h4>{hireDate}</h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Administratoriaus rolė</h5>
            <h4>{administrator}</h4>
          </div>
          <div className="col">
            <h5>Vartotojo grupė</h5>
            <h4>{props.userGroups}</h4>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserDetailsComponent;
