import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class NewHolidayForm extends Component {
  constructor() {
    super();
    this.state = {
      title: "",
      description: "",
      imageUrl: "",
      type: "PUBLIC",
      isFlagRaised: ""
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
      .post("http://localhost:8081/Kutas-spring/api/holidays", this.state)
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
      isFlagRaised: ""
    });
  }

  render() {
    return (
      <div className="container-fluid ">
        <h1 class="display-2">ADD NEW HOLIDAY</h1>
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
            <label>Description</label>
            <textarea
              className="form-control"
              value={this.state.description}
              rows="3"
              onChange={this.handleChange.bind(this, "description")}
            />
          </div>
          <div className="form-group">
            <label>ImageUrl</label>
            <input
              type="text"
              className="form-control"
              value={this.state.imageUrl}
              placeholder="image url"
              onChange={this.handleChange.bind(this, "imageUrl")}
            />
          </div>
          <div className="form-group">
            <label>Type</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleChange.bind(this, "type")}
            >
              <option selected value="PUBLIC">
                PUBLIC
              </option>
              <option value="NATIONAL_RELIGIOUS">NATIONAL_RELIGIOUS</option>
              <option value="MEMORIAL">MEMORIAL</option>
              <option value="NON_TRADITIONAL">NON_TRADITIONAL</option>
            </select>
          </div>
          <div className="form-group">
            <label>Is flagged raised?</label>
            <select
              type="isFlagRaised"
              className="form-control"
              onChange={this.handleChange.bind(this, "isFlagRaised")}
            >
              <option selected value={true}>
                YES
              </option>
              <option value={false}>NO</option>
            </select>
          </div>
          <button type="submit" className="btn btn-info">
            submit
          </button>
        </form>
      </div>
    );
  }
}

export default NewHolidayForm;
