import React, { Component } from "react";
import axios from "axios";

class FileDownloadConatainer extends Component {
  state = {
    file: "",
    error: "",
    msg: ""
  };

  handleFileChange = event => {
    console.log("handleFileChange happened *******************");
    let fileForState = event.target.files[0];
    this.setState({ file: fileForState });
    event.preventDefault();
    this.setState({ error: "", msg: "" });
  };

  uploadFile = e => {
    if (!this.state.file) {
      this.setState({ error: "Please upload a file" });
      return;
    }
    if (this.state.file.size >= 2000000) {
      this.setState({ error: "The file exeeds 2MB" });
      return;
    }
    let data = new FormData();
    data.append("file", this.state.file);
    data.append("name", this.state.file.name);

    axios({
      url: "http://localhost:8081/files",
      method: "post",
      headers: {
        authorisation: "your token"
        // "Content-type": "multipart/form-data"
      },
      data: data
    })
      .then(response => {
        this.setState({
          msg: "Successfully upladed the file-----------------from axios.then"
        });
        console.log(this.state.msg);
      })
      .catch(function(error) {
        //it works without catch block as well
        console.log(error);
        if (error.response) {
          //HTTP error happened
          console.log(
            "Create Document entity : Upload error. HTTP error/status code=",
            error.response.status
          );
        } else {
          //some other error happened
          console.log(
            "Create Document entity: Upload error. HTTP error/status code=",
            error.message
          );
        }
      });
  };
  downloadRandomImage = () => {
    console.log("download method happened");
    // axios
    //   .get("http://localhost:8081/files/java.txt")
    //   .then(response => {
    //     var filename = response.headers
    //       .get("Content-Disposition")
    //       .split("filename=")[1];
    //     response.blob().then(blob => {
    //       let url = window.URL.createObjectURL(blob);
    //       let a = document.createElement("a");
    //       a.href = url;
    //       a.download = filename;
    //       a.click();
    //     });
    //   })

    //THIS METHOD WORKS
    axios({
      url: "http://localhost:8081/files/java.txt",
      method: "GET",
      responseType: "blob" // important
    })
      .then(response => {
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
        const fileName = response.headers["content-disposition"];
        console.log("--------------- response >>>>>>>>> ", response);
        console.log(
          "--------------- response.headers.content-disposition >>>>>>>>> ",
          JSON.stringify(response.headers)
        );
        const nameAdjusted = fileName.substring(100, 22);
        console.log("--------------- fileName >>>>>>>>> ", nameAdjusted);

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
  // downloadRandomImage = () => {
  //   console.log("download method happened");
  //   fetch("http://localhost:8081/files").then(response => {
  //     const filename = response.headers
  //       .get("Content-Disposition")
  //       .split("filename=")[1];
  //     response.blob().then(blob => {
  //       let url = window.URL.createObjectURL(blob);
  //       let a = document.createElement("a");
  //       a.href = url;
  //       a.download = filename;
  //       a.click();
  //     });
  //   });
  // };
  render() {
    console.log(
      this.state,
      "<<<<<<<<<<<<<<<<<<<,THis.state in render()------------------"
    );
    return (
      <div className="App-intro">
        <h3>Upload a file</h3>
        <h4 style={{ color: "red" }}>{this.state.error}</h4>
        <h4 style={{ color: "green" }}>{this.state.msg}</h4>
        <input onChange={this.handleFileChange} type="file" />
        <button onClick={this.uploadFile}>Upload</button>
        <h3>Download a random file</h3>
        <button onClick={this.downloadRandomImage}>Download</button>
      </div>
    );
  }
}

export default FileDownloadConatainer;
