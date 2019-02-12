import React, { Component } from "react";
import PropTypes from "prop-types";
import UsersComponent from "./UsersComponent";
import { Link } from "react-router-dom";
import axios from "axios";

class UsersContainer extends Component {
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
    var docTypesArrayToRender = this.state.docTypes.map(oneTypeObj => {
      return (
        <UsersComponent
          key={oneTypeObj.id}
          typeId={oneTypeObj.id}
          typeTitle={oneTypeObj.title}
        />
      );
    });

    return (
      <div>
        <div className="container-fluid m-2 ">
          <h3 className="display-6">Vartotojai</h3>
          <Link to={"/admin/newdoctype/"} className="btn btn-warning mb-2">
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
          {docTypesArrayToRender}
        </div>
      </div>
    );
  }
}

export default UsersContainer;
