import React from "react";

import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";
import { Link } from "react-router-dom";

const UserDetailsComponent = props => {
  var {
    administrator,
    emailAddress,
    firstName,
    hireDate,
    lastName,
    username
    // userGroups
  } = props.userDetails;

  var linkToIndividualUserDetails = "/admin/users/" + username;
  const linkToIndividualUsserUpdateContainer = "/admin/updateuser/" + username;

  return (
    <div>
      <div className="container-fluid no-padding">
        <div className="row justify-content-between no-padding ">
          <div className=" col-8  normal-padding">
            <h5 className="display-6  second-navigation-style ">
              <Link to={"/"}>
                <img
                  className="logo-color"
                  src={logo}
                  width="40"
                  height="20"
                  alt="logo icon"
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
              <Link
                to={linkToIndividualUserDetails}
                className="second-navigation"
              >
                {username}
              </Link>
            </h5>
            <h2 className="display-6 ">
              {username}
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame lange yra pateikta vartotojo informacija.
                </span>
              </div>
            </h2>
          </div>
          <div className=" col-4  normal-padding left-align ">
            <Link
              to={linkToIndividualUsserUpdateContainer}
              className="btn btn-outline-success m-2 button-color "
            >
              Redaguoti vartotoją
            </Link>
          </div>
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">Parametras</div>
            <div className=" col-6 users-table-action-style">Reikšmė</div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">Vardas</div>
            <div className="col-6 documents-table-size">{firstName}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">Pavardė</div>
            <div className="col-6 documents-table-size">{lastName}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">
              Unikalus vardas sistemoje
            </div>
            <div className="col-6 documents-table-size">{username}</div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">
              Elektroninio pašto adresas
            </div>
            <div className="col-6 documents-table-size">{emailAddress}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">5</div>
            <div className="col-5 documents-table-size">Įdarbinimo data</div>
            <div className="col-6 documents-table-size">{hireDate}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">6</div>
            <div className="col-5 documents-table-size">
              Ar šis klientas turi administratoriaus rolę
            </div>
            <div className="col-6 documents-table-size">{administrator}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">7</div>
            <div className="col-5 documents-table-size">Vartotojo grupės</div>
            <div className="col-6 documents-table-size list-style">
              {props.userGroups}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserDetailsComponent;
