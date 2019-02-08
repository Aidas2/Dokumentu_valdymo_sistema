import React, { Component } from "react";
import { Link } from "react-router-dom";

class AdministrationContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div className="container-fluid ">
        <h6 class="display-6">
          1. Kurti vartotojų grupes
          <Link to="/admin/usergroups" className="btn btn-warning m-2">
            Kurti
          </Link>
        </h6>

        <h6 class="display-6">
          2. Kurti dokumentų tipus
          <Link to="/admin/doctypes" className="btn btn-warning m-2">
            Kurti
          </Link>
        </h6>

        <h6 class="display-6">
          3. Registruoti naują vartotoją
          <Link to="/admin/usergroups" className="btn btn-warning m-2">
            Registruoti
          </Link>
        </h6>
      </div>
    );
  }
}

export default AdministrationContainer;
