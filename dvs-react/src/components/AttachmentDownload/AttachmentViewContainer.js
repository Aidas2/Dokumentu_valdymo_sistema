import React, { Component } from "react";

import reviewIcon from "../../images/review-icon.png";

class AttachmentViewContainer extends Component {
  state = {
    attachmentId: null,
    response: "",
    file: "",
    fileURL: ""
  };

  componentDidMount() {
    this.setState({ attachmentId: this.props.attachmentId });
  }

  viewFile = () => {
    console.log("download method happened");

    const link = document.createElement("a");
    link.href =
      "http://localhost:8081/files/attachments/view?attachmentId=" +
      this.props.attachmentId;
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

export default AttachmentViewContainer;
