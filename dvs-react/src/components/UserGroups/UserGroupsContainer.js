import React, { Component } from "react";
import axios from "axios";
import UserGroupsComponent from "./UserGroupsComponent";

class UserGroupsContainer extends Component {
  constructor() {
    super();
    this.state = {
      userGroupsList: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8081/Bronza-spring/api/userGroups")
      .then(response =>
        this.setState({
          userGroupsList: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.userGroupsList === null) {
      return <p />;
    } else {
      return <UserGroupsComponent userGroupsList={this.state.userGroupsList} />;
    }
  }
}

export default UserGroupsContainer;
