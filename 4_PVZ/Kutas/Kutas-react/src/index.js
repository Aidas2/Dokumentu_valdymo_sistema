import React from "react";
import ReactDOM from "react-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import HolidaysContainer from "./components/Holidays/HolidaysContainer";
import AdministrationContainer from "./components/Administration/AdministrationContainer";
import LandingPage from "./components/LandingPage";
import App from "./App";
import NewHolidayForm from "./components/Forms/NewHolidayForm";
import UpdateHolidayForm from "./components/Forms/UpdateHolidayForm";
import NewCountryForm from "./components/Forms/NewCountryForm";
import CountryToHolidayForm from "./components/Forms/CountryToHolidayForm";

ReactDOM.render(
  <BrowserRouter>
    <App>
      <Switch>
        <Route exact path="/" component={LandingPage} />
        <Route exact path="/holidays" component={HolidaysContainer} />
        <Route exact path="/holidays/:id" />
        <Route exact path="/admin" component={AdministrationContainer} />
        <Route exact path="/admin/holidays/new" component={NewHolidayForm} />
        <Route exact path="/admin/holidays/:id" component={UpdateHolidayForm} />
        <Route
          exact
          path="/admin/holidays/country/:id"
          component={CountryToHolidayForm}
        />
        <Route exact path="/admin/countries/new" component={NewCountryForm} />
        <Route exact path="/admin/countries/:id" />
      </Switch>
    </App>
  </BrowserRouter>,
  document.getElementById("root")
);
