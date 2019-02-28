import React, { Component } from "react";

class RenderResponse extends Component {
  state = {};
  render() {
    return (
      <div>
        <object data={this.props.responseToRender} type="application/pdf" />
      </div>
    );
  }
}

export default RenderResponse;
