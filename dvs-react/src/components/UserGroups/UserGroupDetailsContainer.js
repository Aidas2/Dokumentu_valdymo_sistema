import React, { Component } from "react";
import UserGroupDetailsComponent from "./UserGroupDetailsComponent";
import axios from "axios";

class UserGroupDetailsContainer extends Component {
  state = { userDetails: "" };

  componentDidMount() {
    const usernameParam = this.props.match.params.username;

    axios({
      url: "http://localhost:8081/api/users/" + usernameParam,
      method: "GET"
      //   params: {
      //     username: "username1"
      //   }
    })
      .then(response => {
        let userDetails = response.data;
        userDetails.administrator
          ? (userDetails.administrator = "Taip")
          : (userDetails.administrator = "Ne");

        this.setState({ userDetails: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    var userGroupsTitlesToDisplay = null;
    if (this.state.userDetails.userGroups) {
      userGroupsTitlesToDisplay = this.state.userDetails.userGroups.map(
        group => <li key={group}>{group}</li>
      );
    }
    return (
      <UserGroupDetailsComponent
        userGroupDetails={this.state.userGroupDetails}
        userGroups={userGroupsTitlesToDisplay}
      />
    );
  }
}

export default UserGroupDetailsContainer;
