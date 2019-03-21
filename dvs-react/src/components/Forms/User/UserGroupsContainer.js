import React, { Component } from "react";

import UserGroupsComponent from "./UserGroupsComponent";

class UserGroupsContainer extends Component {
  render() {
    const UserGroupsArrayToRender = this.props.userGroups.map(oneGroup => {
      return (
        <UserGroupsComponent key={oneGroup.title} groupObject={oneGroup} />
      );
    });
    return (
      <select
        onChange={this.props.onUserGroupChange}
        className="form-control col-6 pop-up-style"
        id="userGroupSelect"
        multiple
      >
        {UserGroupsArrayToRender}
      </select>
    );
  }
}

export default UserGroupsContainer;
