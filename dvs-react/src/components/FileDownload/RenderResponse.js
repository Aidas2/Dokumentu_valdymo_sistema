import React, { Component } from "react";

class RenderResponse extends Component {
  state = {};
  render() {
    return (
      <div>
        <p>Labas</p>
        <object data={this.props.responseToRender} type="application/pdf" />
      </div>
    );
  }
}

export default RenderResponse;
