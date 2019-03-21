import React, { Component } from "react";

import DocumetTypesComponent from "./DocumentTypesComponent";

class DocumentTypesContainer extends Component {
  render() {
    const docTypesArrayToRender = this.props.documentTypes.map(oneType => {
      return <DocumetTypesComponent key={oneType.id} typeObject={oneType} />;
    });
    return (
      <select
        onChange={this.props.onDocumentTypeChange}
        multiple={this.props.isMultiple}
        className="form-control col-12 pop-up-style"
        id="documentTypeSelect"
      >
        {docTypesArrayToRender}
      </select>
    );
  }
}

export default DocumentTypesContainer;
