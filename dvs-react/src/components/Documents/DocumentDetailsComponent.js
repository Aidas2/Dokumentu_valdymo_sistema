import React, { Component } from "react";
import PropTypes from "prop-types";
import logo from "../../images/home.png";
import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";

const DocumentDetailsComponent = props => {
  var {
    id,
    authorUsername,
    documentStateInLithuanian,
    documentTypeTitleInLithuanian,
    title,
    description,
    creationDate,
    submissionDate,
    confirmationDate,
    rejectionDate,
    reviewer,
    rejectionReason,
    path
  } = props.documentDetails;

  var linkToIndividualDocumentDetails = "/admin/docs/" + id;

  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          {title}
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" />
            <span class="tooltiptext">
              Šiame lange yra pateikta vartotojo informacija.
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
          <Link to={"/admin/docs"} className="second-navigation">
            Dokumentai
          </Link>
          &ensp;/ &ensp;
          <Link
            to={linkToIndividualDocumentDetails}
            className="second-navigation"
          >
            {title}
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
              <td scope="row">
                <h6>1</h6>
              </td>
              <td scope="row">
                <h6>Pavadinimas</h6>
              </td>
              <td scope="row">
                <h6>{title}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>2</h6>
              </td>
              <td scope="row">
                <h6>Autorius</h6>
              </td>
              <td scope="row">
                <h6>{authorUsername}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>3</h6>
              </td>
              <td scope="row">
                <h6>Tipas</h6>
              </td>
              <td scope="row">
                <h6>{documentTypeTitleInLithuanian}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>4</h6>
              </td>
              <td scope="row">
                <h6>Aprašymas</h6>
              </td>
              <td scope="row">
                <h6>{description}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>5</h6>
              </td>
              <td scope="row">
                <h6>Būsena</h6>
              </td>
              <td scope="row">
                <h6>{documentStateInLithuanian}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>6</h6>
              </td>
              <td scope="row">
                <h6>Sukūrimo data</h6>
              </td>
              <td scope="row">
                <h6>{creationDate}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>7</h6>
              </td>
              <td scope="row">
                <h6>Peržiūrėjo</h6>
              </td>
              <td scope="row">
                <h6>{reviewer}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>8</h6>
              </td>
              <td scope="row">
                <h6>Priėmimo data</h6>
              </td>
              <td scope="row">
                <h6>{confirmationDate}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>9</h6>
              </td>
              <td scope="row">
                <h6>Atmetimo priežastis</h6>
              </td>
              <td scope="row">
                <h6>{rejectionReason}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>10</h6>
              </td>
              <td scope="row">
                <h6>Atmetimo data</h6>
              </td>
              <td scope="row">
                <h6>{rejectionDate}</h6>
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>11</h6>
              </td>
              <td scope="row">
                <h6>Priedai</h6>
              </td>
              <td scope="row">
                <h6>{}</h6>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default DocumentDetailsComponent;

{
  /****************************
<div className="container-fluid m-2">
        <h6 className="display-6 normal-padding" />
        <h5 className="display-6 normal-padding gray-collor ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="explorer">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/docs"} className="explorer">
            Dokumentai
          </Link>
          &ensp;/ &ensp;
         
        </h5>
        <h3 className="display-6 ">
          Dokumento &nbsp;"
          <strong>{title}"&nbsp;</strong>
          Informacija
        </h3>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Pavadinimas</h5>
            <h4>{title}</h4>
          </div>
          <div className="col">
            <h5>Autorius</h5>
            <h4>{authorUsername} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Tipas</h5>
            <h4>{documentTypeTitleInLithuanian}</h4>
          </div>
          <div className="col">
            <h5>Aprašymas</h5>
            <h4>{description} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Būsena</h5>
            <h4>{documentStateInLithuanian}</h4>
          </div>
          <div className="col">
            <h5 />
            <h4>{} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Sukūrimo data</h5>
            <h4>{creationDate}</h4>
          </div>
          <div className="col">
            <h5>Peržiūrėjo</h5>
            <h4>{reviewer} </h4>
          </div>
        </div>

        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Priėmimo data</h5>
            <h4>{confirmationDate}</h4>
          </div>
          <div className="col">
            <h5>Atmetimo priežastis</h5>
            <h4>{rejectionReason} </h4>
          </div>
        </div>
        <div className="row mt-2 mb-2 ">
          <div className="col ">
            <h5>Atmetimo data</h5>
            <h4>{rejectionDate}</h4>
          </div>
          <div className="col">
            <h5>Priedai</h5>
            <h4>{} </h4>
          </div>
        </div>
      </div>
       */
}
