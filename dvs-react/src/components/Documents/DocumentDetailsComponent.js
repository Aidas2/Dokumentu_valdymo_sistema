import React from "react";

import logo from "../../images/home.png";
import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";
import FileDownloadConatainer from "../FileDownload/FileDownloadContainer";
import FileViewContainer from "../FileDownload/FileViewContainer";

const DocumentDetailsComponent = props => {
  var {
    id,
    authorUsername,
    documentStateInLithuanian,
    documentTypeTitleInLithuanian,
    title,
    description,
    creationDate,
    //submissionDate,
    confirmationDate,
    rejectionDate,
    reviewer,
    rejectionReason
    //path
  } = props.documentDetails;

  var linkToIndividualDocumentDetails = "/admin/docs/" + id;

  return (
    <div>
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          {title}
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
              <td>
                <h6>1</h6>
              </td>
              <td>
                <h6>Pavadinimas</h6>
              </td>
              <td>
                <h6>{title}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>2</h6>
              </td>
              <td>
                <h6>Autorius</h6>
              </td>
              <td>
                <h6>{authorUsername}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Tipas</h6>
              </td>
              <td>
                <h6>{documentTypeTitleInLithuanian}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>4</h6>
              </td>
              <td>
                <h6>Aprašymas</h6>
              </td>
              <td>
                <h6>{description}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>5</h6>
              </td>
              <td>
                <h6>Būsena</h6>
              </td>
              <td>
                <h6>{documentStateInLithuanian}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>6</h6>
              </td>
              <td>
                <h6>Sukūrimo data</h6>
              </td>
              <td>
                <h6>{creationDate}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>7</h6>
              </td>
              <td>
                <h6>Peržiūrėjo</h6>
              </td>
              <td>
                <h6>{reviewer}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>8</h6>
              </td>
              <td>
                <h6>Priėmimo data</h6>
              </td>
              <td>
                <h6>{confirmationDate}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>9</h6>
              </td>
              <td>
                <h6>Atmetimo priežastis</h6>
              </td>
              <td>
                <h6>{rejectionReason}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>10</h6>
              </td>
              <td>
                <h6>Atmetimo data</h6>
              </td>
              <td>
                <h6>{rejectionDate}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>11</h6>
              </td>
              <td>
                <h6>Priedai</h6>
              </td>
              <td>
                <h6>{}</h6>
              </td>
            </tr>
            <tr>
              <td>
                <h6>
                  <FileViewContainer documentId={id} />
                  &ensp;
                  <FileDownloadConatainer documentId={id} />
                </h6>
              </td>
              <td>
                <h6>
                  <button
                    onClick={props.onAcceptDocument}
                    className="btn btn-success "
                  >
                    Priimti
                  </button>
                  &ensp;
                  <button
                    onClick={props.onRejectDocument}
                    className="btn btn-danger"
                  >
                    Atmesti
                  </button>
                  &ensp;
                </h6>
              </td>
              <td>
                <h6>
                  <div>
                    Atmetimo priežastis&ensp;
                    <br />
                    <textarea
                      // rows="3"
                      onChange={props.onRejectionReasonChange}
                      type="textarea"
                      style={{ width: "700px", height: "50px" }}
                      placeholder="Įveskite atmetimo priežastį"
                    />
                  </div>
                </h6>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default DocumentDetailsComponent;
