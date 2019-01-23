import React, { Component } from "react";
import Axios from "axios";

class ProviderForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      city: "",
      code: 0,
      stars: 0,
      type: 0
    };
  }

  handleChange = event => {
    // console.log("NAME: " + event.target.name + " VALUE: " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    console.log(this.state);
    Axios.post(
      "http://localhost:8081/juce-spring/api/service-providers/add",
      this.state
    )
      .then(res => {
        console.log(this.props.history);
        this.props.history.go("/providers");
      })
      .catch(err => console.log(err));
    //let newStudent = {firstname: this.state.firstname, lastname: this.state.lastname, email: this.state.email};
    //this.props.createStudent(newStudent);
  };

  render = () => {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Create Provider</div>
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
                placeholder="City"
                className="form-control"
                name="city"
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-2">
              <input
                type="number"
                step="0.01"
                placeholder="Stars"
                className="form-control"
                name="stars"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <input
                type="number"
                placeholder="Code"
                className="form-control"
                name="code"
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <select
                required
                id="inlineFormCustomSelect"
                placeholder="Type"
                className="form-control"
                name="type"
                onChange={this.handleChange}
              >
                <option defaultValue disabled>
                  Type...
                </option>
                <option value="0">National</option>
                <option value="1">Enterprise</option>
                <option value="2">Individual</option>
              </select>
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

export default ProviderForm;
