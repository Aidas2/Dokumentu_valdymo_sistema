import React, { Component } from "react";
import { Link } from "react-router-dom";
import HolidaysContainer from "../Holidays/HolidaysContainer";

class AdministrationContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }
  render() {
    return (
      <div className="container-fluid ">
        <Link to="/admin/holidays/new" className="btn btn-warning m-2">
          add new holiday
        </Link>
        <Link to="/admin/countries/new" className="btn btn-warning m-2">
          add new country
        </Link>
        <HolidaysContainer />
      </div>
    );
  }
}

export default AdministrationContainer;
