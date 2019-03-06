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
      .get("http://localhost:8081/api/doctypes")
      .then(response => {
        this.setState({ documentTypes: response.data });
        let createDocumentInfo = this.state.createDocumentInfo;
        createDocumentInfo.documentTypeTitle = response.data[0].title;
        createDocumentInfo.username = localStorage.getItem("username");
        this.setState({ createDocumentInfo: createDocumentInfo });
        let username = localStorage.getItem("username");
        this.setState({ username });
        // this.setState({ documentType: response.data[0].title });
        // this.setState({ documentType: response.data[0].title });
      })
      .catch(error => {
        console.log(error);
      });
    console.log(
      "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.documetTypes>>>>.",
      this.state.documentTypes
    );
  }

  handleAttachments = e => {
    // console.log(e.target.files, "$$$$-e.target.files");
    // console.log(e.target.files[0], "$$$$-e.target.files[0]");
    // console.log(e.target.files[1], "$$$$-e.target.files[1]");
    this.handleCloseAlert();

    let file = Array.from(e.target.files); //e.target.files[0] was before
    let files = this.state.file;
    file.forEach(element => {
      files.push(element);
    });

    this.setState({ file: files });
    console.log("&&&&&&&&&& state.file from handleFile = ", this.state.file);
  };
  handleMainDocument = e => {
    // console.log(e.target.files, "$$$$-e.target.files");
    // console.log(e.target.files[0], "$$$$-e.target.files[0]");
    // console.log(e.target.files[1], "$$$$-e.target.files[1]");
    this.handleCloseAlert();

    let file = Array.from(e.target.files); //e.target.files[0] was before
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

    let files = this.state.file; //was this.state.file before
    for (let i = 0; i < files.length; i++) {
      formData.append("file", files[i]); //image was originally, I changed it to file
      formData.append("name", this.state.file[i].name); //2nd parameter was "Paulius cicenas"
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
        //it works without catch block as well
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

    console.log("$$$$$$ DocumentTypeChange occured@@@@@@@@@@@@@@@@@@@@@@");
    let createDocumentInfo = this.state.createDocumentInfo;
    createDocumentInfo.documentTypeTitle = e.target.value;
    this.setState({ createDocumentInfo: createDocumentInfo });
    // console.log("$$$$$$ this.state.documentType >>>>>> ", this.state.documentType);
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
          <strong>Success!</strong> Selected files were uploaded successfully
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
  // withHandlers = () => ({
  //   handleClick: props => (value1, value2) => event => {
  //     console.log(event);
  //     alert(value1 + " was clicked!");
  //     props.doSomething(value2);
  //   }
  // });

  // static propTypes = {
  //   handleClick: PropTypes.func
  // };
  render() {
    const { handleClick } = this.props;
    console.log(
      "render() inside DocumentTYpesCOntainer >>>>>>>>>> this.state.documetTypes>>>>.",
      this.state.documentTypes
    );
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
    console.log("########### attachments", attachments);
    console.log("########### attachmentsNames", attachmentsNames);
    console.log(
      "%%%%%%%%%%%%%%%%%%%%% getUploadStatus inside render() >>>",
      this.uploadStatus
    );
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
