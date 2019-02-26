import React, { Component } from "react";
import NavigationComponent from "./components/Navigation/NavigationComponent";
import FooterComponent from "./components/Footer/FooterComponent";

const App = props => {
  return (
    <React.Fragment>
      <NavigationComponent />
      {props.children}
      <FooterComponent />
    </React.Fragment>
  );
};

export default App;
