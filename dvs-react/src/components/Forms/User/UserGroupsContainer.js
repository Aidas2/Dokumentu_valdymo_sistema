import React, { Component } from "react";
import PropTypes from "prop-types";
import axios from "axios";
import UserGroupsComponent from "./UserGroupsComponent";

class UserGroupsContainer extends Component {
  // state = { userGroups: [] };

  // componentDidMount() {
  //   axios
  //     .get("http://localhost:8081/api/groups")
  //     .then(response => {
  //       this.setState({ userGroups: response.data });
  //       // let userGroup = this.state.userGroup;
  //       // userGroup = response.data[0].title;
  //       // // createDocumentInfo.username = localStorage.getItem("username");
  //       // this.setState({ userGroup: userGroup });
  //       // this.setState({ documentType: response.data[0].title });
  //       // this.setState({ documentType: response.data[0].title });
  //     })
  //     .catch(error => {
  //       console.log(error);
  //     });
  //   console.log(
  //     "ComponentDidMount inside DocumentTYpesCOntainer >>>>>>>>>> this.state.userGroups>>>>.",
  //     this.state.userGroups
  //   );
  // }

  render() {
    // console.log("$$$$$$$$$ this.props >>>>>>>>>", this.props);
    // this.props.userGroups.length > 1
    //   ? console.log(
    //       "$$$$$$$$$ this.props.documentTypes[1].title >>>>>>>>>",
    //       this.props.userGroups[1].title
    //     )
    //   : console.log("$$$$$$$$$ Array does not contain at least 2 elements ");
    // console.log("$$$$$$$$$$ docTypesArray >>>>>>>>>");

    const UserGroupsArrayToRender = this.props.userGroups.map(oneGroup => {
      return (
        <UserGroupsComponent key={oneGroup.title} groupObject={oneGroup} />
      );
    });
    return (
      <select
        onChange={this.props.onUserGroupChange}
        className="form-control form-control-sm col-6 italic-style"
        id="userGroupSelect"
      >
        {UserGroupsArrayToRender}
      </select>
    );
  }
}

export default UserGroupsContainer;
