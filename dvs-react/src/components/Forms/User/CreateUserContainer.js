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
    id: 4,
    msg: false,
    allUserGroups: []
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/groups")
      .then(response => {
        this.setState({ allUserGroups: response.data });
        // let userGroup = this.state.userGroup;
        // userGroup.push(response.data[0].title);
        // this.setState({ userGroup: userGroup });
      })
      .catch(error => {
        console.log(error);
      });
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.userGroups>>>>.",
      this.state.allUserGroups
    );
  }

  handleSubmit = () => {
    // axios
    //   .post("http://localhost:8081/api/doctypes", {
    //     title: this.state.title
    //   })
    //   .then(response => {
    //     console.log(response);
    //     console.log("PO sekmingo submito state.sth");
    //     // this.setState({ msg: true });
    //   })
    //   .catch(function(error) {
    //     console.log(error);
    //   });
    console.log("========================Submit happened");
    axios
      .post("http://localhost:8081/api/users", {
        administrator: this.state.administrator,
        emailAddress: this.state.emailAddress,
        firstName: this.state.firstName,
        hireDate: this.state.hireDate,
        lastName: this.state.lastName,
        password: this.state.password,
        username: this.state.username,
        userGroupTitle: this.state.userGroups
        // id: 4
      })
      .then(response => {
        const uploadStatus = "Type was created successfully";
        console.log("upload status >>>>>>>>>> ", uploadStatus);
        this.setState({ msg: true });
      })
      .catch(function(error) {
        //it works without catch block as well
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
    console.log(">>>>>>>>>Submit happened");
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
    userGroups.push(e.target.value);
    this.setState({ userGroup: userGroups });
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

  render() {
    var userGroupsTitlesToDisplay = this.state.userGroups.map(
      group => group + " *** "
    );

    console.log(
      this.state,
      "-------------@@@@@@@@@@@@@@@ inside render() this.state>>>>>>>> "
    );

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
