import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import CreateUserComponent from "./CreateUserComponent";

class CreateUserContainer extends Component {
  state = {
    administrator: false,
    emailAddress: "",
    firstName: "",
    hireDate: "",
    lastName: "",
    password: "",
    username: "",
    id: 4,
    msg: false
  };

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
        id: 4
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
    this.setState({ administrator: e.target.value });
  };
  handleEmailAddressChange = e => {
    this.setState({ emailAddress: e.target.value });
  };
  handleFirstNameChange = e => {
    this.setState({ firstName: e.target.value });
  };
  handleHireDateChange = e => {
    this.setState({ hireDate: e.target.value });
  };
  handleLastNameChange = e => {
    this.setState({ lastName: e.target.value });
  };
  handlePasswordChange = e => {
    this.setState({ password: e.target.value });
  };
  handleUsernameChange = e => {
    this.setState({ username: e.target.value });
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
          Sveikiname! Dokumento tipas <strong>{this.state.title} </strong>
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
      />
    );
  }
}

export default CreateUserContainer;
