import React, { Component } from "react";
import { Redirect } from "react-router";
import axios from "axios";
import DocumentDetailsComponent from "./DocumentDetailsComponent";

class DocumentDetailsContainer extends Component {
  state = {
    documentDetails: {
      id: "",
      authorUsername: "",
      documentTypeTitleInLithuanian: "",
      documentStateInLithuanian: "",
      title: "",
      description: "",
      creationDate: "",
      submissionDate: "",
      confirmationDate: "",
      rejectionDate: "",
      reviewerUsername: "",
      rejectionReason: "",
      path: "",
      attachments: []
    },
    setStateInfo: {
      documentState: "",
      rejectionReason: ""
      // reviewerUsername: ""
    },
    sth: false
  };

  componentDidMount() {
    const idParam = this.props.match.params.id;

    axios({
      url: "http://localhost:8081/api/docs/" + idParam,
      method: "GET"
    })
      .then(response => {
        this.setState({
          documentDetails: response.data
        });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleAcceptDocument = stateToSet => {
    console.log("Accept happened");
    let setStateInfo = this.state.setStateInfo;
    setStateInfo.documentState = stateToSet;
    this.setState({ setStateInfo });

    axios({
      url: "http://localhost:8081/api/docs/setstate",
      method: "put",
      headers: {
        authorisation: "your token"
      },
      data: {
        authorUsername: this.state.documentDetails.authorUsername,
        documentId: this.state.documentDetails.id,
        documentState: this.state.setStateInfo.documentState,
        rejectionReason: this.state.setStateInfo.rejectionReason,
        reviewerUsername: localStorage.getItem("username")
      }
    })
      .then(response => {
        this.setState({ sth: true });
        window.location.reload();
      })
      .catch(function(error) {
        console.log(error);
        if (error.response) {
          //HTTP error happened
          console.log(
            "Update error. HTTP error/status code=",
            error.response.status
          );
        } else {
          //some other error happened
          console.log("Update error. HTTP error/status code=", error.message);
        }
      });
  };
  handleRejectionReason = e => {
    let setStateInfo = this.state.setStateInfo;
    setStateInfo.rejectionReason = e.target.value;
    this.setState(setStateInfo);
  };

  getActionButtons = () => {
    if (this.state.documentDetails.documentStateInLithuanian === "SUKURTAS") {
      return (
        <div className="row users-padding-bottom">
          <div className="col-1 documents-table-size" />
          <div className="col-5 documents-table-size">
            <div>
              <button
                onClick={() => this.handleAcceptDocument("SUBMITTED")}
                className="btn btn-warning"
              >
                Pateikti
              </button>
              &ensp;
            </div>
          </div>
          <div className="col-6 documents-table-size" />
        </div>
      );
    } else if (
      this.state.documentDetails.documentStateInLithuanian === "PATEIKTAS" &&
      !this.props.onlySubmit
    ) {
      return (
        <div className="row users-padding-bottom">
          <div className="col-1 documents-table-size" />
          <div className="col-5 documents-table-size">
            <div>
              <button
                onClick={() => this.handleAcceptDocument("CONFIRMED")}
                className="btn btn-success"
              >
                Priimti
              </button>
              &ensp;
              <button
                onClick={() => this.handleAcceptDocument("REJECTED")}
                className="btn btn-danger "
              >
                Atmesti
              </button>
              &ensp;
            </div>{" "}
          </div>
          <div className="col-6 documents-table-size">
            <div>
              Atmetimo priežastis&ensp;
              <br />
              <textarea
                onChange={this.handleRejectionReason}
                type="textarea"
                placeholder="Įveskite atmetimo priežastį"
                className=" form-control form-control-sm italic-style"
              />
            </div>
          </div>
        </div>
      );
    }
  };

  render() {
    return (
      <div>
        <DocumentDetailsComponent
          documentDetails={this.state.documentDetails}
          onRejectionReasonChange={this.handleRejectionReason}
          actionButtons={this.getActionButtons()}
        />
      </div>
    );
  }
}

export default DocumentDetailsContainer;
