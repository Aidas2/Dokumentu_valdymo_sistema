import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import FileDownloadConatainer from "../FileDownload/FileDownloadContainer";
import FileViewContainer from "../FileDownload/FileViewContainer";

const DocumentsComponent = props => {
  var {
    id,
    author,
    documentStateInLithuanian,
    documentTypeTitleInLithuanian,
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

  const linkToDOcumentDetails = "/admin/docs/" + id;
  return (
    <div className="row">
      <div className="col-1 documents-table-size">
        {id}
        {/* <Link to="">Linkas</Link> */}
      </div>
      <div className="col-2 documents-table-size">
        <Link to={linkToDOcumentDetails}>{title}</Link>
      </div>
      <div className="col-2 documents-table-size">
        {documentTypeTitleInLithuanian}
      </div>
      <div className="col-2 documents-table-size">
        {documentStateInLithuanian}
      </div>
      <div className="col-3 documents-table-size">{description}</div>

      <div className="col-1 documents-table-size">
        <FileViewContainer documentId={id} />
      </div>
      <div className="col-1 documents-table-size">
        <FileDownloadConatainer documentId={id} />
      </div>
    </div>
  );
};

export default DocumentsComponent;

{
  /* 
<div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-1">
          <p>{id}</p>
          
        </div>
        <div className="col-2">
          <Link to={linkToDOcumentDetails}>{title}</Link>
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
*/
}
