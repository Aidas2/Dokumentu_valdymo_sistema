import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import logo from "../../images/home.png";

class CreateUserGroupsForm extends Component {
  constructor() {
    super();
    this.state = {};
  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .put(
        "http://localhost:8081/Bronza-spring/api/usergroups/" +
          this.props.match.params.id,
        this.state
      )
      .then(response => {
        console.log(response);
        this.props.history.push("/admin");
      })
      .catch(error => console.log(error));
    this.setState({
      title: "",
      description: "",
      imageUrl: "",
      type: "PUBLIC",
      Management: ""
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h2 className="display-6 normal-padding">Naujos grupės kūrimas</h2>

        <h5 className="display-6 normal-padding second-navigation-style ">
          <Link to={"/"}>
            <img src={logo} width="20" height="10" />
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin"} className="second-navigation">
            Administratoriaus rolė
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/usergroups"} className="second-navigation">
            Grupių sąrašas
          </Link>
          &ensp;/ &ensp;
          <Link to={"/admin/usergroups/new"} className="second-navigation">
            Naujos grupės kūrimas
          </Link>
        </h5>

        <input
          className="form-control"
          type="text"
          placeholder="Naujos grupės pavadinimas"
        />

        <div className="form-group">
          <label>
            Ar ši nauja grupė turi dokumentų priėmimo ir atmetimo funkciją?
          </label>
          <select
            type="Management"
            className="form-control"
            onChange={this.handleChange.bind(this, "Management")}
          >
            <option selected value={true}>
              Taip
            </option>
            <option value={false}>Ne</option>
          </select>
        </div>

        <button type="submit" className="btn btn-outline-success m-2">
          Kurti naują grupę
        </button>
      </div>
    );
  }
}

export default CreateUserGroupsForm;
