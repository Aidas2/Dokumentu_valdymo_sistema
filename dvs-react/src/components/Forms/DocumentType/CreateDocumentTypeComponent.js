import React from "react";

import { Link } from "react-router-dom";
import infoIcon from "../../../images/info-icon.png";
import logo from "../../../images/home.png";
const CreateDocumentTypeComponent = props => {
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
                  alt="logo icon"
                />
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin"} className="second-navigation">
                Administratoriaus rolė
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin/doctypes"} className="second-navigation">
                Dokumentų tipai
              </Link>
              &ensp;/ &ensp;
              <Link to={"/admin/newdoctype"} className="second-navigation">
                Naujo dokumento tipo kūrimas
              </Link>
            </h5>
            <h2 className="display-6 ">
              Naujo dokumento tipo kūrimas
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima kurti naujus dokumentų tipus.
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
              Dokumento tipo pavadinimas
            </div>
            <div className="col-6 documents-table-size">
              <input
                onChange={props.onTitleChange}
                className="form-control form-control-sm italic-style"
                type="text"
                placeholder="Įveskite dokumento tipo pavadinimą"
              />
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

export default CreateDocumentTypeComponent;
