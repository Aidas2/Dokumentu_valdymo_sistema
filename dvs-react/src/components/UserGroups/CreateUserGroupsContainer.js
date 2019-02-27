import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import CreateUserGroupsComponent from "./CreateUserGroupsComponent";

class CreateUserGroupsContainer extends Component {
  state = {
    title: "",
    submitDocumentType: [],
    reviewDocumentTYpe: [],
    msg: false,
    documentTypes: []
  };
  componentDidMount() {
    axios
      .get("http://localhost:8081/api/doctypes")
      .then(response => {
        this.setState({ documentTypes: response.data });
      })
      .catch(error => {
        console.log(error);
      });
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.documetTypes>>>>.",
      this.state.documentTypes
    );
  }

  handleSubmit = () => {
    axios
      .post("http://localhost:8081/api/doctypes", {
        title: this.state.title
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

  handleTitleChange = e => {
    // this.handleCloseAlert();
    let documentTypeTitle = e.target.value;
    this.setState({ title: documentTypeTitle });
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
          Sveikiname! Vartotojų grupė <strong>{this.state.title} </strong>
          sukurta sėkmingai.
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
      "@@@@@@@@@@@@@@@ inside render() this.state>>>>>>>> ",
      this.state
    );

    return (
      <CreateUserGroupsComponent
        documentTypes={this.state.documentTypes}
        onTitleChange={this.handleTitleChange}
        onSubmit={this.handleSubmit}
        launchAlert={this.launchAlert()}
      />
    );
  }
}

export default CreateUserGroupsContainer;
