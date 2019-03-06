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
    <div className="row">
      <div className="col-1  username-table-action-size  ">{userId}</div>

      <div className="col-2  col-width username-table-action-size">
        <Link to={linkToIndividualUserDetails}>{username}</Link>
      </div>
      <div className="col-2   username-table-action-size">{firstName}</div>
      <div className="col-2   username-table-action-size">{lastName}</div>
      <div className="col-2   username-table-action-size">{emailAddress}</div>
      <div className="col-3   username-table-action-size">{hireDate}</div>
    </div>
  );
};

export default UsersComponent;
