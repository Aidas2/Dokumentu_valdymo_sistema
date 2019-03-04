import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import infoIcon from "../../../images/info-icon.png";
import logo from "../../../images/home.png";
const CreateDocumentTypeComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Naujo dokumento tipo kūrimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" />
            <span class="tooltiptext">
              Šiame meniu galima kurti naujus dokumentų tipus.
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
          <Link to={"/admin/doctypes"} className="second-navigation">
            Dokumentų tipai
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/newdoctype"} className="second-navigation">
            Naujo dokumento tipo kūrimas
          </Link>
        </h5>

        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th scope="col-2">#</th>
              <th scope="col-5">Parametrai</th>
              <th scope="col-3">Veiksmai</th>
            </tr>
            <tr>
              <td scope="row">
                <h6>1</h6>
              </td>
              <td scope="row">
                <h6>Dokumento tipo pavadinimas</h6>
              </td>
              <td scope="row">
                <input
                  onChange={props.onTitleChange}
                  className="form-control form-control-sm italic-style"
                  type="text"
                  placeholder="Įveskite dokumento tipo pavadinimą"
                />
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

export default CreateDocumentTypeComponent;
