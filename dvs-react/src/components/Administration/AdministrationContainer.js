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
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Administratoriaus rolė
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="" />
            <span className="tooltiptext">
              Šiame meniu yra pateiktos administratoriaus rolės. Čia galima
              kurti ir peržiūrėti vartotojus ir jų grupes, dokumentus ir jų
              tipus.
            </span>
          </div>
        </h2>

        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" alt="logo icon" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="second-navigation">
            Administratoriaus rolė
          </Link>
        </h5>

        <table className="table table-style-rounded table-color-style">
          <tbody>
            <tr className="">
              <th scope="col-2">#</th>
              <th scope="col-7">Parametrai</th>
              <th scope="col-3">Veiksmai</th>
            </tr>
            <tr>
              <td>
                <h6>1</h6>
              </td>
              <td>
                <h6>Vartotojai</h6>
              </td>
              <td>
                <Link
                  to="/admin/users"
                  className="btn btn-outline-success btn-sm admin-button-style"
                >
                  Kurti / Peržiūrėti
                </Link>
              </td>
            </tr>
            <tr>
              <td>
                <h6>2</h6>
              </td>
              <td>
                <h6>Vartotojų grupės</h6>
              </td>

              <td>
                <Link
                  to="/admin/usergroups"
                  className="btn btn-outline-success btn-sm admin-button-style"
                >
                  Kurti / Peržiūrėti
                </Link>
              </td>
            </tr>
            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Dokumentai</h6>
              </td>
              <td>
                <Link
                  to="/admin/docs"
                  className="btn btn-outline-success btn-sm admin-button-style"
                >
                  Kurti / Peržiūrėti
                </Link>
              </td>
            </tr>
            <tr>
              <td>
                <h6>4</h6>
              </td>
              <td>
                <h6>Dokumentų tipai</h6>
              </td>
              <td>
                <Link
                  to="/admin/doctypes"
                  className="btn btn-outline-success btn-sm admin-button-style"
                >
                  Kurti / Peržiūrėti
                </Link>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

export default AdministrationContainer;
