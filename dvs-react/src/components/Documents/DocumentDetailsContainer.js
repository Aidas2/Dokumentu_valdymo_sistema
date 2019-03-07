import React, { Component } from "react";

import axios from "axios";
import DocumentDetailsComponent from "./DocumentDetailsComponent";

class DocumentDetailsContainer extends Component {
  state = {
    documentDetails: {
      id: "",
      author: "",
      documentTypeTitleInLithuanian: "",
      documentStateInLithuanian: "",
      title: "",
      description: "",
      creationDate: "",
      submissionDate: "nepateiktas",
      confirmationDate: "nepatvirtintas",
      rejectionDate: "neatmestas",
      reviewer: "neperžiūrėtas",
      rejectionReason: "priežastis nepaeikta",
      path: ""
    }
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
  handleAcceptDocument = () => {
    console.log("Accept happened");
  };
  handleRejectDocument = () => {
    console.log("Reject happened");
  };
  handleRejectionReason = e => {
    let rejectionReason = e.target.value;
    console.log("Rejection reason: ", rejectionReason);
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
    console.log(
      "render() _--------------------- >>>> ",
      this.state.documentDetails
    );
    return (
      <div>
        <DocumentDetailsComponent
          documentDetails={this.state.documentDetails}
          onRejectionReasonChange={this.handleRejectionReason}
          onAcceptDocument={this.handleAcceptDocument}
          onRejectDocument={this.handleRejectDocument}
        />
      </div>
    );
  }
}

export default DocumentDetailsContainer;
