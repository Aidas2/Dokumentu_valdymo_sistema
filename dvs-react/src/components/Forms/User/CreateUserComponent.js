import React from "react";

import logo from "../../../images/home.png";
import { Link } from "react-router-dom";
import UserGroupsContainer from "./UserGroupsContainer";
import infoIcon from "../../../images/info-icon.png";
const CreateUserComponent = props => {
  return (
    <div>
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
                  alt=" "
                />
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
            <h2 className="display-6 ">
              Naujo vartotojo kūrimas
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima kurti naujus vartotojus.
                </span>
              </div>
            </h2>
          </div>
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">
              Lauko pavadinimas
            </div>
            <div className=" col-6 users-table-action-style">
              Įvedimo laukas
            </div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">Vardas</div>
            <div className="col-6 documents-table-size">
              <input
                className=" form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojo vardą"
                type="text"
                onChange={props.onFirstNameChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">Pavardė</div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojo pavardę"
                type="text"
                onChange={props.onLastNameChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">
              Unikalus vardas sistemoje
            </div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite prisijungimo vardą"
                type="text"
                onChange={props.onUsernameChange}
              />
            </div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">
              Elektroninio pašto adresas
            </div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojo el. pašto adresą"
                type="email"
                onChange={props.onEmailAddressChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">5</div>
            <div className="col-5 documents-table-size">Įdarbinimo data</div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojo įdarbinimo datą"
                type="date"
                onChange={props.onHireDateChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">6</div>
            <div className="col-5 documents-table-size">
              Prisijungimo slaptažodis
            </div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojo prisijungimo slaptažodį"
                type="password"
                onChange={props.onPasswordChange}
                required
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">7</div>
            <div className="col-5 documents-table-size">
              Administratoriaus rolė
            </div>
            <div className="col-6 documents-table-size">
              <select
                onChange={props.onAdministratorChange}
                className="col-6 form-control form-control-sm italic-style pop-up-style-admin"
                id="documentTypeSelect"
                multiple
              >
                <option value="false">Ne</option>
                <option value="true">Taip</option>
              </select>
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">8</div>
            <div className="col-5 documents-table-size">Vartotojo grupės</div>
            <div className="col-6 documents-table-size">
              <UserGroupsContainer
                userGroups={props.userGroups}
                onUserGroupChange={props.onUserGroupChange}
              />
              <span className="italic-style-small">
                Pasirinktos grupės: {props.userGroupsTitles}
              </span>
            </div>
          </div>
          <div className="row ">
            <div className="col-1 " />
            <div className="col-5 " />
            <div className="col-6 ">
              <button
                type="button"
                className="btn btn-outline-success btn-sm document-button-style button-color"
                onClick={props.onSubmit}
              >
                Kurti
              </button>
            </div>
          </div>
        </div>
      </div>

      <div className="container">{props.launchAlert}</div>
    </div>
  );
};

export default CreateUserComponent;
