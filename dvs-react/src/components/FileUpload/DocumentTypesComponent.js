import React, { Component } from "react";
import PropTypes from "prop-types";

const DocumetTypesComponent = props => {
  return <option> {props.typeObject.title} </option>;
};

export default DocumetTypesComponent;
