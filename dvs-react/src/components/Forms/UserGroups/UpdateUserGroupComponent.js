import React from "react";

import logo from "../../../images/home.png";
import { Link } from "react-router-dom";
import UserGroupsContainer from "../../UserGroups/UserGroupsContainer";
import infoIcon from "../../../images/info-icon.png";
const UpdateUserGroupComponent = props => {
  const {
    userGroups,
    administrator,
    emailAddress,
    firstName,
    hireDate,
    lastName,
    password,
    username
  } = props.userDetailsBeforeUpdate;

  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Vartotojo <stron>{username}</stron> informacijos atnaujinimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame meniu galima kurti naujus vartotojus.
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
          &ensp;/ &ensp;
          <Link to={"/admin/users"} className="second-navigation">
            Vartotojai
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/newuser"} className="second-navigation">
            Naujo vartotojo kūrimas
          </Link>
        </h5>
        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th className="col-1">#</th>
              <th className="col-5">Lauko pavadinimas</th>
              <th className="col-6">Įvedimo laukas</th>
            </tr>
            <tr>
              <td>
                <h6>1</h6>
              </td>
              <td>
                <h6>Vardas</h6>
              </td>
              <td>
                <input
                  className=" form-control form-control-sm italic-style"
                  placeholder={firstName}
                  type="text"
                  onChange={props.onFirstNameChange}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>2</h6>
              </td>
              <td>
                <h6>Pavardė</h6>
              </td>

              <td>
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder={lastName}
                  type="text"
                  onChange={props.onLastNameChange}
                />
              </td>
            </tr>

            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Elektroninio pašto adresas</h6>
              </td>
              <td>
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder={emailAddress}
                  type="email"
                  onChange={props.onEmailAddressChange}
                />
              </td>
            </tr>

            <tr>
              <td>
                <h6>4</h6>
              </td>
              <td>
                <h6>Įdarbinimo data</h6>
              </td>

              <td>
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder={hireDate}
                  type="date"
                  onChange={props.onHireDateChange}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>5</h6>
              </td>
              <td>
                <h6>Prisijungimo slaptažodis</h6>
              </td>

              <td>
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder={password}
                  p
                  type="password"
                  onChange={props.onPasswordChange}
                  required
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>6</h6>
              </td>
              <td>
                <h6>Administratoriaus rolė</h6>
              </td>

              <td>
                <select
                  onChange={props.onAdministratorChange}
                  className="col-6 form-control form-control-sm italic-style "
                  id="documentTypeSelect"
                >
                  <option value="false">Ne</option>
                  <option value="true">Taip</option>
                </select>
                <br />
                <span>
                  Po atnaujinimo vartotojui bus priskirta ši reikšmė:&ensp;
                  <strong> {props.mostRecentAdmintValue}</strong>
                </span>
              </td>
            </tr>
            <tr>
              <td>
                <h6>7</h6>
              </td>
              <td>
                <h6>Vartotojo grupė</h6>
              </td>

              <td>
                <UserGroupsContainer
                  userGroups={props.userGroups}
                  onUserGroupChange={props.onUserGroupChange}
                />
                <span className="italic-style-small">
                  Pasirinktos grupės: {props.selectedUserGroupsTitles}
                </span>
              </td>
            </tr>
            <tr>
              <td>
                <h6> </h6>
              </td>
              <td>
                <h6> </h6>
              </td>
              <td>
                <button
                  type="button"
                  className="btn btn-outline-success btn-sm document-button-style"
                  onClick={props.onSubmit}
                >
                  Atnaujinti
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className="container">{props.launchAlert}</div>
    </div>
  );
};

export default UpdateUserGroupComponent;