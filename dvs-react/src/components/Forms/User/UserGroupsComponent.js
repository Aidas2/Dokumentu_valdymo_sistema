import React, { Component } from "react";
import PropTypes from "prop-types";

const UserGroupsComponent = props => {
  return <option> {props.typeObject.title} </option>;
};

export default UserGroupsComponent;
