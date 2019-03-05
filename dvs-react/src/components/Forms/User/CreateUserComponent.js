import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../../images/home.png";
import { Link } from "react-router-dom";
import UserGroupsContainer from "./UserGroupsContainer";
import infoIcon from "../../../images/info-icon.png";
const CreateUserComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Naujo vartotojo kūrimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame meniu galima kurti naujus vartotojus.
            </span>
          </div>
        </h2>
        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" alt="logo icon"/>
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
              <td scope="row">
                <h6>1</h6>
              </td>
              <td scope="row">
                <h6>Vardas</h6>
              </td>
              <td scope="row">
                <input
                  className=" form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojo vardą"
                  type="text"
                  onChange={props.onFirstNameChange}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>2</h6>
              </td>
              <td scope="row">
                <h6>Pavardė</h6>
              </td>

              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojo pavardę"
                  type="text"
                  onChange={props.onLastNameChange}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>3</h6>
              </td>
              <td scope="row">
                <h6>Unikalus vardas sistemoje</h6>
              </td>
              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite prisijungimo vardą"
                  type="text"
                  onChange={props.onUsernameChange}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>4</h6>
              </td>
              <td scope="row">
                <h6>Elektroninio pašto adresas</h6>
              </td>
              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojo el. pašto adresą"
                  type="email"
                  onChange={props.onEmailAddressChange}
                />
              </td>
            </tr>

            <tr>
              <td scope="row">
                <h6>5</h6>
              </td>
              <td scope="row">
                <h6>Įdarbinimo data</h6>
              </td>

              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojo įdarbinimo datą"
                  type="date"
                  onChange={props.onHireDateChange}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>6</h6>
              </td>
              <td scope="row">
                <h6>Prisijungimo slaptažodis</h6>
              </td>

              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojo prisijungimo slaptažodį"
                  type="password"
                  onChange={props.onPasswordChange}
                  required
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>7</h6>
              </td>
              <td scope="row">
                <h6>Administratoriaus rolė</h6>
              </td>

              <td scope="row">
                <select
                  onChange={props.onAdministratorChange}
                  className="col-6 form-control form-control-sm italic-style "
                  id="documentTypeSelect"
                >
                  <option value="false">Ne</option>
                  <option value="true">Taip</option>
                </select>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>8</h6>
              </td>
              <td scope="row">
                <h6>Vartotojo grupė</h6>
              </td>

              <td scope="row">
                <UserGroupsContainer
                  userGroups={props.userGroups}
                  onUserGroupChange={props.onUserGroupChange}
                />
                <span className="italic-style-small">
                  Pasirinktos grupės: {props.userGroupsTitles}
                </span>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6 />
              </td>
              <td scope="row">
                <h6 />
              </td>
              <td scope="row">
                <button
                  type="button"
                  className="btn btn-outline-success btn-sm document-button-style"
                  onClick={props.onSubmit}
                >
                  Kurti
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

export default CreateUserComponent;

{
  /* 

<div className="row mt-2 mb-2 ">
<div className="col ">
  Vardas
  <input
    type="text"
    className="form-control"
    placeholder="Įveskite vartotojo vardą"
    
    onChange={props.onFirstNameChange}
  />
</div>
<div className="col">
  <h5>Pavardė</h5>

  <input
    type="text"
    className="form-control"
    placeholder="Įveskite vartotojo pavardę"
    onChange={props.onLastNameChange}
  />
</div>
</div>{" "}
<div className="row mt-2 mb-2 ">
<div className="col ">
  <h5>Unikalus vardas sistemoje</h5>
  <input
    type="text"
    className="form-control"
    placeholder="Įveskite prisijungimo vardą"
    
    onChange={props.onUsernameChange}
  />
</div>
<div className="col">
  <h5>Elektroninoi pašto adresas</h5>

  <input
    type="email"
    className="form-control"
    placeholder="Įveskite vartotojo el. pašto adresą"
    onChange={props.onEmailAddressChange}
  />
</div>
</div>{" "}
<div className="row mt-2 mb-2 ">
<div className="col ">
  <h5>Įdarbinimo data</h5>
  <input
    type="date"
    className="form-control"
    placeholder="Įveskite vartotojo įdarbinimo datą"
    
    onChange={props.onHireDateChange}
  />
</div>
<div className="col">
  <h5>Prisijungimo slaptažodis</h5>

  <input
    type="password"
    className="form-control"
    placeholder="Įveskite vartotojo prisijungimo slaptažodį"
    onChange={props.onPasswordChange}
    required
  />
</div>
</div>
<div className="row mt-2 mb-2 ">
<div className="col ">
  <h5>Administratoriaus rolė</h5>
 

  <select
    onChange={props.onAdministratorChange}
    className="form-control "
    id="documentTypeSelect"
  >
    <option value="false">Ne</option>
    <option value="true">Taip</option>
  </select>
</div>
<div className="col">
  <h5>Vartotojo grupė</h5>

  <UserGroupsContainer
    userGroups={props.userGroups}
    onUserGroupChange={props.onUserGroupChange}
  />
  <span className="italic-style-small">
    Pasirinktos grupės: {props.userGroupsTitles}
  </span>
</div>
</div>

<button
onClick={props.onSubmit}
className="btn btn-outline-success m-2"
>
Kurti
</button>


*/
}
