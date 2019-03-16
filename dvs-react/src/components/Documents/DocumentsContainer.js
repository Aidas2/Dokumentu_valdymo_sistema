import React, { Component } from "react";
import DocumentsComponent from "./DocumentsComponent";
import { Link } from "react-router-dom";
import axios from "axios";

import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";

class DocumentsContainer extends Component {
  state = {
    documents: [
      {
        id: "",
        author: "",
        documentStateInLithuanian: "",
        documentTypeTitleInLithuanian: "",
        title: "",
        description: "",
        creationDate: "",
        submissionDate: "",
        confirmationDate: "",
        rejectionDate: "",
        reviewer: "",
        rejectionReason: "",
        path: ""
      }
    ]
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/docs")
      .then(response => {
        this.setState({ documents: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleDocumentDownload = () => {};
  handleDocumentView = () => {};
  render() {
    var documentsArrayToRender = this.state.documents.map(
      (oneDocumentObj, index) => {
        return (
          <DocumentsComponent
            key={oneDocumentObj.id}
            documentDetails={oneDocumentObj}
            index={index + 1}
            // onDocumentDownload={this.handleDocumentDownload}
            // onDocumentView={this.handleDocumentView}
          />
        );
      }
    );
    return (
      <div className="container-fluid no-padding">
        <div className="row justify-content-between no-padding ">
          <div className=" col-6  normal-padding">
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
            </h5>
            <h2 className="display-6 ">
              Dokumentai
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu galima įkelti naujus dokumentus ir peržiūrėti jau
                  esamus dokumentus.
                </span>
              </div>
            </h2>
          </div>
          <div className=" col-6  normal-padding left-align ">
            <Link
              to={"/upload"}
              className="btn btn-outline-success m-2 button-color "
            >
              Įketi naują dokumentą
            </Link>
          </div>
        </div>

        {/* <div className="table table-color-style table-style-rounded"> */}
        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-2  users-table-middle-style ">Pavadinimas</div>
            <div className=" col-2 users-table-middle-style">Tipas</div>
            <div className="col-2    users-table-middle-style ">Būsena</div>
            <div className="col-2  users-table-middle-style">Aprašymas</div>
            <div className="col-3  users-table-action-style ">Veiksmai</div>
            {/* <div className="row table-color-style table-style-rounded ">
              <div className="col-1  users-table-number-style ">#</div>
              <div className="col-2   users-table-middle-style">
                Pavadinimas
              </div>
              <div className=" col-2 users-table-middle-style">Tipas</div>
              <div className="col-2   users-table-middle-style ">Būsena</div>
              <div className="col-2  users-table-middle-style ">Aprašymas</div>
              <div className="col-3   users-table-action-style ">Veiksmai</div> */}
          </div>
          <div className="">{documentsArrayToRender}</div>
        </div>
      </div>

      // </div>
    );
  }
}

export default DocumentsContainer;
