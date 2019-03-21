import React, { Component } from "react";

import axios from "axios";
import FileUploadComponent from "./FileUploadComponent";

class FileUploadContainer extends Component {
  state = {
    file: [],

    documentTypes: [],
    sth: false,
    createDocumentInfo: {
      description: "testDesc",
      documentTypeTitle: "type2",
      title: "testTytle",
      username: ""
    }
  };

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/doctypes/readyForSubmittingV2")
      .then(response => {
        this.setState({ documentTypes: response.data });
        let createDocumentInfo = this.state.createDocumentInfo;
        createDocumentInfo.documentTypeTitle = response.data[0].title;
        createDocumentInfo.username = localStorage.getItem("username");
        this.setState({ createDocumentInfo: createDocumentInfo });
        let username = localStorage.getItem("username");
        this.setState({ username });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleAttachments = e => {
    this.handleCloseAlert();
    let file = Array.from(e.target.files);
    let files = this.state.file;
    file.forEach(element => {
      files.push(element);
    });

    this.setState({ file: files });
  };
  handleMainDocument = e => {
    this.handleCloseAlert();

    let file = Array.from(e.target.files);
    let files = this.state.file;
    file.forEach(element => {
      files.unshift(element);
    });

    this.setState({ file: files });
    console.log("&&&&&&&&&& state.file from handleFile = ", this.state.file);
  };

  getUploadStatus = () => {
    return this.uploadStatus;
  };
  handleFilesUpload = () => {
    this.handleCloseAlert();

    console.log(this.state, "THE STATE from handleUpload------$$$$$$");
    let formData = new FormData();

    let files = this.state.file;
    for (let i = 0; i < files.length; i++) {
      formData.append("file", files[i]);
      formData.append("name", this.state.file[i].name);
      formData.append("docData", JSON.stringify(this.state.createDocumentInfo));
    }
    axios({
      url: "http://localhost:8081/files",
      method: "post",
      headers: {
        authorisation: "your token"
      },
      data: formData
    })
      .then(response => {
        console.log("File " + files.name + " is uploaded");
        const uploadStatus = "Selected files were uploaded successfully";
        console.log("upload status >>>>>>>>>> ", uploadStatus);
        this.setState({ sth: true });
      })
      .catch(function(error) {
        console.log(error);
        if (error.response) {
          //HTTP error happened
          console.log(
            "Upload error. HTTP error/status code=",
            error.response.status
          );
        } else {
          //some other error happened
          console.log("Upload error. HTTP error/status code=", error.message);
        }
      });
    let fileInStateCleaned = [];
    this.setState({ file: fileInStateCleaned });
  };

  handleDocumentTitle = e => {
    this.handleCloseAlert();

    let createDocumentInfo = this.state.createDocumentInfo;
    createDocumentInfo.title = e.target.value;
    this.setState({ createDocumentInfo: createDocumentInfo });
  };
  handleDocumentDescription = e => {
    this.handleCloseAlert();

    let createDocumentInfo = this.state.createDocumentInfo;
    createDocumentInfo.description = e.target.value;
    this.setState({ createDocumentInfo: createDocumentInfo });
  };
  handleDocumentType = e => {
    this.handleCloseAlert();

    let createDocumentInfo = this.state.createDocumentInfo;
    createDocumentInfo.documentTypeTitle = e.target.value;
    this.setState({ createDocumentInfo: createDocumentInfo });
  };

  getMainDocumentName = () => {
    if (this.state.file.length > 0) {
      return this.state.file[0].name;
    }
    return "Nepasirinktas joks failas";
  };
  handleCloseAlert = () => {
    this.setState({ sth: false });
  };

  launchAlert = () => {
    if (this.state.sth) {
      return (
        <div className="alert alert-success alert-dismissible">
          <button
            onClick={this.handleCloseAlert}
            href="#"
            className="close"
            data-dismiss="alert"
            aria-label="close"
          >
            &times;
          </button>
          <strong> Sveikiname!</strong> Pasirinkti failai buvo sėkmingai įkelti
        </div>
      );
    }
    return null;
  };
  handleAttachmentRemoval = fileName => {
    let files = this.state.file;
    var filteredFiles = files.filter(file => file.name !== fileName);
    this.setState({ file: filteredFiles });
  };

  render() {
    // const { handleClick } = this.props;

    var attachments = this.state.file.filter(
      file => file.name !== this.state.file[0].name
    );

    var attachmentsNames = attachments.map(oneFile => {
      return (
        <span key={oneFile.name}>
          &nbsp;{oneFile.name}&nbsp;
          <button
            onClick={() => this.handleAttachmentRemoval(oneFile.name)}
            className="btn btn-danger btn-sm"
          >
            x
          </button>
        </span>
      );
    });

    return (
      <FileUploadComponent
        onUpload={this.handleFilesUpload}
        onAttachments={this.handleAttachments}
        onMainDocument={this.handleMainDocument}
        onDocumentTypeChange={this.handleDocumentType}
        onDocumentTitle={this.handleDocumentTitle}
        onDocumentDescription={this.handleDocumentDescription}
        documentTypes={this.state.documentTypes}
        documentName={this.getMainDocumentName()}
        attachmentsNames={attachmentsNames}
        uploadMessage={this.uploadStatus}
        launchAlert={this.launchAlert()}
      />
    );
  }
}

export default FileUploadContainer;
