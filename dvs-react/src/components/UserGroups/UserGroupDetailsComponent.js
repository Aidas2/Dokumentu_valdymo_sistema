import React from "react";

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
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame meniu galima peržiūrėti vartotojų grupės leidžiamų pateikti
              ir peržiūrėti dokumentų tipus.
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
          <Link to={"/admin/usergroups"} className="second-navigation">
            Vartotojų grupės
          </Link>
          &ensp; / &ensp;
          <Link to={linkToUserGroupDetails} className="second-navigation">
            {title}
          </Link>
        </h5>

        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th scope="col-6">Pateikti leidžiamų dokumentų tipai</th>
              <th scope="col-6">Peržiūrėti leidžiamų dokumentų tipai</th>
            </tr>
            <tr>
              <td className="list-style ">
                <h6>{submissionDocTypes}</h6>
              </td>
              <td className="list-style ">
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
