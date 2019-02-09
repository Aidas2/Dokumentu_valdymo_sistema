import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesComponent from "./DocumentTypesComponent";
import { Link } from "react-router-dom";
import axios from "axios";

class DocumentTypesContainer extends Component {
  state = {
    docTypes: []
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/doctypes")
      .then(response => {
        this.setState({ docTypes: response.data });
      })
      .catch(error => {
        console.log(error);
      });
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.docTypes>>>>.",
      this.state.docTypes
    );
  }

  render() {
    var docTypesArrayToRender = this.state.docTypes.map(oneTypeObj => {
      return (
        <DocumentTypesComponent
          key={oneTypeObj.id}
          typeId={oneTypeObj.id}
          typeTitle={oneTypeObj.title}
        />
      );
    });

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h3 className="display-6">Dokumentų tipai</h3>
          <Link to={"/admin/newdoctype/"} className="btn btn-warning mb-2">
            Kurti naują dokumento tipą
          </Link>
          <div className="container pl-0 ml-0">
            <div className="row">
              <div className="col-2">
                <p> Dokumento tipo ID</p>
                {/* <Link to="">Linkas</Link> */}
              </div>

              <div className="col-3">
                <p>Dokumento tipo pavadinimas</p>
              </div>
            </div>
          </div>
          {docTypesArrayToRender}
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
