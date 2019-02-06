import React, { Component } from "react";
import PropTypes from "prop-types";

const FileUploadComponent = props => {
  return (
    <div className="container-fluid">
      <h3>Dokumento įkėlimas</h3>
      <form>
        <div className="">
          <label className="m-2 ">Dokumento pavadinimas</label>
          <br />
          <input
            className="m-2 form-control col-2"
            type="text"
            onChange={props.onDocumentTitle}
          />
          <label className="m-2">Dokumento tipas</label>
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
        </div>

        <div className="input-group mb-3 mt-3 col-3  pl-2">
          <div className="input-group-prepend" />
          <div className="custom-file">
            <input
              type="file"
              onChange={props.onFile}
              className="custom-file-input "
              id="inputGroupFile01"
            />
            <label className="custom-file-label" form="inputGroupFile01">
              Pasirinkite pagrindinį dokumentą
            </label>
          </div>
        </div>

        <div className="input-group mb-3 mt-3 col-3  pl-2">
          <div className="input-group-prepend" />
          <div className="custom-file">
            <input
              type="file"
              multiple
              onChange={props.onFile}
              className="custom-file-input "
              id="inputGroupFile01"
            />
            <label className="custom-file-label" form="inputGroupFile01">
              Pasirinkite paildomus failus{" "}
            </label>
          </div>
        </div>

        {/* <div className="m-2">
          <label>Pasirinkite paildomus failus</label>&nbsp;
          <br />
          <input type="file" multiple name="file" onChange={props.onFile} />
        </div>
        <br /> */}

        <button
          type="button"
          className="btn btn-info m-2"
          onClick={props.onUpload}
        >
          Įkelti
        </button>
      </form>
    </div>
  );
};

export default FileUploadComponent;
