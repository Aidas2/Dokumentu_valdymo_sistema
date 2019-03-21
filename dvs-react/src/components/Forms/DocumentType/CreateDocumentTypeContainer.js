import React, { Component } from "react";

import axios from "axios";
import CreateDocumentTypeComponent from "./CreateDocumentTypeComponent";

class CreateDocumentTypeConatainer extends Component {
  state = {
    title: "",
    msg: false
  };

  handleSubmit = () => {
    axios
      .post("/api/doctypes", {
        title: this.state.title
      })
      .then(response => {
        const uploadStatus = "Type was created successfully";
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

  handleTitleChange = e => {
    this.handleCloseAlert();
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
    return (
      <CreateDocumentTypeComponent
        onTitleChange={this.handleTitleChange}
        onSubmit={this.handleSubmit}
        launchAlert={this.launchAlert()}
      />
    );
  }
}

export default CreateDocumentTypeConatainer;
