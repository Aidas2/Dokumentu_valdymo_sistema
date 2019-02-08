import React, { Component } from "react";
import PropTypes from "prop-types";

const CreateDocumentTypeComponent = props => {
  return (
    <div className="container-fluid m-2">
      <h3 class="display-6 ">Naujo dokumento tipo kūrimas</h3>
      <input
        className="form-control col-4"
        type="text"
        placeholder="Įveskite dokumento tipo pavadinimą"
      />

      <div className="form-group" />

      <button type="submit" className="btn btn-info">
        Kurti naują grupę
      </button>
    </div>
  );
};

export default CreateDocumentTypeComponent;
