import React, { Component } from "react";
import DocumentsComponent from "./DocumentsComponent";
import { Link } from "react-router-dom";
import axios from "axios";

class DocumentsContainer extends Component {
  state = {
    documents: [
      {
        id: "",
        author: "",
        documentState: "",
        documentType: "",
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
  render() {
    var documentsArrayToRender = this.state.documents.map(oneDocumentObj => {
      return (
        <DocumentsComponent
          key={oneDocumentObj.id}
          userDetails={oneDocumentObj}
        />
      );
    });
    return (
      <div>
        <div className="container-fluid m-2 ">
          <h3 className="display-6">Dokumentai</h3>
          <Link to={"/upload"} className="btn btn-warning mb-2">
            Įketi naują dokumentą
          </Link>
          <div className="container pl-0 ml-0">
            <h4 className="display-6">Esami dokumentai</h4>

            <div className="row">
              <div className="col-2">
                <p>
                  {" "}
                  <strong>Dokumento ID</strong>
                </p>
                {/* <Link to="">Linkas</Link> */}
              </div>
              <div className="col-2">
                <p>
                  <strong>Prisijungimo vardas</strong>
                </p>
              </div>{" "}
              <div className="col-2">
                <p>
                  <strong>Vardas</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>Pavardė</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>El. pašto adresas</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>Įdarbinimo data</strong>
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
