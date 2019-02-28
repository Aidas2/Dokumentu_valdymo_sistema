import React, { Component } from "react";
import UserGroupDetailsComponent from "./UserGroupDetailsComponent";
import axios from "axios";

class UserGroupDetailsContainer extends Component {
  state = { title: "", submissionDocType: [], reviewDocType: [] };

  componentDidMount() {
    const titleParam = this.props.match.params.title;

    axios({
      url: "http://localhost:8081/api/groups/" + titleParam,
      method: "GET"
      //   params: {
      //     username: "username1"
      //   }
    })
      .then(response => {
        this.setState({
          title: response.data.title,
          submissionDocType: response.data.submissionDocType,
          reviewDocType: response.data.reviewDocType
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

export default UserGroupDetailsContainer;
