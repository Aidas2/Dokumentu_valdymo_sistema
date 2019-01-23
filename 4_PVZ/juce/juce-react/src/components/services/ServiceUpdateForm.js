import React, { Component } from "react";
import Axios from "axios";

class ServiceUpdateForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      description: "",
      category: 0,
      price: 0.0,
      picture: "",
      providers: [],
      provider: "null"
    };
    this.services = 0;
  }

  componentDidMount = () => {
    Axios.get("http://localhost:8081/juce-spring/api/service-providers/titles")
      .then(res => this.setState({ providers: res.data }))
      .catch();
    Axios.get(
      "http://localhost:8081/juce-spring/api/services/" +
        this.props.match.params.title
    )
      .then(res => {
        console.log(res.data);
        this.setState(res.data);
      })
      .catch(err => console.log(err));
  };

  goBack = () => {
    this.props.history.goBack();
  };

  handleChange = event => {
    console.log("NAME: " + event.target.name + " VALUE: " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    //console.log(this.state);
    Axios.put(
      "http://localhost:8081/juce-spring/api/services/" +
        this.props.match.params.title,
      this.state
    )
      .then(res => {
        console.log(this.props.history);
        this.props.history.goBack();
      })
      .catch(err => console.log(err));
    //let newStudent = {firstname: this.state.firstname, lastname: this.state.lastname, email: this.state.email};
    //this.props.createStudent(newStudent);
  };

  availableProviders = () => {
    let providers = this.state.providers.map(prov => {
      return (
        <option key={prov} value={prov}>
          {prov}
        </option>
      );
    });
    return providers;
  };

  onClickAddProviderHandler = () => {
    Axios.put(
      "http://localhost:8081/juce-spring/api/services/" +
        this.props.match.params.title +
        "/" +
        this.state.provider
    )
      .then(res => console.log(res))
      .catch(err => console.log(err));
  };

  render = () => {
    return (
      <div className="panel panel-default my-3">
        <div className="panel-heading">Update Service</div>
        <div className="panel-body">
          <form className="form-inline" onSubmit={e => this.handleSubmit(e)}>
            <div className="form-group mb-2">
              <input
                disabled
                type="text"
                placeholder="Title"
                className="form-control"
                name="title"
                value={this.state.title}
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
                value={this.state.description}
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
                value={this.state.category}
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
                value={this.state.price}
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
                value={this.state.picture}
                onChange={this.handleChange}
                required
              />
            </div>
            <div className="form-group mb-2">
              <button className="btn btn-success" type="submit">
                Save
              </button>
              <button
                className="btn btn-warning mx-3"
                type="button"
                onClick={() => this.goBack()}
              >
                Back
              </button>
            </div>
          </form>
        </div>
        <div>Add Providers</div>
        <div className="form-group mb-8">
          <select
            id="inlineFormCustomSelect"
            className="form-control"
            name="provider"
            value={this.state.provider}
            onChange={this.handleChange}
          >
            <option defaultValue hidden>
              Choose here
            </option>
            {this.availableProviders()}
          </select>
          <button
            className="btn btn-warning"
            onClick={() => this.onClickAddProviderHandler()}
          >
            Add
          </button>
        </div>
      </div>
    );
  };
}

export default ServiceUpdateForm;
