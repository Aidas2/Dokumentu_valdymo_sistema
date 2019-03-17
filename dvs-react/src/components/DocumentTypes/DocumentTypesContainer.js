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
          <DocumentTypesComponent
            key={oneTypeObj.id}
            typeId={index + 1}
            typeTitle={oneTypeObj.title}
          />
        );
      }
    );

    // var docTypesArrayToRenderTitle = this.state.docTypes.map(oneTypeObj => {
    //   return (
    //     <DocumentTypesComponent key={oneTypeObj.id} typeId={oneTypeObj.title} />
    //   );
    // });

    return (
      <div>
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
                <Link to={"/admin/doctypes"} className="second-navigation">
                  Dokumentų tipai
                </Link>
              </h5>
              <h2 className="display-6 ">
                Dokumentų tipai
                <div className="logo-info">
                  <img
                    src={infoIcon}
                    className="info-icon-style"
                    alt="info icon"
                  />
                  <span className="tooltiptext">
                    Šiame meniu galima sukurti ir peržiūrėti dokumentų tipus.
                  </span>
                </div>
              </h2>
            </div>
            <div className=" col-6  normal-padding left-align ">
              <Link
                to={"/admin/newdoctype/"}
                className="btn btn-outline-success m-2 button-color"
              >
                Kurti naują dokumento tipą
              </Link>
            </div>
          </div>
          <div>
            <div className="container-fluid">
              <div className="row users-padding-bottom table-style-rounded">
                <div className="col-1 users-table-number-style  ">#</div>
                <div className="col-11   users-table-action-style">
                  Dokumento tipo pavadinimas
                </div>
              </div>
              <div className="">{docTypesArrayToRenderId}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
