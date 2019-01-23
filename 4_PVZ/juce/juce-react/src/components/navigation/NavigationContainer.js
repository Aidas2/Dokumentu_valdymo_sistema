import React from "react";
import { Route, BrowserRouter, Switch } from "react-router-dom";

import ServiceContainer from "../services/ServiceContainer";
import ServiceDetailContainer from "../services/ServiceDetailContainer";
import Navigation from "./Navigation";
import ProviderContainer from "../providers/ProviderContainer";
import ServiceUpdateForm from "../services/ServiceUpdateForm";

import ImageUploader from "../imageuploader/ImageUploader";

const NavigationContainer = () => {
  return (
    <div>
      <BrowserRouter>
        <div>
          <Navigation />
          <Switch>
            <Route path="/" exact component={ServiceContainer} />
            <Route path="/providers" component={ProviderContainer} />
            <Route
              path="/service/:title"
              component={ServiceDetailContainer}
              exact
            />
            <Route
              path="/service/update/:title"
              component={ServiceUpdateForm}
            />
            <Route path="/uploader" exact component={ImageUploader} />
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
};

export default NavigationContainer;
