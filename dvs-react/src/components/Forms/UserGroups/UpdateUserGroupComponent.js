import React from "react";

import DocumentTypesContainer from "../../FileUpload/DocumetTypesContainer";
import { Link } from "react-router-dom";
import infoIcon from "../../../images/info-icon.png";
import logo from "../../../images/home.png";

const UpdateUserGroupComponent = props => {
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
              <Link to={"/admin/usergroups"} className="second-navigation">
                Vartotojų grupės
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin/newusergroup"} className="second-navigation">
                Naujos vartotojų grupės kūrimas
              </Link>
            </h5>
            <h2 className="display-6 ">
              Naujos vartotojų grupės kūrimas
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima kurti naujas vartotojų grupes.
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
            <div className="col-5 documents-table-size">
              Vartotojų grupės pavadinimas
            </div>
            <div className="col-6 documents-table-size">
              <input
                className=" form-control form-control-sm italic-style"
                placeholder="Įveskite vartotojų grupės pavadinimą"
                type="text"
                onChange={props.onTitleChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">
              Pasirinkite pateikti leidžiamų dokumentų tipus
            </div>
            <div className="col-6 documents-table-size">
              <DocumentTypesContainer
                documentTypes={props.documentTypes}
                onDocumentTypeChange={props.onSubmitTypesChange}
              />

              <span className="italic-style-small">
                Pasirinkti pateikti leidžiami tipai:
                {props.selectedSubmissionTypesTitles}
              </span>
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">
              Pasirinkite peržiūrėti leidžiamų dokumentų tipus
            </div>
            <div className="col-6 documents-table-size">
              <DocumentTypesContainer
                documentTypes={props.documentTypes}
                onDocumentTypeChange={props.onReviewTypesChange}
              />
              <span className="italic-style-small">
                Pasirinkti leidžiami peržiūrėti tipai:{" "}
                {props.selectedReviewTypesTitles}
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

export default UpdateUserGroupComponent;
