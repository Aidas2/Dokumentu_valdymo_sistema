import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const UserGroupsComponent = props => {
  var linkToUserGroupDetails = "/admin/usergroups/" + props.groupTitle;
  return (
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-6">
          {props.groupId}
          {/* <Link to="">Linkas</Link> */}
        </div>

        <div className="col-6">
          <Link to={linkToUserGroupDetails}>{props.groupTitle}</Link>
        </div>
      </div>
    </div>
  );
};

export default UserGroupsComponent;
