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
    var documentsArrayToRender = this.state.documents.map(oneDocumentObj => {
      return (
        <DocumentsComponent
          key={oneDocumentObj.id}
          documentDetails={oneDocumentObj}
          // onDocumentDownload={this.handleDocumentDownload}
          // onDocumentView={this.handleDocumentView}
        />
      );
    });
    return (
      <div>
        <div className="container-fluid m-2 ">
          <h2 className="display-6 normal-padding">
            Dokumentai
            <div className="logo-info">
              <img src={infoIcon} className="info-icon-style" alt="info icon" />
              <span className="tooltiptext">
                Šiame meniu galima įkelti naujus dokumentus ir peržiūrėti jau
                esamus dokumentus.
              </span>
            </div>
          </h2>
          <h5 className="display-6 normal-padding second-navigation-style ">
            <Link to={"/"}>
              <img src={logo} width="20" height="10" alt="logo icon"/>
            </Link>
            &ensp;/ &ensp;
            <Link to={"/docs"} className="second-navigation">
              Dokumentai
            </Link>
          </h5>

          <Link to={"/upload"} className="btn btn-outline-success m-2">
            Įketi naują dokumentą
          </Link>

          <p />
          <input type="checkbox" id="Document-type-box" />

          <label id="Document-type-container" htmlFor="Document-type-box">
            <div id="button" className="collapsed-style">
              Paspauskite ant šio teksto, tam kad būtų galima peržiūrėti/
              paslėpti dokumentus:
              <ul id="Document-type-bar-appear" className="navbar-nav mr-auto">
                <table className="table table-active table-style-rounded">
                  <div className="container-fluid users-padding-bottom">
                    <div className="row table-active table-style-rounded ">
                      <div className="col-1  users-table-number-style ">ID</div>
                      <div className="col-2   users-table-middle-style">
                        Pavadinimas
                      </div>
                      <div className=" col-2 users-table-middle-style">
                        Tipas
                      </div>
                      <div className="col-2   users-table-middle-style ">
                        Būsena
                      </div>
                      <div className="col-3  users-table-middle-style ">
                        Aprašymas
                      </div>
                      <div className="col-2   users-table-action-style ">
                        Veiksmai
                      </div>
                    </div>
                    {documentsArrayToRender}
                  </div>
                </table>
              </ul>
            </div>
          </label>
        </div>
      </div>
    );
  }
}

export default DocumentsContainer;

{
  /*

          <div className="container pl-0 ml-0">
            <h4 className="display-6">Esami dokumentai</h4>

            <div className="row">
              <div className="col-1 ">
                <p>
                  <strong>ID</strong>
                </p>
               
              </div>
              <div className="col-2 ">
                <p>
                  <strong>Pavadinimas</strong>
                </p>
              </div>{" "}
              <div className="col-2 ">
                <p>
                  <strong>Tipas</strong>
                </p>
              </div>
              <div className="col-2 ">
                <p>
                  <strong>Būsena</strong>
                </p>
              </div>
              <div className="col-2 ">
                <p>
                  <strong>Aprašymas</strong>
                </p>
              </div>
            </div>
          </div>
          {documentsArrayToRender}
          */
}
