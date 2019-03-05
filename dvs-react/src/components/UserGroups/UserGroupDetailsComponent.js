import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";

const UserGroupDetailsComponent = props => {
  var { title, submissionDocTypes, reviewDocTypes } = props;

  var linkToUserGroupDetails = "/admin/usergroups/" + title;
  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          {title}
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" />
            <span className="tooltiptext">
              Šiame meniu galima peržiūrėti vartotojų grupės leidžiamų pateikti
              ir peržiūrėti dokumentų tipus.
            </span>
          </div>
        </h2>
        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="second-navigation">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/usergroups"} className="second-navigation">
            Vartotojų grupės
          </Link>
          &ensp; / &ensp;
          <Link to={linkToUserGroupDetails} className="second-navigation">
            {title}
          </Link>
          {/*/ &ensp;
           <Link to={"/admin/newuser"} className="second-navigation">
            Naujo vartotojo kūrimas
          </Link> */}
        </h5>

        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th scope="col-6">Pateikti leidžiamų dokumentų tipai</th>
              <th scope="col-6">Peržiūrėti leidžiamų dokumentų tipai</th>
            </tr>
            <tr>
              <td scope="row" className="list-style ">
                <h6>{submissionDocTypes}</h6>
              </td>
              <td scope="row" className="list-style ">
                <h6>{reviewDocTypes}</h6>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserGroupDetailsComponent;

{
  /* 
<h3 className="display-6 ">
          Vartotojų grupėssss &nbsp;"
          <strong>{title}"&nbsp;</strong>
          inforamcija
        </h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Pateikti leidžiamų dokumentų tipai</h5>
            <h4>{submissionDocTypes}</h4>
          </div>
          <div className="col">
            <h5>Peržiūrėti leidžiamų dokumentų tipai</h5>
            <h4>{reviewDocTypes} </h4>
          </div>
        </div>
*/
}
