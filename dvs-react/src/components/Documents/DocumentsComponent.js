import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import FileDownloadConatainer from "../FileDownload/FileDownloadContainer";
import FileViewContainer from "../FileDownload/FileViewContainer";

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
          <Link to="/admin/docs/:id">{title}</Link>
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
          <FileViewContainer documentId={id} />
        </div>
        <div className="col-1">
          <FileDownloadConatainer documentId={id} />
        </div>
      </div>
    </div>
  );
};

export default DocumentsComponent;
