import React, { Component } from "react";
import { Link } from "react-router-dom";
import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";

class AdministrationContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div className="container-fluid no-padding">
        <div className="row justify-content-between no-padding ">
          <div className=" col-12  normal-padding">
            <h5 className="display-6  second-navigation-style ">
              <Link to={"/"}>
                <img
                  className="logo-color"
                  src={logo}
                  width="40"
                  height="20"
                  alt=""
                />
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin"} className="second-navigation">
                Administratoriaus rolė
              </Link>
            </h5>
            <h2 className="display-6 ">
              Administratoriaus rolė
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu yra pateiktos administratoriaus rolės. Čia galima
                  kurti ir peržiūrėti vartotojus ir jų grupes, dokumentus ir jų
                  tipus.
                </span>
              </div>
            </h2>
          </div>
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">Parametrai</div>
            <div className=" col-6 users-table-action-style">Veiksmai</div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">Vartotojai</div>
            <div className="col-6 documents-table-size">
              <Link
                to="/admin/users"
                className="btn btn-outline-success btn-sm admin-button-style"
              >
                Kurti / Peržiūrėti
              </Link>
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">Vartotojų grupės</div>
            <div className="col-6 documents-table-size">
              <Link
                to="/admin/usergroups"
                className="btn btn-outline-success btn-sm admin-button-style"
              >
                Kurti / Peržiūrėti
              </Link>
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">Dokumentai</div>
            <div className="col-6 documents-table-size">
              <Link
                to="/admin/docs"
                className="btn btn-outline-success btn-sm admin-button-style"
              >
                Kurti / Peržiūrėti
              </Link>
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">Dokumentų tipai</div>
            <div className="col-6 documents-table-size">
              <Link
                to="/admin/doctypes"
                className="btn btn-outline-success btn-sm admin-button-style"
              >
                Kurti / Peržiūrėti
              </Link>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default AdministrationContainer;
