import React, { Component } from "react";
import PropTypes from "prop-types";

const UserGroupsComponent = props => {
  return <option> {props.groupObject.title} </option>;
};

export default UserGroupsComponent;
