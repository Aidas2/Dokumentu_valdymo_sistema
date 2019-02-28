import React, { Component } from "react";
import DocumentsComponent from "./DocumentsComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";

class DocumentsContainer extends Component {
  state = {
    documents: [
      {
        id: 1,
        author: "username1",
        documentState: "state",
        documentTypeTitle: "type",
        title: "title",
        description: "desc",
        creationDate: "creationData",
        submissionDate: "submissionDate",
        confirmationDate: "confirmationDate",
        rejectionDate: "rejectionDate",
        reviewer: "reviewer",
        rejectionReason: "rejectionReason",
        path: "path"
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
          <h6 className="display-6 normal-padding">Dokumentai</h6>
          <h5 className="display-6 normal-padding gray-collor ">
            <Link to={"/"}>
              <img src={logo} width="20" height="10" />
            </Link>
            &ensp;/ &ensp;
            <Link to={"/docs"} className="explorer">
              Dokumentai
            </Link>
          </h5>

          <Link to={"/upload"} className="btn btn-outline-success m-2">
            Įketi naują dokumentą
          </Link>
          <div className="container pl-0 ml-0">
            <h4 className="display-6">Esami dokumentai</h4>

            <div className="row">
              <div className="col-1 ">
                <p>
                  <strong>ID</strong>
                </p>
                {/* <Link to="">Linkas</Link> */}
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
        </div>
      </div>
    );
  }
}

export default DocumentsContainer;
