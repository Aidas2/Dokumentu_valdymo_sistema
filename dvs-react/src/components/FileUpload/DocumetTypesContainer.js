import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import DocumetTypesComponent from "./DocumentTypesComponent";

class DocumentTypesContainer extends Component {
  state = { documentTypes: [] };

  componentDidMount() {
    console.log("ComponentDidMount inside DocumentTYpesCOntainer");
    axios
      .get("http://localhost:8081/api/doctypes")
      .then(response => {
        this.setState({ documentTypes: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    console.log("$$$$$$$$$ this.state >>>>>>>>>", this.state);
    this.state.documentTypes.length > 1
      ? console.log(
          "$$$$$$$$$ this.state.documentTypes[1].title >>>>>>>>>",
          this.state.documentTypes[1].title
        )
      : console.log("$$$$$$$$$ Array does not contain at least 2 elements ");
    console.log("$$$$$$$$$$ docTypesArray >>>>>>>>>");

    const docTypesArrayToRender = this.state.documentTypes.map(oneType => {
      return <DocumetTypesComponent key={oneType.id} typeObject={oneType} />;
    });
    return (
      <select
        onChange={this.props.onDocumentTypeChange}
        className="form-control col-2 m-2"
        id="documentTypeSelect"
      >
        {docTypesArrayToRender}
      </select>
    );
  }
}

export default DocumentTypesContainer;
