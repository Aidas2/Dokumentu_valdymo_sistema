import React, { Component } from "react";

class FileDownloadConatainer extends Component {
  state = {
    file: "",
    error: "",
    msg: ""
  };
  render() {
    return (
      <div className="App-intro">
        <h3>Upload a file</h3>
        <h4 style={{ color: "red" }}>{this.state.error}</h4>
        <h4 style={{ color: "green" }}>{this.state.msg}</h4>
        <input onChange={this.onFileChange} type="file" />
        <button onClick={this.uploadFile}>Upload</button>
      </div>
    );
  }
}

export default FileDownloadConatainer;
