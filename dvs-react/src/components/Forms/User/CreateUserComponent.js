import React, { Component } from "react";
import PropTypes from "prop-types";

const CreateUserComponent = props => {
  return (
    <div>
      <div className="container-fluid m-2">
        <h3 className="display-6 ">Naujo dokumento tipo kūrimas</h3>
        <h5>Dokumento tipo pavadinimas</h5>
        <input
          onChange={props.onTitleChange}
          className="form-control col-4"
          type="text"
          placeholder="Įveskite dokumento tipo pavadinimą"
        />

        {/* <div className="form-group" /> */}

        <button onClick={props.onSubmit} className="btn btn-info">
          Kurti
        </button>
      </div>
      <div className="container">{props.launchAlert}</div>
    </div>
  );
};

export default CreateUserComponent;
