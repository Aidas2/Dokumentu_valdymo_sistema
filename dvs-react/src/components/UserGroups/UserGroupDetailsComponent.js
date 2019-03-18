import React from "react";

import logo from "../../images/home.png";
import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";

const UserGroupDetailsComponent = props => {
  var { title, submissionDocTypes, reviewDocTypes } = props;

  var linkToUserGroupDetails = "/admin/usergroups/" + title;
  const linkToIndividualGroupUpdateContainer = "/admin/updategroup/" + title;

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
                  alt=" "
                />
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
            <h2 className="display-6 ">
              {title}
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima peržiūrėti vartotojų grupės leidžiamų
                  pateikti ir peržiūrėti dokumentų tipus.
                </span>
              </div>
            </h2>
          </div>

          <div className=" col-4  normal-padding left-align ">
            <Link
              to={linkToIndividualGroupUpdateContainer}
              className="btn btn-outline-success m-2 button-color "
            >
              Redaguoti grupę
            </Link>
          </div>
        </div>
        <div>
          <div className="container-fluid">
            <div className="row users-padding-bottom table-style-rounded">
              <div className="col-6 users-table-number-style  ">
                Pateikti leidžiamų dokumentų tipai
              </div>
              <div className="col-6   users-table-action-style">
                Peržiūrėti leidžiamų dokumentų tipai
              </div>
            </div>
            <div className="row users-padding-bottom">
              <div className="col-6 documents-table-size list-style">
                {submissionDocTypes}
              </div>
              <div className="col-6 documents-table-size list-style">
                {reviewDocTypes}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserGroupDetailsComponent;
