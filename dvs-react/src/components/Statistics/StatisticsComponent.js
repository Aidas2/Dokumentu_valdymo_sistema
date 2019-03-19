import React from "react";

import { Link } from "react-router-dom";

const StatisticsComponent = props => {
  const {
    createdDocumentsCount,
    submittedDocumentsCount,
    acceptedDocumentsCount,
    rejectedDocumentsCount
  } = props.statisticsObject;

  return (
    <div>
      <div className="select col-4 ml-3">
        <label>Pasirinkite dokumento tipą:</label>
        <select
          onChange={props.onDocumentTypeChange}
          className="form-control pop-up-style margin-bottom-style"
          multiple
          id="sel1"
        >
          {props.docTypesToRender}
        </select>
      </div>

      <div className="row users-padding-bottom table-style-rounded">
        <div className="col-3 users-table-number-style  ">Sukurta</div>
        <div className="col-3   users-table-middle-style">Pateikta</div>
        <div className="col-3   users-table-middle-style ">Patvirtinta</div>
        <div className="col-3  users-table-middle-style ">Atmesta</div>
      </div>

      <div className="row users-padding-bottom">
        <div className="col-3  documents-table-size  ">
          {createdDocumentsCount}
        </div>
        <div className="col-3  documents-table-size">
          {submittedDocumentsCount}
        </div>
        <div className="col-3  documents-table-size">
          {acceptedDocumentsCount}
        </div>
        <div className="col-3   documents-table-size">
          {rejectedDocumentsCount}
        </div>
      </div>

      {/* <div className="select col-4 ml-3">
        <label>Pasirinkite dokumento tipą:</label>
        <select
          onChange={props.onDocumentTypeChange}
          className="form-control"
          id="sel1"
        >
          {props.docTypesToRender}
          
        </select>
      </div> */}
    </div>
  );
};

export default StatisticsComponent;
