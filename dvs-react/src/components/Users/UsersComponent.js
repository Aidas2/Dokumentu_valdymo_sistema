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
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-2">
          {userId}
          {/* <Link to="">Linkas</Link> */}
        </div>

        <div className="col-2">
          <Link to={linkToIndividualUserDetails}>{username}</Link>
        </div>
        <div className="col-2">
          <p>{firstName}</p>
        </div>
        <div className="col-2">
          <p>{lastName}</p>
        </div>
        <div className="col-2">
          <p>{emailAddress}</p>
        </div>
        <div className="col-2">
          <p>{hireDate}</p>
        </div>
      </div>
    </div>
  );
};

export default UsersComponent;
