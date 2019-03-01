import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesComponent from "./DocumentTypesComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";

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
    var docTypesArrayToRenderId = this.state.docTypes.map(oneTypeObj => {
      return (
        <DocumentTypesComponent key={oneTypeObj.id} typeId={oneTypeObj.id} />
      );
    });

    var docTypesArrayToRenderTitle = this.state.docTypes.map(oneTypeObj => {
      return (
        <DocumentTypesComponent key={oneTypeObj.id} typeId={oneTypeObj.title} />
      );
    });

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h2 className="display-6 normal-padding">Dokumentų tipai</h2>

          <h5 className="display-6 normal-padding gray-collor ">
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
          </h5>

          {/*  <h3 className="display-6">Dokumentų tipai</h3> */}
          <Link
            to={"/admin/newdoctype/"}
            className="btn btn-outline-success m-2"
          >
            Kurti naują dokumento tipą
          </Link>
          <table class="table table-active">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Dokumento tipo pavadinimas</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"> {docTypesArrayToRenderId}</th>
                <td>{docTypesArrayToRenderTitle}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
