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
    // this.state.documentDetails.state==="PATEIKTAS"
    let setStateInfo = this.state.setStateInfo;
    setStateInfo.documentState = stateToSet;
    this.setState({ setStateInfo });
    // return <Redirect to="/docs" />;
    // this.state.setStateInfo.documentState === "PATEIKTAS"
    //   ? this.setState({ setStateInfo })
    //   : console.log("Document has already been managed");

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

      // { request body ===>
      // /api/docs/setstate2
      //   "authorUsername": "username1",
      //   "documentId": 161,
      //   "documentState": "SUBMITTED",
      //   "rejectionReason": "string",
      //   "reviewerUsername": "username1"
      // }
    })
      .then(response => {
        this.setState({ sth: true });
        window.location.reload();
        // console.log(
        //   "data to put @@@@@@@@@@@@@ ",
        //   "authorUsername: ",
        //   this.state.documentDetails.authorUsername,
        //   "documentId: ",
        //   this.state.documentDetails.id,
        //   "documentState: ",
        //   this.state.setStateInfo.documentState,
        //   "rejectionReason: ",
        //   this.state.setStateInfo.rejectionReason,
        //   "reviewerUsername: ",
        //   localStorage.getItem("username")
        // );
      })
      .catch(function(error) {
        //it works without catch block as well
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
    console.log(
      "data to put @@@@@@@@@@@@@ ",
      "authorUsername: ",
      this.state.documentDetails.authorUsername,
      "documentId: ",
      this.state.documentDetails.id,
      "documentState: ",
      this.state.setStateInfo.documentState,
      "rejectionReason: ",
      this.state.setStateInfo.rejectionReason,
      "reviewerUsername: ",
      localStorage.getItem("username")
    );
    console.log(
      "this.state.documentDetails.authorUsername-------in handleAcceptDocument--------> ",
      this.state.documentDetails.authorUsername
    );
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

        // <div>
        //   <button
        //     onClick={() => this.handleAcceptDocument("SUBMITTED")}
        //     className="btn btn-warning "
        //   >
        //     Pateikti
        //   </button>
        //   &ensp;
        // </div>
      );
    } else if (
      this.state.documentDetails.documentStateInLithuanian === "PATEIKTAS"
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
        // <div>
        //   <button
        //     onClick={() => this.handleAcceptDocument("CONFIRMED")}
        //     className="btn btn-success"
        //   >
        //     Priimti
        //   </button>
        //   &ensp;
        //   <button
        //     onClick={() => this.handleAcceptDocument("REJECTED")}
        //     className="btn btn-danger "
        //   >
        //     Atmesti
        //   </button>
        //   &ensp;
        // </div>
      );
    }
  };

  render() {
    // var submissionTypesToDisplay = null;
    // if (this.state.submissionDocType) {
    //   submissionTypesToDisplay = this.state.submissionDocType.map(title => (
    //     <li key={title}>{title}</li>
    //   ));
    // }
    // var reviewTypesToDisplay = null;
    // if (this.state.submissionDocType) {
    //   reviewTypesToDisplay = this.state.reviewDocType.map(title => (
    //     <li key={title}>{title}</li>
    //   ));
    // }
    console.log("render() _----------this.state----------- >>>> ", this.state);
    // console.log(
    //   "############### DocumentDetailsContainer >>>>",
    //   this.state.documentDetails.attachments[0]
    // );
    return (
      <div>
        <DocumentDetailsComponent
          documentDetails={this.state.documentDetails}
          onRejectionReasonChange={this.handleRejectionReason}
          // onAcceptDocument={() => this.handleAcceptDocument("CONFIRMED")}
          // onRejectDocument={() => this.handleAcceptDocument("REJECTED")}
          // onSubmitDocument={() => this.handleAcceptDocument("SUBMITTED")}
          actionButtons={this.getActionButtons()}
        />
      </div>
    );
  }
}

export default DocumentDetailsContainer;
