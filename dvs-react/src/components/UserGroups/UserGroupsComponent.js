import React, { Component } from "react";
import UserGroups from "./UserGroups";

class UserGroupsComponent extends Component {
  render() {
    let userGroupsList = this.props.userGroupsList.map(userGroups => (
      <UserGroups
        id={userGroups.id}
        key={userGroups.id}
        title={userGroups.title}
        description={userGroups.description}
        imageUrl={userGroups.imageUrl}
        type={userGroups.type}
        Management={userGroups.Management}
      />
    ));
    return (
      <div className="container-fluid">
        <h1 className="display-2">YOUR userGroupsS</h1>
        <div className="row">{userGroupsList}</div>;
      </div>
    );
  }
}

export default UserGroupsComponent;
