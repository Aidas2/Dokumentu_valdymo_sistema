import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class NewCountryForm extends Component {
  constructor() {
    super();
    this.state = {
      title: "",
      imageUrl: "",
      president: ""
    };
  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .post("http://localhost:8081/Kutas-spring/api/countries", this.state)
      .then(response => {
        console.log(response);
        this.props.history.push("/admin");
      })
      .catch(error => console.log(error));
    this.setState({
      title: "",
      imageUrl: "",
      president: ""
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h1 class="display-2">ADD NEW COUNTRY</h1>
        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              className="form-control"
              value={this.state.title}
              placeholder="title"
              onChange={this.handleChange.bind(this, "title")}
            />
          </div>
          <div className="form-group">
            <label>ImageUrl</label>
            <input
              type="text"
              className="form-control"
              value={this.state.imageUrl}
              placeholder="flag image url"
              onChange={this.handleChange.bind(this, "imageUrl")}
            />
          </div>
          <div className="form-group">
            <label>President</label>
            <input
              type="text"
              className="form-control"
              value={this.state.presidentl}
              placeholder="president"
              onChange={this.handleChange.bind(this, "president")}
            />
          </div>

          <button type="submit" className="btn btn-info">
            submit
          </button>
        </form>
      </div>
    );
  }
}

export default NewCountryForm;
