import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import CreateDocumentTypeComponent from "./CreateDocumentTypeComponent";

class CreateDocumentTypeConatainer extends Component {
  state = { title: "" };

  handleSubmit = () => {
    axios
      .post("http://localhost:8081/api/doctypes", {
        title: this.state.title
      })
      .then(function(response) {
        console.log(response);
      })
      .catch(function(error) {
        console.log(error);
      });
    console.log(">>>>>>>>>Submit happened");
    console.log("@@@@@@@@@@@@@@@ this.state.title >>>>>>>> ", this.state.title);
  };

  handleTitleChange = e => {
    let documentTypeTitle = e.target.value;
    this.setState({ title: documentTypeTitle });
  };
  render() {
    return (
      <CreateDocumentTypeComponent
        onTitleChange={this.handleTitleChange}
        onSubmit={this.handleSubmit}
      />
    );
  }
}

export default CreateDocumentTypeConatainer;
