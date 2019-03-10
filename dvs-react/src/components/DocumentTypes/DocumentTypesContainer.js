import React, { Component } from "react";

import DocumentTypesComponent from "./DocumentTypesComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";

import infoIcon from "../../images/info-icon.png";

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
    var docTypesArrayToRenderId = this.state.docTypes.map(
      (oneTypeObj, index) => {
        return (
          <DocumentTypesComponent key={oneTypeObj.id} typeId={index + 1} />
        );
      }
    );

    var docTypesArrayToRenderTitle = this.state.docTypes.map(oneTypeObj => {
      return (
        <DocumentTypesComponent key={oneTypeObj.id} typeId={oneTypeObj.title} />
      );
    });

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h2 className="display-6 normal-padding">
            Dokumentų tipai
            <div className="logo-info">
              <img src={infoIcon} className="info-icon-style" alt="info icon" />
              <span className="tooltiptext">
                Šiame meniu galima sukurti ir peržiūrėti dokumentų tipus.
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
            <Link to={"/admin/doctypes"} className="second-navigation">
              Dokumentų tipai
            </Link>
          </h5>

          <Link
            to={"/admin/newdoctype/"}
            className="btn btn-outline-success m-2"
          >
            Kurti naują dokumento tipą
          </Link>

          <table className="table table-active table-style-rounded">
            <tbody>
              <tr>
                <th className="col-1 Table-number-style">#</th>
                <th className="col-11 Table-action-style">
                  Dokumento tipo pavadinimas
                </th>
              </tr>

              <tr>
                <td className="table-action-size">{docTypesArrayToRenderId}</td>
                <td className="table-action-size">
                  {docTypesArrayToRenderTitle}
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
