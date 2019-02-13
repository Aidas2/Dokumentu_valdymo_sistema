import React, { Component } from "react";

class FileDownloadConatainer extends Component {
  state = {
    file: "",
    error: "",
    msg: ""
  };

  onFileChange = event => {
    this.setState({ file: event.target.files[0] });
    event.preventDefault();
    this.setState({ error: "", msg: "" });
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
  };

  uploadFile = e => {};
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
        <input onChange={this.onFileChange} type="file" />
        <button onClick={this.uploadFile}>Upload</button>
      </div>
    );
  }
}

export default FileDownloadConatainer;
