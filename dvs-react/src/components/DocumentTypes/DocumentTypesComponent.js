import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const DocumentTypesComponent = props => {
  return (
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-12 padding-normal">
          {props.typeId}
          {/* <Link to="">Linkas</Link> */}

          {props.typeTitle}
        </div>
      </div>
    </div>
  );
};

export default DocumentTypesComponent;
