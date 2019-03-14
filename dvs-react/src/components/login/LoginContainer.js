import React, { Component } from "react";
import axios from "axios";
import LoginComponent from "./LoginComponent";
axios.defaults.withCredentials = true; // leidzia dalintis cookies

class LoginContainer extends Component {
  state = {
    username: "",
    pass: ""
  };

  onUsernameChange = event => {
    this.setState({ username: event.target.value });
  };
  onPassChange = event => {
    this.setState({ pass: event.target.value });
  };
  onSubmit = event => {
    let userData = new URLSearchParams();
    userData.append("username", this.state.username);
    userData.append("password", this.state.pass);
    axios
      .post("http://localhost:8081/login", userData, {
        headers: { "Content-type": "application/x-www-form-urlencoded" }
      })
      .then(resp => {
        console.log("user " + resp.data.username + " logged in");
      })
      .catch(e => {
        console.log(e);
      });
    event.preventDefault();
  };

  render() {
    console.log("this.state in render() ------------ ", this.state);
    return (
      <LoginComponent
        username={this.state.username}
        pass={this.state.pass}
        onUsernameChange={this.onUsernameChange}
        onPassChange={this.onPassChange}
        onSubmit={this.onSubmit}
      />
    );
  }
  onCalc = event => {
    axios
      .get("http://localhost:8081/calc?left=1&right=2")
      .then(response => {
        console.log(response);
      })
      .catch(e => {
        console.log(e);
      });
    event.preventDefault();
  };
}

export default LoginContainer;
