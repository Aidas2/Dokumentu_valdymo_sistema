import React, { Component } from "react";
import UserDetailsComponent from "./UserDetailsComponent";
import axios from "axios";

class UserDetailsContainer extends Component {
  state = { userDetails: "" };

  componentDidMount() {
    const usernameParam = this.props.match.params.username;

    axios({
      url: "/api/users/" + usernameParam,
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
      <UserDetailsComponent
        userDetails={this.state.userDetails}
        userGroups={userGroupsTitlesToDisplay}
      />
    );
  }
}

export default UserDetailsContainer;
