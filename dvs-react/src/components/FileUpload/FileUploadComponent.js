import React, { Component } from "react";
import PropTypes from "prop-types";
import DocumentTypesContainer from "./DocumetTypesContainer";

import { Link } from "react-router-dom";
import infoIcon from "../../images/info-icon.png";
import logo from "../../images/home.png";

class FileUploadComponent extends Component {
  render() {
    return (
      <div className="container-fluid m-2">
        <h2 className="display-6 normal-padding">
          Dokumento įkėlimas
          <div className="logo-info">
            <img src={infoIcon} className="info-icon-style" />
            <span class="tooltiptext">
              Šiame meniu pasirinkus norimus parametrus ir dokumentus, galima
              įkelti dokumentus.
            </span>
          </div>
        </h2>

        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/upload"} className="second-navigation">
            Dokumento įkėlimas
          </Link>
        </h5>

        <table className="table table-striped table-style-rounded">
          <tbody>
            <tr>
              <th className="col-1">#</th>
              <th className="col-5">Lauko pavadinimas</th>
              <th className="col-6">Įvedimo laukas</th>
            </tr>
            <tr>
              <td scope="row">
                <h6>1</h6>
              </td>
              <td scope="row">
                <h6>Dokumento pavadinimas</h6>
              </td>
              <td scope="row">
                <input
                  className=" form-control form-control-sm italic-style"
                  placeholder="Įveskite dokumento pavadinimą"
                  type="text"
                  onChange={this.props.onDocumentTitle}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>2</h6>
              </td>
              <td scope="row">
                <h6>Dokumento aprašymas</h6>
              </td>

              <td scope="row">
                <input
                  className="form-control form-control-sm italic-style"
                  placeholder="Įveskite dokumento aprašymą"
                  type="text"
                  onChange={this.props.onDocumentDescription}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>3</h6>
              </td>
              <td scope="row">
                <h6>Dokumento tipas</h6>
              </td>
              <td scope="row">
                <DocumentTypesContainer
                  documentTypes={this.props.documentTypes}
                  onDocumentTypeChange={this.props.onDocumentTypeChange}
                />
              </td>
            </tr>
            <tr>
              <td scope="row">
                <h6>4</h6>
              </td>
              <td scope="row">
                <h6>Pagrindinis dokumentas</h6>
              </td>
              <td scope="row">
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
              <td scope="row">
                <h6>5</h6>
              </td>
              <td scope="row">
                <h6>Priedai</h6>
              </td>

              <td scope="row">
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
              <td scope="row">
                <h6 />
              </td>
              <td scope="row">
                <h6 />
              </td>
              <td scope="row">
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

{
  /*     <form>
          <div className="">
            <label className="m-2 ">Dokumento pavadinimas</label>
            <br />
            <input
              className="m-2 form-control col-6"
              placeholder="Įveskite dokumento pavadinimą"
              type="text"
              onChange={this.props.onDocumentTitle}
            />
            <label className="m-2 ">Dokumento aprašymas</label>
            <br />
            <input
              className="m-2 form-control col-6"
              placeholder="Įveskite dokumento aprašymą"
              type="text"
              onChange={this.props.onDocumentDescription}
            />
            <label className="m-2">Dokumento tipas</label>
            <DocumentTypesContainer
              documentTypes={this.props.documentTypes}
              onDocumentTypeChange={this.props.onDocumentTypeChange}
            />

    */
}

{
  /* <select
            onChange={props.onDocumentType}
            className="form-control col-2 m-2"
            id="documentTypeSelect"
          >
            <option>Type1</option>
            <option>Type2</option>
            <option>Type3</option>
            <option>Type4</option>
            <option>Type5</option>
          </select> */
}

{
  /* 
          </div>
          <div className="input-group mb-3 mt-3 col-6  pl-2">
            <div className="input-group-prepend" />
            <div className="custom-file">
              <input
                type="file"
                onChange={this.props.onFile}
                className="custom-file-input "
                id="inputGroupFile01"
              />
              <label className="custom-file-label" form="inputGroupFile01">
                Pasirinkite pagrindinį dokumentą
              </label>
            </div>
          </div>
          <span className="m-2">{this.props.documentName}</span>
          <div className="input-group mb-3 mt-3 col-6  pl-2">
            <div className="input-group-prepend" />
            <div className="custom-file">
              <input
                type="file"
                multiple
                onChange={this.props.onFile}
                className="custom-file-input "
                id="inputGroupFile02"
              />
              <label className="custom-file-label" form="inputGroupFile01">
                Pasirinkite papildomus failus
              </label>
            </div>
          </div>
          <span className="m-2">{this.props.attachmentsNames}</span>

          {/* <div className="m-2">
          <label>Pasirinkite paildomus failus</label>&nbsp;
          <br />
          <input type="file" multiple name="file" onChange={props.onFile} />
        </div>
        <br /> */
}

{
  /*

          <button
            type="button"
            className="btn btn-outline-success m-2"
            onClick={this.props.onUpload}
          >
            Įkelti
          </button>
        </form>

     

        <div className="container">{this.props.launchAlert}</div>
      </div>
    );
  }
}

export default FileUploadComponent;

 */
}
