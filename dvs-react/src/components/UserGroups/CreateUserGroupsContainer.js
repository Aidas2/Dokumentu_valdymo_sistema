import React, { Component } from "react";

import axios from "axios";
import CreateUserGroupsComponent from "./CreateUserGroupsComponent";

class CreateUserGroupsContainer extends Component {
  state = {
    title: "",
    submitDocumentType: [],
    reviewDocumentType: [],
    msg: false,
    documentTypes: []
  };
  componentDidMount() {
    axios
      .get("/api/doctypes")
      .then(response => {
        this.setState({ documentTypes: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleSubmit = () => {
    axios
      .post("/api/groups", {
        title: this.state.title,
        reviewDocumentType: this.state.reviewDocumentType,
        submitDocumentType: this.state.submitDocumentType
      })
      .then(response => {
        const uploadStatus = "Group was created successfully";
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
    this.handleCloseAlert();
    let groupTitle = e.target.value;
    this.setState({ title: groupTitle });
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
  handleSubmitDocumentTypeChange = e => {
    this.handleCloseAlert();

    let submitDocumentType = this.state.submitDocumentType;
    submitDocumentType.includes(e.target.value)
      ? console.log("This type has already been selected")
      : submitDocumentType.push(e.target.value);
    this.setState({ submitDocumentType });
  };
  handleReviewDocumentTypeChange = e => {
    this.handleCloseAlert();

    let reviewDocumentType = this.state.reviewDocumentType;
    reviewDocumentType.includes(e.target.value)
      ? console.log("This type has already been selected")
      : reviewDocumentType.push(e.target.value);
    this.setState({ reviewDocumentType });
  };
  handleSubmitTypeRemoval = type => {
    let submitDocumentType = this.state.submitDocumentType;
    var filteredSubmitDocumentTypes = submitDocumentType.filter(
      oneType => oneType !== type
    );
    this.setState({ submitDocumentType: filteredSubmitDocumentTypes });
  };
  handleReviewTypeRemoval = type => {
    let reviewDocumentType = this.state.reviewDocumentType;
    var filteredReviewDocumentTypes = reviewDocumentType.filter(
      oneType => oneType !== type
    );
    this.setState({ reviewDocumentType: filteredReviewDocumentTypes });
  };

  render() {
    var selectedSubmissionTypesTitlesToDisplay = this.state.submitDocumentType.map(
      type => {
        return (
          <span key={type}>
            &nbsp;{type}&nbsp;
            <button
              onClick={() => this.handleSubmitTypeRemoval(type)}
              className="btn btn-danger btn-sm"
            >
              x
            </button>
          </span>
        );
      }
    );
    var selectedReviewTypesTitlesToDisplay = this.state.reviewDocumentType.map(
      type => {
        return (
          <span key={type}>
            &nbsp;{type}&nbsp;
            <button
              onClick={() => this.handleReviewTypeRemoval(type)}
              className="btn btn-danger btn-sm"
            >
              x
            </button>
          </span>
        );
      }
    );

    return (
      <CreateUserGroupsComponent
        documentTypes={this.state.documentTypes}
        onSubmitTypesChange={this.handleSubmitDocumentTypeChange}
        onReviewTypesChange={this.handleReviewDocumentTypeChange}
        onTitleChange={this.handleTitleChange}
        onSubmit={this.handleSubmit}
        launchAlert={this.launchAlert()}
        selectedSubmissionTypesTitles={selectedSubmissionTypesTitlesToDisplay}
        selectedReviewTypesTitles={selectedReviewTypesTitlesToDisplay}
      />
    );
  }
}

export default CreateUserGroupsContainer;
