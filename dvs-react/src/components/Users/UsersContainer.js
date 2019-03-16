import React, { Component } from "react";

import UsersComponent from "./UsersComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";
class UsersContainer extends Component {
  state = {
    users: []
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/users")
      .then(response => {
        this.setState({ users: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    console.log(
      "ComponentDidMount inside render() >>>>>>>>>> this.state>>>>.",
      this.state
    );
    var usersArrayToRender = this.state.users.map((oneUserObj, index) => {
      return (
        <UsersComponent
          key={oneUserObj.userId}
          userDetails={oneUserObj}
          index={index + 1}
        />
      );
    });

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
                    alt="logo icon"
                  />
                </Link>
                &ensp;/ &ensp;
                <Link to={"/admin"} className="second-navigation">
                  Administratoriaus rolė
                </Link>
                &ensp;/ &ensp;
                <Link to={"/admin/users"} className="second-navigation">
                  Vartotojai
                </Link>
              </h5>
              <h2 className="display-6 ">
                Vartotojai
                <div className="logo-info">
                  <img
                    src={infoIcon}
                    className="info-icon-style"
                    alt="info icon"
                  />
                  <span className="tooltiptext">
                    Šiame meniu galima kurti ir peržiūrėti vartotojus.
                  </span>
                </div>
              </h2>
            </div>
            <div className=" col-6  normal-padding left-align ">
              <Link
                to={"/admin/newuser/"}
                className="btn btn-outline-success m-2 button-color"
              >
                Pridėti naują vartotoją
              </Link>
            </div>
          </div>

          <div className="container-fluid">
            <div className="row users-padding-bottom table-style-rounded">
              <div className="col-1 users-table-number-style  ">#</div>
              <div className="col-2   users-table-middle-style">
                Prisijungimo vardas
              </div>
              <div className=" col-2 users-table-middle-style">Vardas</div>
              <div className="col-2   users-table-middle-style ">Pavardė</div>
              <div className="col-2  users-table-middle-style ">
                El. pašto adresas
              </div>
              <div className="col-3   users-table-action-style ">
                Įdarbinimo data
              </div>
            </div>
            <div> {usersArrayToRender}</div>
          </div>
        </div>
      </div>
    );
  }
}

export default UsersContainer;
