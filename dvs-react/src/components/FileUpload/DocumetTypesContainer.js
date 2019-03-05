import React, { Component } from "react";

import DocumetTypesComponent from "./DocumentTypesComponent";

class DocumentTypesContainer extends Component {
  // state = { documentTypes: [] };

  // componentDidMount() {
  //   console.log("ComponentDidMount inside DocumentTYpesCOntainer");
  //   axios
  //     .get("http://localhost:8081/api/doctypes")
  //     .then(response => {
  //       this.setState({ documentTypes: response.data });
  //     })
  //     .catch(error => {
  //       console.log(error);
  //     });
  // }

  render() {
    console.log("$$$$$$$$$ this.props >>>>>>>>>", this.props);
    this.props.documentTypes.length > 1
      ? console.log(
          "$$$$$$$$$ this.props.documentTypes[1].title >>>>>>>>>",
          this.props.documentTypes[1].title
        )
      : console.log("$$$$$$$$$ Array does not contain at least 2 elements ");
    console.log("$$$$$$$$$$ docTypesArray >>>>>>>>>");

    const docTypesArrayToRender = this.props.documentTypes.map(oneType => {
      return <DocumetTypesComponent key={oneType.id} typeObject={oneType} />;
    });
    return (
      <select
        onChange={this.props.onDocumentTypeChange}
        className="form-control col-6 pop-up-style"
        id="documentTypeSelect"
      >
        {docTypesArrayToRender}
      </select>
    );
  }
}

export default DocumentTypesContainer;
