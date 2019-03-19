import React from "react";

import { Link } from "react-router-dom";

const StatisticsComponent = props => {
  return (
    <div>
      <div className="row users-padding-bottom">
        <div className="col-1  documents-table-size  ">{props.index}</div>
        <div className="col-2  documents-table-size">component</div>
        <div className="col-2   documents-table-size">{555}</div>
      </div>
      <div className="select col-4 ml-3">
        <label>Pasirinkite dokumento tipą:</label>
        <select className="form-control" id="sel1">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
        </select>
      </div>
    </div>
  );
};

export default StatisticsComponent;
