import React, { Component } from "react";
import axios from "axios";

class FileViewContainer extends Component {
  state = {
    documentId: null,
    response: ""
  };

  componentDidMount() {
    this.setState({ documentId: this.props.documentId });
  }

  viewFile = () => {
    console.log("download method happened");

    axios({
      url: "http://localhost:8081/files/view",
      method: "GET",
      params: {
        documentId: this.state.documentId
      }
      // responseType: "blob" // important
    })
      .then(response => {
        this.setState({ response });
        // const fileName = response.headers["content-disposition"].substring(
        //   200,
        //   22
        // );

        console.log("--------------- response >>>>>>>>> ", response);

        // const url = window.URL.createObjectURL(
        //   new Blob([response.data], { type: "application/octet-stream" }) //it works withoud a type as well
        // );
        // const link = document.createElement("a");
        // link.href = url;
        // link.setAttribute("download", fileName); //or any other extension
        // document.body.appendChild(link);
        // link.click();
        // link.remove();
      })
      .catch(error => {
        console.log(error);
      });
  };

  // var funkcija = (response, status, xhr) => {
  //   var filename = "";
  //   var disposition = xhr.getResponseHeader("Content-Disposition");
  //   if (disposition && disposition.indexOf("attachment") !== -1) {
  //     var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
  //     var matches = filenameRegex.exec(disposition);
  //     if (matches != null && matches[1]) {
  //       filename = matches[1].replace(/['"]/g, "");
  //     }
  //   }
  //   return filename;
  // };

  render() {
    console.log(
      this.state,
      "<<<<<<<<<<<<<<<<<<<,THis.state in render()------------------"
    );
    return (
      <div>
        {/* <object data={this.state.response} type="application/pdf" /> */}
        <button onClick={this.viewFile} className="btn btn-dark">
          Peržiūrėti
        </button>
      </div>
    );
  }
}

export default FileViewContainer;
