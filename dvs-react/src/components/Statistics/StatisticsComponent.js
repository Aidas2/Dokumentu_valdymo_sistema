import React from "react";

import { Link } from "react-router-dom";

const StatisticsComponent = props => {
  const {
    createdDocumentsCount,
    submittedDocumentsCount,
    acceptedDocumentsCount,
    rejectedDocumentsCount
  } = props.statisticsObject;

  const createdDocumentsCountGraph =
    createdDocumentsCount / createdDocumentsCount;
  const submittedDocumentsCountGraph =
    submittedDocumentsCount / createdDocumentsCount;
  const acceptedDocumentsCountGraph =
    acceptedDocumentsCount / createdDocumentsCount;
  const rejectedDocumentsCountGraph =
    rejectedDocumentsCount / createdDocumentsCount;

  const styleGraph = {
    createdDocumentsCountGraphStyle: {
      width: `${createdDocumentsCountGraph * 100 || 0.5}%`
    },
    submittedDocumentsCountGraphStyle: {
      width: `${submittedDocumentsCountGraph * 100 || 0.5}%`
    },
    acceptedDocumentsCountGraphStyle: {
      width: `${acceptedDocumentsCountGraph * 100 || 0.5}%`
    },
    rejectedDocumentsCountGraphStyle: {
      width: `${rejectedDocumentsCountGraph * 100 || 0.5}%`
    }
  };

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

        <dl>
          <dt>Gal iseitu cia paduoti dokumento tipa?</dt>
          <dd
            class="created-graph-style "
            style={styleGraph.createdDocumentsCountGraphStyle}
          >
            {/* <span class="text">Sukurta</span> */}
          </dd>
          <dd
            class="subbmitted-graph-style"
            style={styleGraph.submittedDocumentsCountGraphStyle}
          >
            {/* <span class="text">Pateikta</span> */}
          </dd>
          <dd
            class="accepted-graph-style"
            style={styleGraph.acceptedDocumentsCountGraphStyle}
          >
            {/* <span class="text">Patvirtinta</span> */}
          </dd>
          <dd
            class="rejected-graph-style"
            style={styleGraph.rejectedDocumentsCountGraphStyle}
          >
            {/* <span class="text">Atmesta</span> */}
          </dd>
        </dl>
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
