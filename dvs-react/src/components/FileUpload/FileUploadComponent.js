import React, { Component } from "react";
import PropTypes from "prop-types";

const FileUploadComponent = props => {
  return (
    <div className="App">
      <h1>The form</h1>
      <form>
        <div className="">
          <label className="m-2">Document Title</label>
          <br />
          <input className="m-2" type="text" onChange={props.onDocumentTitle} />
          <br />
          <label>Document Type</label>
          <select
            //   onLoad={props.onInitialDocumentType}
            onChange={props.onDocumentType}
            className="form-control col-2 m-2"
            id="documentTypeSelect"
          >
            <option>Type1</option>
            <option>Type2</option>
            <option>Type3</option>
            <option>Type4</option>
            <option>Type5</option>
          </select>
          <label>Select document</label>&nbsp;
          <br />
          <input type="file" name="file" onChange={props.onFile} />
        </div>
        <div className="">
          <label>Select attachments</label>&nbsp;
          <br />
          <input type="file" multiple name="file" onChange={props.onFile} />
        </div>
        <br />

        <button type="button" onClick={props.onUpload}>
          Upload
        </button>
      </form>
    </div>
  );
};

export default FileUploadComponent;
