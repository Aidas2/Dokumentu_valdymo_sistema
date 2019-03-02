import React, { Component } from "react";
import UserGroupDetailsComponent from "./DocumentDetailsComponent";
import axios from "axios";

class DocumentDetailsContainer extends Component {
  state = { id: "" };

  componentDidMount() {
    const idParam = this.props.match.params.id;

    axios({
      url: "http://localhost:8081/api/docs/" + idParam,
      method: "GET"
    })
      .then(response => {
        this.setState({
          id: response.data.id
        });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    var submissionTypesToDisplay = null;
    if (this.state.submissionDocType) {
      submissionTypesToDisplay = this.state.submissionDocType.map(title => (
        <li key={title}>{title}</li>
      ));
    }
    var reviewTypesToDisplay = null;
    if (this.state.submissionDocType) {
      reviewTypesToDisplay = this.state.reviewDocType.map(title => (
        <li key={title}>{title}</li>
      ));
    }
    return (
      <UserGroupDetailsComponent
        title={this.state.title}
        submissionDocTypes={submissionTypesToDisplay}
        reviewDocTypes={reviewTypesToDisplay}
      />
    );
  }
}

export default DocumentDetailsContainer;
