import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";

const UserGroupDetailsComponent = props => {
  var { title, submissionDocTypes, reviewDocTypes } = props;

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
          <Link to={"/admin/usergroups"} className="explorer">
            Vartotojų grupės
          </Link>
          &ensp;/ &ensp;
          {/* <Link to={"/admin/newuser"} className="explorer">
            Naujo vartotojo kūrimas
          </Link> */}
        </h5>
        <h3 className="display-6 ">
          Vartotojų grupės &nbsp;"
          <strong>{title}"&nbsp;</strong>
          inforamcija
        </h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Pateikti leidžiamų dokumentų tipai</h5>
            <h4>{submissionDocTypes}</h4>
          </div>
          <div className="col">
            <h5>Peržiūrėti leidžiamų dokumentų tipai</h5>
            <h4>{reviewDocTypes} </h4>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserGroupDetailsComponent;
