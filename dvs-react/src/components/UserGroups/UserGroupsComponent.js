import React from "react";

import { Link } from "react-router-dom";

const UserGroupsComponent = props => {
  var linkToUserGroupDetails = "/admin/usergroups/" + props.groupTitle;
  return (
    <div className="row users-padding-bottom">
      <div className="col-1 documents-table-size">{props.groupId}</div>
      <div className="col-11 documents-table-size">
        <Link to={linkToUserGroupDetails}>{props.groupTitle}</Link>
      </div>
    </div>
  );
};

export default UserGroupsComponent;
