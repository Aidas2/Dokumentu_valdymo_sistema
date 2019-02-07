import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";

class DocumentTypesContainer extends Component {
  state = { documentTypes: [] };

  componentDidMount() {
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

    let docTypesArray = this.state.documentTypes;
    console.log("$$$$$$$$$$ docTypesArray >>>>>>>>>");

    return (
      <select className="form-control col-2 m-2" id="documentTypeSelect">
        <option>Type1</option>
        <option>Type2</option>
        <option>Type3</option>
        <option>Type4</option>
        <option>Type5</option>
      </select>
    );
  }
}

export default DocumentTypesContainer;
