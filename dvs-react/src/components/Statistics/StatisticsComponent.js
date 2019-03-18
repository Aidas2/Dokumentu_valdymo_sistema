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
      <div className="row users-padding-bottom">
        <div className="col-1  documents-table-size  ">
          {createdDocumentsCount}
        </div>
        <div className="col-2  documents-table-size">
          {submittedDocumentsCount}
        </div>
        <div className="col-2  documents-table-size">
          {acceptedDocumentsCount}
        </div>
        <div className="col-2   documents-table-size">
          {rejectedDocumentsCount}
        </div>
      </div>
      <div className="select col-4 ml-3">
        <label>Pasirinkite dokumento tipą:</label>
        <select
          onChange={props.onDocumentTypeChange}
          className="form-control"
          id="sel1"
        >
          {props.docTypesToRender}
          {/* <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option> */}
        </select>
      </div>
    </div>
  );
};

export default StatisticsComponent;
