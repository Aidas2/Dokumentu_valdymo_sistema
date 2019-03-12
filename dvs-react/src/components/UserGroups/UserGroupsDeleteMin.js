import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class UserGroups extends React.Component {
  constructor() {
    super();
    this.state = {};
  }
  deleteHandler(event) {
    event.preventDefault();
    axios
      .delete("http://localhost:8081/api/userGroupss/delete/" + this.props.id)
      .then(response => {
        console.log(response);
      })
      .catch(error => console.log(error));
  }

  render() {
    return (
      <div className="card m-2">
        <h5 className="card-header">{this.props.type}</h5>
        <div className="card-body">
          <h5 className="card-title">{this.props.title}</h5>
          <p className="card-text">{this.props.description}</p>
          <Link
            to={"/admin/usergroup/" + this.props.id}
            className="btn btn-outline-success m-2 button-color"
          >
            update
          </Link>
          <Link
            to={"/admin/usergroup/" + this.props.id}
            className="btn btn-outline-success m-2 button-color"
          >
            add user group
          </Link>
          <form onSubmit={this.deleteHandler.bind(this)}>
            <button
              type="submit"
              className="btn btn-outline-success m-2 button-color"
            >
              delete
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default UserGroups;
