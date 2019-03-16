import React, { Component } from "react";

import DocumentTypesContainer from "./DocumetTypesContainer";

import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";
import logo from "../../images/home.png";

class FileUploadComponent extends Component {
  render() {
    return (
      <div className="container-fluid no-padding">
        <div className="row justify-content-between no-padding ">
          <div className=" col-12  normal-padding">
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
              <Link to={"/upload"} className="second-navigation">
                Dokumento įkėlimas
              </Link>
            </h5>
            <h2 className="display-6 ">
              Dokumento įkėlimas
              <div className="logo-info">
                <img
                  src={infoIcon}
                  className="info-icon-style"
                  alt="info icon"
                />
                <span className="tooltiptext">
                  Šiame meniu pasirinkus norimus parametrus ir dokumentus,
                  galima įkelti dokumentus.
                </span>
              </div>
            </h2>
          </div>
        </div>

        <div className="container-fluid">
          <div className="row users-padding-bottom table-style-rounded">
            <div className="col-1 users-table-number-style  ">#</div>
            <div className="col-5  users-table-middle-style ">
              Lauko pavadinimas
            </div>
            <div className=" col-6 users-table-action-style">
              Įvedimo laukas
            </div>
          </div>

          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">1</div>
            <div className="col-5 documents-table-size">
              Dokumento pavadinimas
            </div>
            <div className="col-6 documents-table-size">
              <input
                className=" form-control form-control-sm italic-style"
                placeholder="Įveskite dokumento pavadinimą"
                type="text"
                onChange={this.props.onDocumentTitle}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">2</div>
            <div className="col-5 documents-table-size">
              Dokumento aprašymas
            </div>
            <div className="col-6 documents-table-size">
              <input
                className="form-control form-control-sm italic-style"
                placeholder="Įveskite dokumento aprašymą"
                type="text"
                onChange={this.props.onDocumentDescription}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">3</div>
            <div className="col-5 documents-table-size">Dokumento tipas</div>
            <div className="col-6 documents-table-size">
              <DocumentTypesContainer
                documentTypes={this.props.documentTypes}
                onDocumentTypeChange={this.props.onDocumentTypeChange}
              />
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">4</div>
            <div className="col-5 documents-table-size">
              Pagrindinis dokumentas
            </div>
            <div className="col-6 documents-table-size">
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
            </div>
          </div>
          <div className="row users-padding-bottom">
            <div className="col-1 documents-table-size">5</div>
            <div className="col-5 documents-table-size">Priedai</div>
            <div className="col-6 documents-table-size">
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
            </div>
          </div>
          <div className="row ">
            <div className="col-1 " />
            <div className="col-5 " />
            <div className="col-6 ">
              <button
                type="button"
                className="btn btn-outline-success btn-sm document-button-style button-color"
                onClick={this.props.onUpload}
              >
                Įkelti
              </button>
            </div>
          </div>

          <div className="container">{this.props.launchAlert}</div>
        </div>

        {/* <table className="table table-color-style table-style-rounded users-padding-bottom">
          <tbody>
            <tr>
              <th className="col-1 users-table-number-style ">#</th>
              <th className="col-5 users-table-middle-style">
                Lauko pavadinimas
              </th>
              <th className="col-6 users-table-action-style">Įvedimo laukas</th>
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
        <div className="container">{this.props.launchAlert}</div> */}
      </div>
    );
  }
}

export default FileUploadComponent;
