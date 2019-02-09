import React, { Component } from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const DocumentTypesComponent = props => {
  return (
    <div className="container-fluid m-2 ">
      <h3 className="display-6">Dokumentų tipai</h3>
      <Link to={"/admin/newdoctype/"} className="btn btn-warning mb-2">
        Kurti naują dokumento tipą
      </Link>

      <div className="container- pl-0 ml-0">
        <div className="row">
          <div className="col-2">
            Dokumento tipo ID{/* <Link to="">Linkas</Link> */}
          </div>

          <div className="col-2">
            <p>Dokumento tipo pavadinimas</p>
          </div>
        </div>
      </div>

      {/* <div className="card m-2">
       <h5 className="card-header">"pirmas"</h5>
       <div className="card-body">
         <h5 className="card-title">antras</h5>
         <p className="card-text">trecias</p>

         <Link to={"/admin/newdoctype/"} className="btn btn-warning m-2">
           Kurti naują dokumento tipą
         </Link>
         <form>
           <button type="submit" className="btn btn-primary m-2">
             delete
           </button>
         </form>
       </div>*/}
    </div>
  );
};

export default DocumentTypesComponent;
