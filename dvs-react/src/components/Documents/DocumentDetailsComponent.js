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
    reviewerUsername,
    rejectionReason
    //path
  } = props.documentDetails;

  var linkToIndividualDocumentDetails = "/admin/docs/" + id;

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
              <Link to={"/docs"} className="second-navigation">
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
            <h2 className="display-6 ">
              {title}
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima peržiūrėti, patvirtinti arba atmesti
                  pateiktus dokumentus.
                </span>
              </div>
            </h2>
          </div>
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">Parametras</div>

            <div className="col-6  users-table-action-style ">Reikšmė</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">Pavadinimas</div>
            <div className="col-6 documents-table-size">{title}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">Autorius</div>
            <div className="col-6 documents-table-size">{authorUsername}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">Tipas</div>
            <div className="col-6 documents-table-size">
              {documentTypeTitleInLithuanian}
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">Aprašymas</div>
            <div className="col-6 documents-table-size">{description}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">5</div>
            <div className="col-5 documents-table-size">Būsena</div>
            <div className="col-6 documents-table-size">
              {documentStateInLithuanian}
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">6</div>
            <div className="col-5 documents-table-size">Sukūrimo data</div>
            <div className="col-6 documents-table-size">{creationDate}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">7</div>
            <div className="col-5 documents-table-size">Peržiūrėjo</div>
            <div className="col-6 documents-table-size">{reviewerUsername}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">8</div>
            <div className="col-5 documents-table-size">Priėmimo data</div>
            <div className="col-6 documents-table-size">{confirmationDate}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">9</div>
            <div className="col-5 documents-table-size">
              Atmetimo priežastis
            </div>
            <div className="col-6 documents-table-size">{rejectionReason}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">10</div>
            <div className="col-5 documents-table-size">Atmetimo data</div>
            <div className="col-6 documents-table-size">{rejectionDate}</div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">11</div>
            <div className="col-5 documents-table-size">Priedai</div>
            <div className="col-6 documents-table-size" />
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">12</div>
            <div className="col-5 documents-table-size">Dokumentas</div>
            <div className="col-6 documents-table-size">
              <FileViewContainer documentId={id} />
              &ensp;
              <FileDownloadConatainer documentId={id} />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size" />
            <div className="col-5 documents-table-size">
              <button
                onClick={props.onSubmitDocument}
                className="btn btn-warning "
              >
                Pateikti
              </button>
              &ensp;
              <button
                onClick={props.onAcceptDocument}
                className="btn btn-success"
              >
                Priimti
              </button>
              &ensp;
              <button
                onClick={props.onRejectDocument}
                className="btn btn-danger "
              >
                Atmesti
              </button>
              &ensp;
            </div>
            <div className="col-6 documents-table-size">
              <div>
                Atmetimo priežastis&ensp;
                <br />
                <textarea
                  // rows="3"
                  onChange={props.onRejectionReasonChange}
                  type="textarea"
                  placeholder="Įveskite atmetimo priežastį"
                  className=" form-control form-control-sm italic-style"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DocumentDetailsComponent;
