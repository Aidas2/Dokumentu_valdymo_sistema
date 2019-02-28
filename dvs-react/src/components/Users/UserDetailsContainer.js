import React, { Component } from "react";
import UserDetailsComponent from "./UserDetailsComponent";
import axios from "axios";

class UserDetailsContainer extends Component {
  state = {};

  componentDidMount() {
    axios({
      url: "http://localhost:8081/api/users",
      method: "GET",
      params: {
        username: "username1"
      }
    })
      .then(response => {
        // this.setState({ users: response.data });
        console.log("response -------------- > ", response);
      })
      .catch(error => {
        console.log(error);
      });
  }
  render() {
    return <UserDetailsComponent />;
  }
}

export default UserDetailsContainer;
