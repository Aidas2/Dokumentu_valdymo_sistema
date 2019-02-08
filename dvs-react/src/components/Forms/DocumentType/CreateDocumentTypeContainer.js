import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import CreateDocumentTypeComponent from "./CreateDocumentTypeComponent";

class CreateDocumentTypeConatainer extends Component {
  state = {};

  handleSubmit = () => {
    axios
      .post("http://localhost:8081/api/doctypes", {
        id: 1,
        title: "shouldBeID35UI"
      })
      .then(function(response) {
        console.log(response);
      })
      .catch(function(error) {
        console.log(error);
      });
    console.log(">>>>>>>>>Submit happened");
  };
  render() {
    return <CreateDocumentTypeComponent onSubmit={this.handleSubmit} />;
  }
}

export default CreateDocumentTypeConatainer;
