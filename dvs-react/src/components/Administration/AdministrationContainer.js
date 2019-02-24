import React, { Component } from "react";
import { Link } from "react-router-dom";
import logo from "../../images/home.png";

class AdministrationContainer extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    return (
      <div className="container-fluid ">
        <h6 className="display-6 normal-padding">
          Administratoriaus nustatymai
        </h6>

        <h6 className="display-6 normal-padding gray-collor">
          <Link to={"/"}>
            <img src={logo} width="30" height="15" />
          </Link>
          / Administratoriaus rolė
        </h6>

        <table class="table table-striped">
          <tr>
            <th scope="col-2">#</th>
            <th scope="col-7">Parametrai</th>
            <th scope="col-3">Veiksmai</th>
          </tr>

          <tbody>
            <tr>
              <td scope="row">
                <h6>1</h6>
              </td>
              <td scope="row">
                <h6>Vartotojų grupės</h6>
              </td>

              <td scope="row">
                <Link
                  to="/admin/doctypes"
                  className="btn btn-outline-success btn-sm"
                >
                  Kurti
                </Link>
              </td>
            </tr>

            <tr>
              <td scope="row">
                <h6>2</h6>
              </td>
              <td scope="row">
                <h6>Dokumentų tipai</h6>
              </td>
              <td scope="row">
                <Link
                  to="/admin/doctypes"
                  className="btn btn-outline-success btn-sm"
                >
                  Kurti
                </Link>
              </td>
            </tr>

            <tr>
              <td scope="row">
                <h6>3</h6>
              </td>
              <td scope="row">
                <h6>Vartotojai</h6>
              </td>
              <td scope="row">
                <Link
                  to="/admin/doctypes"
                  className="btn btn-outline-success btn-sm "
                >
                  Kurti
                </Link>
              </td>
            </tr>
          </tbody>
        </table>

        {/*


        <h6 className="display-6">
          1. Kurti vartotojų grupes
          <Link to="/admin/usergroups" className="btn btn-outline-success m-2">
            Kurti
          </Link>
        </h6>

        <h6 className="display-6">
          2. Kurti dokumentų tipus
          <Link to="/admin/doctypes" className="btn btn-outline-success m-2">
            Kurti
          </Link>
        </h6>

        <h6 className="display-6">
          3. Registruoti naują vartotoją
          <Link to="/admin/users" className="btn btn-outline-success m-2">
            Registruoti
          </Link>
        </h6>

*/}
      </div>
    );
  }
}

export default AdministrationContainer;
