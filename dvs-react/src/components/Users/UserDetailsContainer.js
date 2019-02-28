import React, { Component } from "react";
import UserDetailsComponent from "./UserDetailsComponent";
import axios from "axios";

class UserDetailsContainer extends Component {
  state = { userDetails: { userGroups: [] } };

  componentDidMount() {
    axios({
      url: "http://localhost:8081/api/users" + "/username3",
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
    var userGroupsTitlesToDisplay = this.state.userDetails.userGroups.map(
      group => <li key={group}>{group}</li>
    );

    return (
      <UserDetailsComponent
        userDetails={this.state.userDetails}
        userGroups={userGroupsTitlesToDisplay}
      />
    );
  }
}

export default UserDetailsContainer;
