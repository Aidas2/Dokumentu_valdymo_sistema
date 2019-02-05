import React, { Component } from "react";
import PropTypes from "prop-types";

const FileUploadComponent = props => {
  return (
    <div className="App">
      <h3>Dokumento įkėlimas</h3>
      <form>
        <div className="">
          <label className="m-2">Documento pavadinimas</label>
          <br />
          <input className="m-2" type="text" onChange={props.onDocumentTitle} />
          <br />
          <label>Dokumento tipas</label>
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
          <label>Pasirinkite dokumentą</label>&nbsp;
          <br />
          <input type="file" name="file" onChange={props.onFile} />
        </div>
        <div className="">
          <label>Pasirinkite paildomus failus</label>&nbsp;
          <br />
          <input type="file" multiple name="file" onChange={props.onFile} />
        </div>
        <br />

        <button type="button" className="btn btn-info" onClick={props.onUpload}>
          Įkelti
        </button>
      </form>
    </div>
  );
};

export default FileUploadComponent;
