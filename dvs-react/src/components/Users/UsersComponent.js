import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const UsersComponent = props => {
  var {
    administrator,
    emailAddress,
    firstName,
    hireDate,
    lastName,
    password,
    username,
    userId
  } = props.userDetails;

  var linkToIndividualUserDetails = "/admin/users/" + username;

  return (
    <div className="row">
      <div className="col-1  table-action-size  ">
        {userId}
        {/* <Link to="">Linkas</Link> */}
      </div>

      <div className="col-2  col-width table-action-size">
        <Link to={linkToIndividualUserDetails}>{username}</Link>
      </div>
      <div className="col-2   table-action-size">{firstName}</div>
      <div className="col-2   table-action-size">{lastName}</div>
      <div className="col-2   table-action-size">{emailAddress}</div>
      <div className="col-3   table-action-size">{hireDate}</div>
    </div>
  );
};

export default UsersComponent;
