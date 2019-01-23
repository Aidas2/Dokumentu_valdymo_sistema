import React, { Component } from 'react';
import HolidayAddComponent from './HolidayAddComponent';
import axios from 'axios';

class HolidayAddContainer extends Component {
  state = {
    holidayAdded: {
      status: false,
      message: null
    }
  }

  submitHoliday = (event) => {
    event.preventDefault();
    event.stopPropagation();
    event.persist();
    const holiday = {
      title: event.target.title.value,
      description: event.target.description.value,
      image: event.target.picture.value,
      type: event.target.type.value,
      flagRaise: event.target.flag.checked
    }
    axios.post('http://localhost:8080/api/holidays', holiday)
      .then((response) => {
        event.target.reset();
        this.setState({ holidayAdded: {status: true, message: 'Holiday added successfully'} });
        this.props.afterHolidayAdd();
      })
      .catch((error) => {
        console.log(error);
        this.setState({ holidayAdded: {status: false, message: 'Something went wrong'} });
      });
  }

  render() {
    return (
      <HolidayAddComponent
        submitHoliday={this.submitHoliday}
        holidayAdded={this.state.holidayAdded}
      />
    );
  }
}

export default HolidayAddContainer;
