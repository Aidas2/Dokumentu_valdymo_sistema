import React, { Component } from "react";
import LandingPage from "./LandingPage";

class LandingPageContainer extends Component {
  state = {
    username: ""
  };

  readUsername = e => {
    this.setState({ username: e.target.value });
  };
  saveUsername = e => {
    localStorage.setItem("username", this.state.username);
  };

  render() {
    return (
      <LandingPage
        onReadUsername={this.readUsername}
        onSaveUsername={this.saveUsername}
      />
    );
  }
}

export default LandingPageContainer;
