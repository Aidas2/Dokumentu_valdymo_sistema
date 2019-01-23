import React, { Component } from "react";
import Axios from "axios";

class ImageUploader extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedFile: null
    };
  }

  fileSelectedHandler = event => {
    this.setState({ selectedFile: event.target.files[0] });
    console.log(event.target.files[0]);
  };

  fileUploadHandler = () => {
    const fd = new FormData();
    fd.append("image", this.state.selectedFile, this.state.selectedFile.name);
    Axios.post("http://localhost:8081/api/upload", fd).then(res => {
      console.log(res);
    });
  };

  render() {
    return (
      <div className="container">
        <div className="row">Hello i can upload image if you want asshole</div>
        <div className="row">
          <input type="file" onChange={this.fileSelectedHandler} />
          <button onClick={this.fileUploadHandler}>Upload</button>
        </div>
      </div>
    );
  }
}

export default ImageUploader;
