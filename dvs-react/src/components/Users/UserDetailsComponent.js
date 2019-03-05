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

  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          {username}
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame lange yra pateikta vartotojo informacija.
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
          <Link to={linkToIndividualUserDetails} className="second-navigation">
            {username}
          </Link>
        </h5>

        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th scope="col-1">#</th>
              <th scope="col-5">Parametras</th>
              <th scope="col-6">Reikšmė</th>
            </tr>
            <tr>
              <td>
                <h6>1</h6>
              </td>
              <td>
                <h6>Vardas</h6>
              </td>
              <td>
                <h6>{firstName}</h6>
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
                <h6>{lastName}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Unikalus vardas sistemoje</h6>
              </td>
              <td>
                <h6>{username}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>4</h6>
              </td>
              <td>
                <h6>Elektroninio pašto adresas</h6>
              </td>
              <td>
                <h6>{emailAddress}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>5</h6>
              </td>
              <td>
                <h6>Įdarbinimo data</h6>
              </td>
              <td>
                <h6>{hireDate}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>6</h6>
              </td>
              <td>
                <h6>Ar šis klientas turi dministratoriaus rolę?</h6>
              </td>
              <td>
                <h6>{administrator}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>7</h6>
              </td>
              <td>
                <h6>Vartotojo grupės</h6>
              </td>
              <td>
                <h6 className="list-style">{props.userGroups}</h6>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserDetailsComponent;
