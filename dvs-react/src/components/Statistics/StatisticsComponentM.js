import React from "react";

import { Link } from "react-router-dom";

const StatisticsComponent = props => {
  return (
    <div className="row users-padding-bottom">
      <div className="col-1  documents-table-size  ">{props.index}</div>

      <div className="col-2  documents-table-size">{555}</div>
      <div className="col-2   documents-table-size">{555}</div>
    </div>
  );
};

export default StatisticsComponent;
