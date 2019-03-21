import React, { Component } from "react";
import axios from "axios";
import downloadIcon from "../../images/download-icon.png";

class FileDownloadConatainer extends Component {
  state = {
    documentId: null
  };

  componentDidMount() {
    this.setState({ documentId: this.props.documentId });
  }

  downloadFile = () => {
    console.log("download method happened");

    axios({
      url: "http://localhost:8081/files",
      method: "GET",
      params: {
        documentId: this.props.documentId
      },
      responseType: "blob" // important
    })
      .then(response => {
        const fileName = response.headers["content-disposition"].substring(
          200,
          22
        );
        console.log("--------------- response >>>>>>>>> ", response);

        const url = window.URL.createObjectURL(
          new Blob([response.data], { type: "application/octet-stream" }) //it works withoud a type as well
        );
        const link = document.createElement("a");
        link.href = url;
        link.setAttribute("download", fileName); //or any other extension
        document.body.appendChild(link);
        link.click();
        link.remove();
      })
      .catch(error => {
        console.log(error);
      });
  };

  render() {
    return (
      <button
        style={{ display: "inline" }}
        onClick={this.downloadFile}
        className="btn btn-outline-success button-info "
      >
        <img src={downloadIcon} width="20" height="20" alt="download icon" />
        <span className="tooltiptext">Atsisiųsti</span>
      </button>
    );
  }
}

export default FileDownloadConatainer;
