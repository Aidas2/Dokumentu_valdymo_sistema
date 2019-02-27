import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesContainer from "../FileUpload/DocumetTypesContainer";

const CreateUserGroupsComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h3 className="display-6 ">Naujo dokumento tipo kūrimas</h3>
        <h5>Dokumento tipo pavadinimas</h5>
        <input
          onChange={props.onTitleChange}
          className="form-control col-4"
          type="text"
          placeholder="Įveskite dokumento tipo pavadinimą"
        />
        <h6>Dokumento tipas</h6>
        <DocumentTypesContainer
          documentTypes={props.documentTypes}
          onDocumentTypeChange={props.onDocumentTypeChange}
        />

        <button
          onClick={props.onSubmit}
          className="btn btn-outline-success m-2"
        >
          Kurti
        </button>
      </div>
      <div className="container">{props.launchAlert}</div>
    </div>
  );
};

export default CreateUserGroupsComponent;
