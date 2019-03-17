import React from "react";

import { Link } from "react-router-dom";

const UsersComponent = props => {
  var {
    // administrator,
    emailAddress,
    firstName,
    hireDate,
    lastName,
    // password,
    username,
    userId
  } = props.userDetails;

  var linkToIndividualUserDetails = "/admin/users/" + username;

  return (
    <div className="row users-padding-bottom">
      <div className="col-1  documents-table-size  ">{props.index}</div>

      <div className="col-2  documents-table-size">
        <Link to={linkToIndividualUserDetails}>{username}</Link>
      </div>
      <div className="col-2   documents-table-size">{firstName}</div>
      <div className="col-2   documents-table-size">{lastName}</div>
      <div className="col-2   documents-table-size">{emailAddress}</div>
      <div className="col-3   documents-table-size">{hireDate}</div>
    </div>
  );
};

export default UsersComponent;
