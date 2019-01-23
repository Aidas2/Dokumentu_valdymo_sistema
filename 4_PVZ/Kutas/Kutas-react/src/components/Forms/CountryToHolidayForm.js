import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class CountryToHolidayForm extends Component {
  constructor() {
    super();
    this.state = {
      allCountryList: [],
      chosenCountryId: ""
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8081/api/countries/")
      .then(response =>
        this.setState(
          {
            allCountryList: response.data
          },
          console.log(response.data)
        )
      )
      .catch(error => console.log(error));
  }

  handleChange(name, event) {
    let change = {};
    change[name] = event.target.value;
    this.setState(change);
  }

  handleSubmit(event) {
    event.preventDefault();
    axios
      .get(
        "http://localhost:8081/Kutas-spring/api/holidays/" +
          this.props.match.params.id +
          "/country/" +
          this.state.chosenCountryId
      )
      .then(response => {
        console.log(response);
        this.props.history.push("/admin");
      })
      .catch(error => console.log(error));
    this.setState({
      allCountryList: "",
      chosenCountryId: ""
    });
  }

  countriesToOptions() {
    return this.state.allCountryList.map(country => (
      <option value={country.id}>{country.title}</option>
    ));
  }

  render() {
    return (
      <div className="container-fluid ">
        <h1 class="display-2">ADD COUNTRY TO HOLIDAY</h1>
        <form className="container" onSubmit={this.handleSubmit.bind(this)}>
          <div className="form-group">
            <label>Choose a country</label>
            <select
              type="text"
              className="form-control"
              onChange={this.handleChange.bind(this, "chosenCountryId")}
            >
              {this.countriesToOptions()}
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

export default CountryToHolidayForm;
