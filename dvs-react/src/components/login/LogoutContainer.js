import React, { Component } from "react";
import LogoutComponent from "./LogoutComponent";
import axios from "axios";

class LogoutContainer extends Component {
  state = {};

  handleLogout = event => {
    axios
      .post("http://localhost:8081/login?logout", {
        // headers: { "Content-type": "application/x-www-form-urlencoded" }
      })
      .then(resp => {
        console.log("user logged out");
      })
      .catch(e => {
        console.log(e);
      });
    event.preventDefault();
  };

  render() {
    return <LogoutComponent onClick={this.handleLogout} />;
  }
}

export default LogoutContainer;
