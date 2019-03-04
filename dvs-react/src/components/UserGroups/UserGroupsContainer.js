import React, { Component } from "react";
import PropTypes from "prop-types";
import UserGroupsComponent from "./UserGroupsComponent";
import { Link } from "react-router-dom";
import axios from "axios";
import logo from "../../images/home.png";

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
    var userGroupsArrayToRenderId = this.state.userGroups.map(oneGroupObj => {
      return (
        <UserGroupsComponent
          key={oneGroupObj.title}
          groupId={oneGroupObj.title}
        />
      );
    });

    var userGroupsArrayToRenderTitle = this.state.userGroups.map(
      oneGroupObj => {
        return (
          <UserGroupsComponent
            key={oneGroupObj.title}
            groupTitle={oneGroupObj.title}
          />
        );
      }
    );

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h2 className="display-6 normal-padding">Vartotojų grupės</h2>

          <h5 className="display-6 normal-padding second-navigation-style ">
            <Link to={"/"}>
              <img src={logo} width="20" height="10" />
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

          <Link
            to={"/admin/usergroups/new"}
            className="btn btn-outline-success m-2"
          >
            Kurti naują vartotojų grupę
          </Link>
          <div className="container pl-0 ml-0">
            <table className="table table-active">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Vartotojų grupės pavadinimas</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td scope="row"> {userGroupsArrayToRenderId}</td>
                  <td>{userGroupsArrayToRenderTitle}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
