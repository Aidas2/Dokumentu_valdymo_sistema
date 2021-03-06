import React, { Component } from "react";

import axios from "axios";
// import CreateUserComponent from "./CreateUserComponent";
import UpdateUserComponent from "./UpdateUserComponent";

class UpdateUserContainer extends Component {
  state = {
    updatedUserInfo: {
      userGroupTitle: [],
      administrator: "",
      emailAddress: "",
      firstName: "",
      hireDate: "",
      lastName: "",
      password: ""
    },
    temporalUserInfo: {
      administrator: "",
      emailAddress: "",
      firstName: "",
      hireDate: "",
      lastName: "",
      password: ""
    },
    msg: false,
    allUserGroups: [],
    userDetailsBeforeUpdate: "",
    mostRecentAdmintValue: ""
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
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.userGroups>>>>.",
      this.state.allUserGroups
    );
    const usernameParam = this.props.match.params.username;

    axios({
      url: "/api/users/" + usernameParam,
      method: "GET"
      //   params: {
      //     username: "username1"
      //   }
    })
      .then(response => {
        let userDetailsBeforeUpdate = response.data;
        userDetailsBeforeUpdate.administrator
          ? (userDetailsBeforeUpdate.administrator = "Taip")
          : (userDetailsBeforeUpdate.administrator = "Ne");

        this.setState({ userDetailsBeforeUpdate: response.data });
        this.setState({ mostRecentAdmintValue: response.data.administrator });

        const updatedUserInfo = this.state.updatedUserInfo;
        updatedUserInfo.userGroupTitle = response.data.userGroups;
        response.data.administrator
          ? (updatedUserInfo.administrator = true)
          : (updatedUserInfo.administrator = false);
        updatedUserInfo.emailAddress = response.data.emailAddress;
        updatedUserInfo.firstName = response.data.firstName;
        updatedUserInfo.hireDate = response.data.hireDate;
        updatedUserInfo.lastName = response.data.lastName;
        updatedUserInfo.password = response.data.password;
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleSubmit = () => {
    const updatedUserInfo = this.state.updatedUserInfo;
    console.log(
      "******************* username, updatedUserInfo >> ",
      this.state.userDetailsBeforeUpdate.username,
      updatedUserInfo
    );
    const temporalUserInfo = this.state.temporalUserInfo;

    temporalUserInfo.emailAddress
      ? (updatedUserInfo.emailAddress = temporalUserInfo.emailAddress)
      : console.log("Email address was not changed");
    temporalUserInfo.firstName
      ? (updatedUserInfo.firstName = temporalUserInfo.firstName)
      : console.log("First name was not changed");
    temporalUserInfo.lastName
      ? (updatedUserInfo.lastName = temporalUserInfo.lastName)
      : console.log("LastName  was not changed");
    temporalUserInfo.hireDate
      ? (updatedUserInfo.hireDate = temporalUserInfo.hireDate)
      : console.log("Hire date was not changed");
    temporalUserInfo.password
      ? (updatedUserInfo.password = temporalUserInfo.password)
      : console.log("Password was not changed");
    temporalUserInfo.administrator
      ? (updatedUserInfo.administrator = temporalUserInfo.administrator)
      : console.log("Administrator was not changed");

    axios({
      url: "/api/users/" + this.state.userDetailsBeforeUpdate.username,
      method: "put",
      headers: {
        authorisation: "your token"
      },
      data: updatedUserInfo
    })
      .then(response => {
        const uploadStatus = "User was updated successfully";
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
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.administrator = e.target.value;
    if (e.target.value === "true") {
      this.setState({ mostRecentAdmintValue: "Taip" });
    } else if (e.target.value === "false") {
      this.setState({ mostRecentAdmintValue: "Ne" });
    }
    this.setState({ temporalUserInfo });
  };
  handleEmailAddressChange = e => {
    this.handleCloseAlert();
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.emailAddress = e.target.value;
    this.setState({ temporalUserInfo });
  };
  handleFirstNameChange = e => {
    this.handleCloseAlert();
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.firstName = e.target.value;
    this.setState({ temporalUserInfo });
  };
  handleHireDateChange = e => {
    this.handleCloseAlert();
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.hireDate = e.target.value;
    this.setState({ temporalUserInfo });
  };
  handleLastNameChange = e => {
    this.handleCloseAlert();
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.lastName = e.target.value;
    this.setState({ temporalUserInfo });
  };
  handlePasswordChange = e => {
    this.handleCloseAlert();
    const temporalUserInfo = this.state.temporalUserInfo;
    temporalUserInfo.password = e.target.value;
    this.setState({ temporalUserInfo });
  };

  handleUserGroupChange = e => {
    this.handleCloseAlert();

    let userGroups = this.state.updatedUserInfo.userGroupTitle;
    userGroups.includes(e.target.value)
      ? console.log("This userGroup has already been selected")
      : userGroups.push(e.target.value);
    const updatedUserInfo = this.state.updatedUserInfo;
    updatedUserInfo.userGroupTitle = userGroups;
    this.setState({ updatedUserInfo });
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
          Sveikiname! Vartotojo{" "}
          <strong>{this.state.userDetailsBeforeUpdate.username} </strong>
          informacija atnaujinta sėkmingai.
        </div>
      );
    }
    return null;
  };
  handleCloseAlert = () => {
    this.setState({ msg: false });
  };
  handleUserGroupRemoval = group => {
    let userGroups = this.state.updatedUserInfo.userGroupTitle;
    var filteredUserGroups = userGroups.filter(oneGroup => oneGroup !== group);
    const updatedUserInfo = this.state.updatedUserInfo;
    updatedUserInfo.userGroupTitle = filteredUserGroups;
    this.setState({ updatedUserInfo });
  };

  render() {
    var userGroupsTitlesToDisplay = null;

    if (this.state.updatedUserInfo.userGroupTitle) {
      userGroupsTitlesToDisplay = this.state.updatedUserInfo.userGroupTitle.map(
        group => {
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
        }
      );
    }

    return (
      <UpdateUserComponent
        onSubmit={this.handleSubmit}
        onAdministratorChange={this.handleAdministratorChange}
        onEmailAddressChange={this.handleEmailAddressChange}
        onFirstNameChange={this.handleFirstNameChange}
        onHireDateChange={this.handleHireDateChange}
        onLastNameChange={this.handleLastNameChange}
        onPasswordChange={this.handlePasswordChange}
        // onUsernameChange={this.handleUsernameChange}
        onUserGroupChange={this.handleUserGroupChange}
        userGroups={this.state.allUserGroups}
        launchAlert={this.launchAlert()}
        selectedUserGroupsTitles={userGroupsTitlesToDisplay}
        userDetailsBeforeUpdate={this.state.userDetailsBeforeUpdate}
        mostRecentAdmintValue={this.state.mostRecentAdmintValue}
      />
    );
  }
}

export default UpdateUserContainer;
