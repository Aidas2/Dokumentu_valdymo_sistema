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
          <h6 className="display-6 normal-padding">Dokumentų tipai</h6>

          <h5 className="display-6 normal-padding gray-collor ">
            <Link to={"/"}>
              <img src={logo} width="20" height="10" />
            </Link>
            &ensp;/ &ensp;
            <Link to={"/admin"} className="explorer">
              Administratoriaus rolė
            </Link>
            &ensp;/ &ensp;
            <Link to={"/admin/usergroups"} className="explorer">
              Vartotojų grupės
            </Link>
          </h5>

          {/*  <h3 className="display-6">Dokumentų tipai</h3> */}
          <Link
            to={"/admin/usergroups/new"}
            className="btn btn-outline-success m-2"
          >
            Kurti naują vartotojų grupę
          </Link>
          <table className="table table-active">
            <thead className="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Vartotojų grupės pavadinimas</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"> {userGroupsArrayToRenderId}</th>
                <td>{userGroupsArrayToRenderTitle}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default DocumentTypesContainer;
