import React, { Component } from "react";
import NavigationComponent from "./components/Navigation/NavigationComponent";

const App = props => {
  return (
    <React.Fragment>
      <NavigationComponent />
      {props.children}
    </React.Fragment>
  );
};

export default App;
