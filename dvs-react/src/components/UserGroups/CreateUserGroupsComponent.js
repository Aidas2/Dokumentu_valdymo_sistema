import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesContainer from "../FileUpload/DocumetTypesContainer";

const CreateUserGroupsComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h3 className="display-6 ">Naujos vartotojų grupės kūrimas</h3>
        <h5>Vartotojų grupės pavadinimas</h5>
        <input
          onChange={props.onTitleChange}
          className="form-control col-4"
          type="text"
          placeholder="Įveskite dokumento tipo pavadinimą"
        />
        <h6>Pasirinkite pateikti leidžiamų dokumentų tipus</h6>
        <DocumentTypesContainer
          documentTypes={props.documentTypes}
          onDocumentTypeChange={props.onSubmitTypesChange}
        />
        <span className="italic-style-small">
          Pasirinktos grupės: {props.selectedSubmissionTypesTitles}
        </span>
        <h6>Pasirinkite peržiūrėti leidžiamų dokumentų tipus</h6>
        <DocumentTypesContainer
          documentTypes={props.documentTypes}
          onDocumentTypeChange={props.onReviewTypesChange}
        />
        <span className="italic-style-small">
          Pasirinktos grupės: {props.selectedReviewTypesTitles}
        </span>
        <br />
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
