import React, { Component } from "react";
import axios from "axios";
import LoginComponent from "./LoginComponent";
axios.defaults.withCredentials = true; // leidzia dalintis cookies

class LoginContainer extends Component {
  onEmailChange = event => {
    this.setState({ email: event.target.value });
  };
  onPassChange = event => {
    this.setState({ pass: event.target.value });
  };
  onSubmit = event => {
    let userData = new URLSearchParams();
    userData.append("username", this.state.email);
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
    return <LoginComponent />;
  }
}

export default LoginContainer;
