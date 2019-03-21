import React, { Component } from "react";
import axios from "axios";
import LoginComponent from "./LoginComponent";
import { Redirect } from "react-router";
axios.defaults.withCredentials = true; // leidzia dalintis cookies

class LoginContainer extends Component {
  state = {
    username: "",
    pass: "",
    isLogged: false
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
        localStorage.setItem("username", resp.data.username);
        this.setState({ isLogged: true });
      })
      .catch(e => {
        console.log(e);
      });
    event.preventDefault();
  };

  redirectToDocs = () => {
    if (this.state.isLogged) {
      return <Redirect to="/docs" />;
    } else {
      return null;
    }
  };

  render() {
    // console.log("this.state in render() ------------ ", this.state);
    return (
      <div>
        <LoginComponent
          username={this.state.username}
          pass={this.state.pass}
          onUsernameChange={this.onUsernameChange}
          onPassChange={this.onPassChange}
          onSubmit={this.onSubmit}
        />
        {this.redirectToDocs()}
      </div>
    );
  }
  // onCalc = event => {
  //   axios
  //     .get("http://localhost:8081/calc?left=1&right=2")
  //     .then(response => {
  //       console.log(response);
  //     })
  //     .catch(e => {
  //       console.log(e);
  //     });
  //   event.preventDefault();
  // };
}

export default LoginContainer;
