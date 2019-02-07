import React from "react";
import ReactDOM from "react-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import UserGroupsContainer from "./components/UserGroups/UserGroupsContainer";
import AdministrationContainer from "./components/Administration/AdministrationContainer";
import LandingPage from "./components/LandingPage";
import App from "./App";
import CreateUserGroupsContainer from "./components/UserGroups/CreateUserGroupsContainer";
import CreateUserGroupsForm from "./components/Forms/CreateUserGroupsForm";
import FileUploadContainer from "./components/FileUpload/FileUploadContainer";
import DocumentTypesContainer from "./components/FileUpload/DocumetTypesContainer";

ReactDOM.render(
  <BrowserRouter>
    <App>
      <Switch>
        <Route exact path="/" component={LandingPage} />
        <Route exact path="/usergroups" component={UserGroupsContainer} />
        <Route exact path="/usergroups/:id" />
        <Route exact path="/admin" component={AdministrationContainer} />
        <Route exact path="/upload" component={FileUploadContainer} />
        <Route
          exact
          path="/api/doctypescontainer"
          component={DocumentTypesContainer}
        />

        <Route
          exact
          path="/admin/usergroups"
          component={CreateUserGroupsContainer}
        />

        <Route
          exact
          path="/admin/usergroups/new"
          component={CreateUserGroupsForm}
        />
      </Switch>
    </App>
  </BrowserRouter>,
  document.getElementById("root")
);
