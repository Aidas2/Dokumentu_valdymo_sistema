import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const DocumentsComponent = props => {
  var {
    id,
    author,
    documentState,
    documentTypeTitle,
    title,
    description,
    creationDate,
    submissionDate,
    confirmationDate,
    rejectionDate,
    reviewer,
    rejectionReason,
    path
  } = props.documentDetails;
  return (
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-1">
          <p>{id}</p>
          {/* <Link to="">Linkas</Link> */}
        </div>
        <div className="col-2">
          <p>{title}</p>
        </div>
        <div className="col-2">
          <p>{documentTypeTitle}</p>
        </div>
        <div className="col-2">
          <p>{documentState}</p>
        </div>
        <div className="col-2">
          <p>{description}</p>
        </div>

        <div className="col-1">
          <button onClick={props.onDocumentView} className="btn btn-secondary">
            Peržiūrėti
          </button>
        </div>
        <div className="col-1">
          <button onClick={props.onDocumentDownload} className="btn btn-dark">
            Atsisiųsti
          </button>
        </div>
      </div>
    </div>
  );
};

export default DocumentsComponent;
