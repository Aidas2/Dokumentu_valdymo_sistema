import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesContainer from "../FileUpload/DocumetTypesContainer";
import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";
import logo from "../../images/home.png";

const CreateUserGroupsComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Naujos vartotojų grupės kūrimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame meniu galima kurti naujas vartotojų grupes.
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
          <Link to={"/admin/usergroups"} className="second-navigation">
            Vartotojų grupės
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/usergroups/new"} className="second-navigation">
            Naujos vartotojų grupės kūrimas
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
                <h6>Vartotojų grupės pavadinimas</h6>
              </td>
              <td>
                <input
                  className=" form-control form-control-sm italic-style"
                  placeholder="Įveskite vartotojų grupės pavadinimą"
                  type="text"
                  onChange={props.onTitleChange}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>2</h6>
              </td>
              <td>
                <h6>Pasirinkite pateikti leidžiamų dokumentų tipus</h6>
              </td>

              <td>
                <DocumentTypesContainer
                  documentTypes={props.documentTypes}
                  onDocumentTypeChange={props.onSubmitTypesChange}
                />

                <span className="italic-style-small">
                  Pasirinkti pateikti leidžiami tipai:
                  {props.selectedSubmissionTypesTitles}
                </span>
              </td>
            </tr>
            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Pasirinkite peržiūrėti leidžiamų dokumentų tipus</h6>
              </td>
              <td>
                <DocumentTypesContainer
                  documentTypes={props.documentTypes}
                  onDocumentTypeChange={props.onReviewTypesChange}
                />
                <span className="italic-style-small">
                  Pasirinkti leidžiami peržiūrėti tipai:{" "}
                  {props.selectedReviewTypesTitles}
                </span>
              </td>
            </tr>

            <tr>
              <td>
                <h6 />
              </td>
              <td>
                <h6 />
              </td>
              <td>
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

export default CreateUserGroupsComponent;

{
  /*
 <h5>Vartotojų grupės pavadinimas</h5>
        <input
          onChange={props.onTitleChange}
          className="form-control col-4"
          type="text"
          placeholder="Įveskite vartotojų grupės pavadinimą"
        />
        <h6>Pasirinkite pateikti leidžiamų dokumentų tipus</h6>
        <DocumentTypesContainer
          documentTypes={props.documentTypes}
          onDocumentTypeChange={props.onSubmitTypesChange}
        />
        <span className="italic-style-small">
          Pasirinkti pateikti leidžiami tipai:{" "}
          {props.selectedSubmissionTypesTitles}
        </span>
        <h6>Pasirinkite peržiūrėti leidžiamų dokumentų tipus</h6>
        <DocumentTypesContainer
          documentTypes={props.documentTypes}
          onDocumentTypeChange={props.onReviewTypesChange}
        />
        <span className="italic-style-small">
          Pasirinkti leidžiami peržiūrėti tipai:{" "}
          {props.selectedReviewTypesTitles}
        </span>
        <br />
        <button
          onClick={props.onSubmit}
          className="btn btn-outline-success m-2"
        >
          Kurti
        </button>
*/
}
