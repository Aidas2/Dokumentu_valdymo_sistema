import React from "react";
import infoIcon from "../../images/info-icon.png";
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
      width: `${createdDocumentsCountGraph * 100 + 0.4 || 0.4}%`
    },
    submittedDocumentsCountGraphStyle: {
      width: `${submittedDocumentsCountGraph * 100 + 0.4 || 0.4}%`
    },
    acceptedDocumentsCountGraphStyle: {
      width: `${acceptedDocumentsCountGraph * 100 + 0.4 || 0.4}%`
    },
    rejectedDocumentsCountGraphStyle: {
      width: `${rejectedDocumentsCountGraph * 100 + 0.4 || 0.4}%`
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
        <div className="col-12 statistics-table-number-style  ">
          {props.selectedDocType}
        </div>
        {/* <div className="col-3   users-table-middle-style">Pateikta</div>
        <div className="col-3   users-table-middle-style ">Patvirtinta</div>
        <div className="col-3  users-table-middle-style ">Atmesta</div> */}
      </div>

      <div className="row users-padding-bottom">
        {/* <div className="col-3  documents-table-size ">
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
        </div> */}

        {/* <dl> */}
        {/* <dt>{props.selectedDocType}</dt> */}
        <div className="col-2 documents-table-size">Sukurta</div>
        <div className="col-10 documents-table-size logo-info">
          <span className="tooltiptext-statistics">
            {createdDocumentsCount +
              " " +
              "(" +
              Math.round(
                100 * (createdDocumentsCount / createdDocumentsCount || 0)
              ) +
              "%)"}
          </span>
          <dd
            class="created-graph-style "
            style={styleGraph.createdDocumentsCountGraphStyle}
          />
        </div>
        <div className="col-2  documents-table-size ">Pateikta</div>
        <div className="col-10  documents-table-size logo-info">
          <span className="tooltiptext-statistics">
            {submittedDocumentsCount +
              " " +
              "(" +
              Math.round(
                100 * (submittedDocumentsCount / createdDocumentsCount || 0)
              ) +
              "%)"}
          </span>

          <dd
            class="subbmitted-graph-style "
            style={styleGraph.submittedDocumentsCountGraphStyle}
          />
        </div>

        <div className="col-2  documents-table-size ">Patvirtinta</div>
        <div className="col-10  documents-table-size logo-info ">
          <span className="tooltiptext-statistics">
            {acceptedDocumentsCount +
              " " +
              "(" +
              Math.round(
                100 * (acceptedDocumentsCount / createdDocumentsCount || 0)
              ) +
              "%)"}
          </span>
          <dd
            class="accepted-graph-style"
            style={styleGraph.acceptedDocumentsCountGraphStyle}
          />
        </div>

        <div className="col-2  documents-table-size">Atmesta</div>
        <div className="col-10  documents-table-size  logo-info">
          <span className="tooltiptext-statistics">
            {rejectedDocumentsCount +
              " " +
              "(" +
              Math.round(
                100 * (rejectedDocumentsCount / createdDocumentsCount || 0)
              ) +
              "%)"}
          </span>
          <dd
            class="rejected-graph-style"
            style={styleGraph.rejectedDocumentsCountGraphStyle}
          />
        </div>

        {/* <dd>{createdDocumentsCount}</dd>
        <dd
          class="subbmitted-graph-style"
          style={styleGraph.submittedDocumentsCountGraphStyle}
        >
         
        </dd>
        <dd
          class="accepted-graph-style"
          style={styleGraph.acceptedDocumentsCountGraphStyle}
        >
       
        </dd>
        <dd
          class="rejected-graph-style"
          style={styleGraph.rejectedDocumentsCountGraphStyle}
        >
          
        </dd>
        </dl> */}
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
