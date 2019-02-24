import React, { Component } from "react";
import { Link } from "react-router-dom";

class CreateUserGroupsContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }
  render() {
    return (
      <div className="container-fluid ">
        <h3 class="display-6">Grupių sąrašas</h3>
        <h6 class="display-6">Pirma grupė</h6>
        <h6 class="display-6">Antra grupė</h6>

        <Link
          to="/admin/usergroups/new"
          className="btn btn-outline-success m-2"
        >
          Kurti naują grupę
        </Link>
      </div>
    );
  }
}

export default CreateUserGroupsContainer;
