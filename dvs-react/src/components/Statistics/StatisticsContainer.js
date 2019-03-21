import React, { Component } from "react";

import StatisticsComponent from "./StatisticsComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";
class StatisticsContainer extends Component {
  state = {
    documentTypes: [],
    selectedDocType: "",
    statisticsObj: ""
  };

  componentDidMount() {
    axios
      .get("/api/doctypes/readyForReviewing")
      .then(response => {
        this.setState({
          documentTypes: response.data
        });
        this.setState({ selectedDocType: response.data[0].title });

        axios
          .get("/api/statistics/" + response.data[0].title)
          .then(response => {
            this.setState({
              statisticsObj: response.data
            });
          })
          .catch(error => {
            console.log(error);
          });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleDocumentTypeChange = e => {
    this.setState({ selectedDocType: e.target.value });
    axios
      .get("/api/statistics/" + e.target.value)
      .then(response => {
        this.setState({
          statisticsObj: response.data
        });
      })
      .catch(error => {
        console.log(error);
      });
  };

  render() {
    const docTypesArrayToRender = this.state.documentTypes.map(oneType => {
      return <option key={oneType.id}>{oneType.title}</option>;
    });

    return (
      <div>
        <div className="container-fluid no-padding">
          <div className="row justify-content-between no-padding ">
            <div className=" col-12  normal-padding">
              <h5 className="display-12  second-navigation-style ">
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
                <Link to={"/statistics"} className="second-navigation">
                  Statistika
                </Link>
              </h5>
              <h2 className="display-6 ">
                Statistika
                <div className="logo-info">
                  <img
                    src={infoIcon}
                    className="info-icon-style"
                    alt="info icon"
                  />
                  <span className="tooltiptext">
                    Šiame meniu yra matoma statistika
                  </span>
                </div>
              </h2>
            </div>
          </div>
          <div className="container-fluid">
            <StatisticsComponent
              selectedDocType={this.state.selectedDocType}
              statisticsObject={this.state.statisticsObj}
              docTypesToRender={docTypesArrayToRender}
              onDocumentTypeChange={this.handleDocumentTypeChange}
            />
          </div>

          <div />
        </div>
      </div>
    );
  }
}

export default StatisticsContainer;
