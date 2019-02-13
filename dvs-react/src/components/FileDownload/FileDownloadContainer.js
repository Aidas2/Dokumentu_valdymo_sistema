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
      url: "http://localhost:8081/api/docstest",
      method: "post",
      headers: {
        authorisation: "your token"
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
    axios
      .get("http://localhost:8081/api/docstest")
      .then(response => {
        const filename = response.headers
          .get("Content-Disposition")
          .split("filename=")[1];
        response.blob().then(blob => {
          let url = window.URL.createObjectURL(blob);
          let a = document.createElement("a");
          a.href = url;
          a.download = filename;
          a.click();
        });
      })
      .catch(error => {
        console.log(error);
      });
  };

  // downloadRandomImages = () => {
  //   fetch('http://localhost:8080/api/files')
  //     .then(response => {
  //       const filename =  response.headers.get('Content-Disposition').split('filename=')[1];
  //       response.blob().then(blob => {
  //         let url = window.URL.createObjectURL(blob);
  //         let a = document.createElement('a');
  //         a.href = url;
  //         a.download = filename;
  //         a.click();
  //     });
  //  });
  // }
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