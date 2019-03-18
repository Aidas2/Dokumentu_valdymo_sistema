import React, { Component } from "react";
import NavigationComponent from "./components/Navigation/NavigationComponent";
import FooterComponent from "./components/Footer/FooterComponent";
import SideBarComponent from "./components/SideBar/SideBarComponent";

class App extends Component {
  state = {};

  render() {
    return (
      <React.Fragment>
        <NavigationComponent />
        <div className="container-fluid main-container  ">
          <div className="row justify-content-between">
            {/*  <FooterComponent /> */}
            <div className=" col-lg-3 col-xl-3 col-md-3 col-sm-5 sb-style no-padding">
              <SideBarComponent />
            </div>
            <div className=" col-lg-9 col-xl-9 col-md-9 col-sm-9 no-padding">
              {this.props.children}
            </div>
          </div>
        </div>

        <FooterComponent />
      </React.Fragment>
    );
  }
}

export default App;
