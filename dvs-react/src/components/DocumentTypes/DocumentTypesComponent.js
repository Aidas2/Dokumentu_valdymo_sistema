import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const DocumentTypesComponent = props => {
  return (
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-2">
          {props.typeId}
          {/* <Link to="">Linkas</Link> */}
        </div>

        <div className="col-2">
          <p>{props.typeTitle}</p>
        </div>
      </div>
    </div>
  );
};

export default DocumentTypesComponent;
