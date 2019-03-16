import React, { Component } from "react";

import UserGroupsComponent from "./UserGroupsComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";
import infoIcon from "../../images/info-icon.png";

class DocumentTypesContainer extends Component {
  state = { userGroups: [] };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/groups")
      .then(response => {
        this.setState({ userGroups: response.data });
      })
      .catch(error => {
        console.log(error);
      });
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.userGroups>>>>.",
      this.state.userGroups
    );
  }

  render() {
    var userGroupsArrayToRenderId = this.state.userGroups.map(
      (oneGroupObj, index) => {
        return (
          <UserGroupsComponent
            key={oneGroupObj.title}
            groupId={index + 1}
            groupTitle={oneGroupObj.title}
          />
        );
      }
    );

    // var userGroupsArrayToRenderTitle = this.state.userGroups.map(
    //   oneGroupObj => {
    //     return (
    //       <UserGroupsComponent
    //         key={oneGroupObj.title}
    //         groupTitle={oneGroupObj.title}
    //       />
    //     );
    //   }
    // );

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
                <Link to={"/admin/usergroups"} className="second-navigation">
                  Vartotojų grupės
                </Link>
              </h5>
              <h2 className="display-6 ">
                Vartotojų grupės
                <div className="logo-info">
                  <img
                    src={infoIcon}
                    className="info-icon-style"
                    alt="info icon"
                  />
                  <span className="tooltiptext">
                    Šiame meniu galima kurti ir peržiūrėti vartotojų grupes.
                  </span>
                </div>
              </h2>
            </div>
            <div className=" col-6  normal-padding left-align ">
              <Link
                to={"/admin/newusergroup"}
                className="btn btn-outline-success m-2 button-color"
              >
                Kurti naują vartotojų grupę
              </Link>
            </div>
          </div>
          <div>
            <div className="container-fluid">
              <div className="row users-padding-bottom table-style-rounded">
                <div className="col-1 users-table-number-style  ">#</div>
                <div className="col-11   users-table-action-style">
                  Vartotojų grupės pavadinimas
                </div>
              </div>
              <div className="">{userGroupsArrayToRenderId}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
