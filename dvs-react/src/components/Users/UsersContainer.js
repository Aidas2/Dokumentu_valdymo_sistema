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
    var usersArrayToRender = this.state.users.map(oneUserObj => {
      return (
        <UsersComponent key={oneUserObj.userId} userDetails={oneUserObj} />
      );
    });

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h2 className="display-6 normal-padding">
            Vartotojai
            <div className="logo-info">
              <img src={infoIcon} className="info-icon-style" alt="info icon" />
              <span className="tooltiptext">
                Šiame meniu galima kurti ir peržiūrėti vartotojus.
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
            <Link to={"/admin/users"} className="second-navigation">
              Vartotojai
            </Link>
          </h5>

          <Link to={"/admin/newuser/"} className="btn btn-outline-success m-2">
            Pridėti naują vartotoją
          </Link>
          <p />
          <input type="checkbox" id="Document-type-box" />

          <label id="Document-type-container" htmlFor="Document-type-box">
            <div id="button" className="collapsed-style">
              Paspauskite ant šio teksto, tam kad būtų galima peržiūrėti/
              paslėpti sukurtus vartotojus:
              <ul id="Document-type-bar-appear" className="navbar-nav mr-auto">
                <div className="table table-active table-style-rounded">
                  <div className="container-fluid users-padding-bottom">
                    <div className="row table-active table-style-rounded ">
                      <div className="col-1  users-table-number-style ">ID</div>
                      <div className="col-2   users-table-middle-style">
                        Prisijungimo vardas
                      </div>
                      <div className=" col-2 users-table-middle-style">
                        Vardas
                      </div>
                      <div className="col-2   users-table-middle-style ">
                        Pavardė
                      </div>
                      <div className="col-2  users-table-middle-style ">
                        El. pašto adresas
                      </div>
                      <div className="col-3   users-table-action-style ">
                        Įdarbinimo data
                      </div>
                    </div>
                    {usersArrayToRender}
                  </div>
                </div>
              </ul>
            </div>
          </label>
        </div>
      </div>
    );
  }
}

export default UsersContainer;
