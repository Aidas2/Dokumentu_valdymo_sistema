import React, { Component } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import NavigationContainer from "./components/navigation/NavigationContainer";

class App extends Component {
  render() {
    return (
      <div>
        <NavigationContainer />
      </div>
    );
  }
}

export default App;
