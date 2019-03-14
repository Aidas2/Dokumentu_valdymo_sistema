import React from "react";
import ReactDOM from "react-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import UserGroupsContainer from "./components/UserGroups/UserGroupsContainer";
import AdministrationContainer from "./components/Administration/AdministrationContainer";
//import LandingPage from "./components/LandingPage";
import App from "./App";
import CreateUserGroupsContainer from "./components/UserGroups/CreateUserGroupsContainer";
import FileUploadContainer from "./components/FileUpload/FileUploadContainer";
import DocumentTypesContainer from "./components/DocumentTypes/DocumentTypesContainer";
import CreateDocumentTypeConatainer from "./components/Forms/DocumentType/CreateDocumentTypeContainer";
import CreateUserContainer from "./components/Forms/User/CreateUserContainer";
import UsersContainer from "./components/Users/UsersContainer";
import FileDownloadConatainer from "./components/FileDownload/FileDownloadContainer";
import LandingPageContainer from "./components/LandingPageContainer";
import DocumentsContainer from "./components/Documents/DocumentsContainer";
import UserDetailsContainer from "./components/Users/UserDetailsContainer";
import UserGroupDetailsContainer from "./components/UserGroups/UserGroupDetailsContainer";
import "./styles.css";
import RenderResponse from "./components/FileDownload/RenderResponse";
import DocumentDetailsContainer from "./components/Documents/DocumentDetailsContainer";
import UpdateUserContainer from "./components/Forms/User/UpdateUserContainer";
import LoginContainer from "./components/login/LoginContainer";

// const urlToGetDocs = "http://localhost:8081/api/docs";

ReactDOM.render(
  <BrowserRouter>
    <App>
      <Switch>
        {/* <Route exact path="/" component={LandingPageContainer} /> */}
        <Route exact path="/" component={LoginContainer} />
        <Route exact path="/usergroups" component={UserGroupsContainer} />
        <Route exact path="/usergroups/:id" />
        <Route exact path="/admin" component={AdministrationContainer} />
        <Route exact path="/upload" component={FileUploadContainer} />
        <Route exact path="/download" component={FileDownloadConatainer} />
        <Route
          exact
          path="/admin/newdoctype"
          component={CreateDocumentTypeConatainer}
        />
        <Route
          exact
          path="/admin/doctypes"
          component={DocumentTypesContainer}
        />{" "}
        <Route exact path="/admin/newuser" component={CreateUserContainer} />
        <Route exact path="/admin/users" component={UsersContainer} />
        <Route
          exact
          path="/admin/updateuser/:username"
          component={UpdateUserContainer}
        />
        {/* <Route
          exact
          path="/admin/docs"
          render={props => (
            <DocumentsContainer {...props} requestUrl={urlToGetDocs} />
          )}
        /> */}
        <Route exact path="/admin/docs" component={DocumentsContainer} />
        <Route
          exact
          path="/admin/docs/:id"
          component={DocumentDetailsContainer}
        />
        <Route exact path="/docs" component={DocumentsContainer} />
        <Route exact path="/testing" component={RenderResponse} />
        <Route exact path="/admin/usergroups" component={UserGroupsContainer} />
        <Route
          exact
          path="/admin/usergroups/:title"
          component={UserGroupDetailsContainer}
        />
        <Route
          exact
          path="/admin/users/:username"
          component={UserDetailsContainer}
        />
        <Route
          exact
          path="/admin/newusergroup"
          component={CreateUserGroupsContainer}
        />
      </Switch>
    </App>
  </BrowserRouter>,
  document.getElementById("root")
);
