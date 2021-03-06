import React, { Component } from "react";

import axios from "axios";
import CreateUserComponent from "./CreateUserComponent";

class CreateUserContainer extends Component {
  state = {
    userGroups: [],
    administrator: false,
    emailAddress: "",
    firstName: "",
    hireDate: "",
    lastName: "",
    password: "",
    username: "",
    id: "",
    msg: false,
    allUserGroups: []
  };

  componentDidMount() {
    axios
      .get("/api/groups")
      .then(response => {
        this.setState({ allUserGroups: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleSubmit = () => {
    axios
      .post("/api/users", {
        administrator: this.state.administrator,
        emailAddress: this.state.emailAddress,
        firstName: this.state.firstName,
        hireDate: this.state.hireDate,
        lastName: this.state.lastName,
        password: this.state.password,
        username: this.state.username,
        userGroupTitle: this.state.userGroups
      })
      .then(response => {
        const uploadStatus = "User was created successfully";
        console.log("upload status >>>>>>>>>> ", uploadStatus);
        this.setState({ msg: true });
      })
      .catch(function(error) {
        console.log(error);
        if (error.response) {
          //HTTP error happened
          console.log(
            "Upload error. HTTP error/status code=",
            error.response.status
          );
        } else {
          //some other error happened
          console.log("Upload error. HTTP error/status code=", error.message);
        }
      });
  };

  handleAdministratorChange = e => {
    this.handleCloseAlert();

    this.setState({ administrator: e.target.value });
  };
  handleEmailAddressChange = e => {
    this.handleCloseAlert();

    this.setState({ emailAddress: e.target.value });
  };
  handleFirstNameChange = e => {
    this.handleCloseAlert();

    this.setState({ firstName: e.target.value });
  };
  handleHireDateChange = e => {
    this.handleCloseAlert();

    this.setState({ hireDate: e.target.value });
  };
  handleLastNameChange = e => {
    this.handleCloseAlert();

    this.setState({ lastName: e.target.value });
  };
  handlePasswordChange = e => {
    this.handleCloseAlert();

    this.setState({ password: e.target.value });
  };
  handleUsernameChange = e => {
    this.handleCloseAlert();

    this.setState({ username: e.target.value });
  };
  handleUserGroupChange = e => {
    this.handleCloseAlert();

    let userGroups = this.state.userGroups;
    userGroups.includes(e.target.value)
      ? console.log("This userGroup has already been selected")
      : userGroups.push(e.target.value);
    this.setState({ userGroups: userGroups });
  };

  launchAlert = () => {
    if (this.state.msg) {
      return (
        <div className="alert alert-success alert-dismissible">
          <button
            onClick={this.handleCloseAlert}
            href="#"
            className="close"
            data-dismiss="alert"
            aria-label="close"
          >
            &times;
          </button>
          Sveikiname! Vartotojas <strong>{this.state.username} </strong>
          sukurtas sėkmingai.
        </div>
      );
    }
    return null;
  };
  handleCloseAlert = () => {
    this.setState({ msg: false });
  };
  handleUserGroupRemoval = group => {
    let userGroups = this.state.userGroups;
    var filteredUserGroups = userGroups.filter(oneGroup => oneGroup !== group);
    this.setState({ userGroups: filteredUserGroups });
  };

  render() {
    var userGroupsTitlesToDisplay = this.state.userGroups.map(group => {
      return (
        <span key={group}>
          &nbsp;{group}&nbsp;
          <button
            onClick={() => this.handleUserGroupRemoval(group)}
            className="btn btn-danger btn-sm"
          >
            x
          </button>
        </span>
      );
    });

    return (
      <CreateUserComponent
        onSubmit={this.handleSubmit}
        onAdministratorChange={this.handleAdministratorChange}
        onEmailAddressChange={this.handleEmailAddressChange}
        onFirstNameChange={this.handleFirstNameChange}
        onHireDateChange={this.handleHireDateChange}
        onLastNameChange={this.handleLastNameChange}
        onPasswordChange={this.handlePasswordChange}
        onUsernameChange={this.handleUsernameChange}
        onUserGroupChange={this.handleUserGroupChange}
        userGroups={this.state.allUserGroups}
        launchAlert={this.launchAlert()}
        userGroupsTitles={userGroupsTitlesToDisplay}
      />
    );
  }
}

export default CreateUserContainer;
