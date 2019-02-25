import React, { Component } from "react";
import { Link } from "react-router-dom";
import logo from "../../images/home.png";

class CreateUserGroupsContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }
  render() {
    return (
      <div className="container-fluid ">
        <h6 className="display-6 normal-padding">Dokumentų tipai</h6>

        <h5 className="display-6 normal-padding gray-collor ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="explorer">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/usergroups"} className="explorer">
            Grupių sąrašas
          </Link>
        </h5>

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
