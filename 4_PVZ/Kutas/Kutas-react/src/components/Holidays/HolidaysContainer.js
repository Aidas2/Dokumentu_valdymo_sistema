import React, { Component } from "react";
import axios from "axios";
import HolidaysComponent from "./HolidaysComponent";

class HolidaysContainer extends Component {
  constructor() {
    super();
    this.state = {
      holidayList: null
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8081/Kutas-spring/api/holidays")
      .then(response =>
        this.setState({
          holidayList: response.data
        })
      )
      .catch(error => console.log(error));
  }

  render() {
    if (this.state.holidayList === null) {
      return <p />;
    } else {
      return <HolidaysComponent holidayList={this.state.holidayList} />;
    }
  }
}

export default HolidaysContainer;
