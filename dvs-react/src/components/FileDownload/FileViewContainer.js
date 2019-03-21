import React, { Component } from "react";

import reviewIcon from "../../images/review-icon.png";

class FileViewContainer extends Component {
  state = {
    documentId: null,
    response: "",
    file: "",
    fileURL: ""
  };

  componentDidMount() {
    this.setState({ documentId: this.props.documentId });
  }

  viewFile = () => {
    console.log("download method happened");

    const link = document.createElement("a");
    link.href =
      "http://localhost:8081/files/view?documentId=" + this.props.documentId;
    document.body.appendChild(link);
    link.click();
    link.remove();
  };

  render() {
    return (
      <div style={{ display: "inline" }}>
        <button
          onClick={this.viewFile}
          className="btn btn-outline-success button-info "
        >
          <img src={reviewIcon} width="20" height="20" alt="review icon" />
          <span className="tooltiptext">Peržiūrėti</span>
        </button>
      </div>
    );
  }
}

export default FileViewContainer;
