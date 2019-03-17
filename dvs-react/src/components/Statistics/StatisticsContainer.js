import React, { Component } from "react";

import StatisticsComponent from "./StatisticsComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";
class StatisticsContainer extends Component {
  state = {
    statistics: []
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/statistics/docAndusers")
      .then(response => {
        console.log(response);
        this.setState({
          statistics: response.data
        });
      })
      .catch(error => {
        console.log(error);
      });

    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.statistics>>>>.",
      this.state
    );
  }

  render() {
    var statisticsExample = this.state.statistics.map(
      statisticsFirstElement => {
        return <div>{statisticsFirstElement} </div>;
      }
    );

    // var map1 = new Map(this.state.statistics);

    var statisticsExample22 = this.state.statistics.map(
      statisticsFirstElement => {
        return <div>{statisticsFirstElement} </div>;
      }
    );

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
            <div className="row users-padding-bottom table-style-rounded">
              <div className="col-1 users-table-number-style  ">#</div>
              <div className="col-2   users-table-middle-style">---</div>
              <div className=" col-2 users-table-middle-style">--</div>
              <div className="col-2   users-table-middle-style ">-</div>
              <div className="col-2  users-table-middle-style ">{123}</div>
              <div className="col-3   users-table-action-style ">
                {statisticsExample22}
              </div>
            </div>
            <div>{statisticsExample}</div>
          </div>
        </div>
      </div>
    );
  }
}

export default StatisticsContainer;
