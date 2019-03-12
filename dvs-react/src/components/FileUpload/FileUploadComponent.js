import React, { Component } from "react";

import DocumentTypesContainer from "./DocumetTypesContainer";

import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";
import logo from "../../images/home.png";

class FileUploadComponent extends Component {
  render() {
    return (
      <div className="container-fluid ">
        <h2 className="display-6 normal-padding">
          Dokumento įkėlimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" alt="info icon" />
            <span className="tooltiptext">
              Šiame meniu pasirinkus norimus parametrus ir dokumentus, galima
              įkelti dokumentus.
            </span>
          </div>
        </h2>

        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" alt="logo icon" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/upload"} className="second-navigation">
            Dokumento įkėlimas
          </Link>
        </h5>

        <table className="table table-color-style table-style-rounded">
          <tbody>
            <tr>
              <th className="col-1">#</th>
              <th className="col-5">Lauko pavadinimas</th>
              <th className="col-6">Įvedimo laukas</th>
            </tr>
            <tr>
              <td>
                <h6>1</h6>
              </td>
              <td>
                <h6>Dokumento pavadinimas</h6>
              </td>
              <td>
                <input
                  className=" form-control form-control-sm italic-style"
                  placeholder="Įveskite dokumento pavadinimą"
                  type="text"
                  onChange={this.props.onDocumentTitle}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>2</h6>
              </td>
              <td>
                <h6>Dokumento aprašymas</h6>
              </td>

              <td>
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite dokumento aprašymą"
                  type="text"
                  onChange={this.props.onDocumentDescription}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>3</h6>
              </td>
              <td>
                <h6>Dokumento tipas</h6>
              </td>
              <td>
                <DocumentTypesContainer
                  documentTypes={this.props.documentTypes}
                  onDocumentTypeChange={this.props.onDocumentTypeChange}
                />
              </td>
            </tr>
            <tr>
              <td>
                <h6>4</h6>
              </td>
              <td>
                <h6>Pagrindinis dokumentas</h6>
              </td>
              <td>
                <div className="input-group   ">
                  <div className="input-group-prepend" />
                  <div className="custom-file">
                    <input
                      type="file"
                      onChange={this.props.onMainDocument}
                      className="custom-file-input "
                      id="inputGroupFile01"
                    />
                    <label
                      className="custom-file-label italic-style"
                      form="inputGroupFile01"
                    >
                      Pasirinkite pagrindinį dokumentą
                    </label>
                  </div>
                </div>
                <span className="italic-style-small">
                  {this.props.documentName}
                </span>
              </td>
            </tr>

            <tr>
              <td>
                <h6>5</h6>
              </td>
              <td>
                <h6>Priedai</h6>
              </td>

              <td>
                <div className="input-group ">
                  <div className="input-group-prepend" />
                  <div className="custom-file">
                    <input
                      type="file"
                      multiple
                      onChange={this.props.onAttachments}
                      className="custom-file-input "
                      id="inputGroupFile02"
                    />
                    <label
                      className="custom-file-label italic-style"
                      form="inputGroupFile01"
                    >
                      Pasirinkite papildomus failus
                    </label>
                  </div>
                </div>
                <span className="italic-style-small">
                  {this.props.attachmentsNames}
                </span>
              </td>
            </tr>
            <tr>
              <td>
                <h6> </h6>
              </td>
              <td>
                <h6> </h6>
              </td>
              <td>
                <button
                  type="button"
                  className="btn btn-outline-success btn-sm document-button-style"
                  onClick={this.props.onUpload}
                >
                  Įkelti
                </button>
              </td>
            </tr>
          </tbody>
        </table>
        <div className="container">{this.props.launchAlert}</div>
      </div>
    );
  }
}

export default FileUploadComponent;
