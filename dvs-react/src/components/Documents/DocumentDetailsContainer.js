import React, { Component } from "react";

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
      path: ""
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
    // this.state.setStateInfo.documentState === "PATEIKTAS"
    //   ? this.setState({ setStateInfo })
    //   : console.log("Document has already been managed");

    axios({
      url: "http://localhost:8081/api/docs/setstate2",
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
    return (
      <div>
        <DocumentDetailsComponent
          documentDetails={this.state.documentDetails}
          onRejectionReasonChange={this.handleRejectionReason}
          onAcceptDocument={() => this.handleAcceptDocument("CONFIRMED")}
          onRejectDocument={() => this.handleAcceptDocument("REJECTED")}
          onSubmitDocument={() => this.handleAcceptDocument("SUBMITTED")}
        />
      </div>
    );
  }
}

export default DocumentDetailsContainer;
