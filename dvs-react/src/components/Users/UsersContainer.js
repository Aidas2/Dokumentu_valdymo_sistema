import React, { Component } from "react";
import PropTypes from "prop-types";
import UsersComponent from "./UsersComponent";
import { Link } from "react-router-dom";
import axios from "axios";

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
          <h3 className="display-6">Vartotojai</h3>
          <Link to={"/admin/newuser/"} className="btn btn-warning mb-2">
            Pridėti naują vartotoją
          </Link>
          <div className="container pl-0 ml-0">
            <h4 className="display-6">Esami vartotojai</h4>

            <div className="row">
              <div className="col-2">
                <p>
                  {" "}
                  <strong>Vartotojo ID</strong>
                </p>
                {/* <Link to="">Linkas</Link> */}
              </div>
              <div className="col-2">
                <p>
                  <strong>Prisijungimo vardas</strong>
                </p>
              </div>{" "}
              <div className="col-2">
                <p>
                  <strong>Vardas</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>Pavardė</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>El. pašto adresas</strong>
                </p>
              </div>
              <div className="col-2">
                <p>
                  <strong>Įdarbinimo data</strong>
                </p>
              </div>
            </div>
          </div>
          {usersArrayToRender}
        </div>
      </div>
    );
  }
}

export default UsersContainer;
