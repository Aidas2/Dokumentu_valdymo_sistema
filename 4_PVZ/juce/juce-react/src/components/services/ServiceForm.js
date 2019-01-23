import React, { Component } from "react";
import Axios from "axios";

class ServiceForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      description: "",
      category: 0,
      price: 0.0,
      picture: ""
    };
  }

  handleChange = event => {
    // console.log("NAME: " + event.target.name + " VALUE: " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    //console.log(this.state);
    Axios.post("http://localhost:8081/juce-spring/api/services/add", this.state)
      .then(res => {
        console.log(this.props.history);
        this.props.history.go("/");
      })
      .catch(err => console.log(err));
    //let newStudent = {firstname: this.state.firstname, lastname: this.state.lastname, email: this.state.email};
    //this.props.createStudent(newStudent);
  };

  render = () => {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Create Service</div>
        <div className="panel-body">
          <form className="form-inline" onSubmit={e => this.handleSubmit(e)}>
            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Title"
                className="form-control"
                name="title"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Description"
                className="form-control"
                name="description"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <select
                required
                id="inlineFormCustomSelect"
                placeholder="Category"
                className="form-control"
                name="category"
                onChange={this.handleChange}
              >
                <option defaultValue disabled>
                  Category...
                </option>
                <option value="0">IT</option>
                <option value="1">Transport</option>
                <option value="2">Foreman</option>
                <option value="3">Beauty</option>
                <option value="4">Training</option>
              </select>
            </div>
            <div className="form-group mb-2">
              <input
                type="number"
                step="0.01"
                placeholder="Price"
                className="form-control"
                name="price"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <input
                type="text"
                placeholder="Picture"
                className="form-control"
                name="picture"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <button className="btn btn-success" type="submit">
                Save
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  };
}

export default ServiceForm;
