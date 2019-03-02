import React, { Component } from "react";
import NavigationComponent from "./components/Navigation/NavigationComponent";
import FooterComponent from "./components/Footer/FooterComponent";
import SideBarComponent from "./components/SideBar/SideBarComponent";

const App = props => {
  return (
    <React.Fragment>
      <NavigationComponent />
      <div className="container-fluid main-container  ">
        <div class="row justify-content-between">
          <div class=" col-lg-2 col-xl-2 col-md-3 col-sm-5 sb-style">
            <SideBarComponent />
          </div>
          <div class=" col-lg-10 col-xl-10 col-md-9 col-sm-9 ">
            {props.children}
          </div>
        </div>
      </div>
      <FooterComponent />
    </React.Fragment>
  );
};

export default App;
