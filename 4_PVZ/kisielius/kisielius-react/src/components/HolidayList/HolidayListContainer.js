import React, { Component } from 'react';
import HolidayListComponent from './HolidayListComponent';
import axios from 'axios';

class HolidayListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      noHolidaysMessage: 'Holidays are loading...',
      emptyHolidaysMessage: 'There are no holidays at the moment'
    };
    this.styles = {
      holidaysContainer: {
        margin: '20px 20px 20px 20px'
      }
    };
  }

  componentDidMount() {
    this.getHolidaysList();
  }

  getHolidaysList = () => {
    axios
      .get('http://localhost:8080/api/holidays')
      .then(response => {
        this.setState({ holidaysList: response.data });
      })
      .catch(error => {
        this.setState({ noHolidaysMessage: '' + error });
      });
  };

  render() {
    if (this.state.holidaysList && this.state.holidaysList.length !== 0) {
      return (
        <div style={this.styles.holidaysContainer}>
          <HolidayListComponent
            holidaysList={this.state.holidaysList}
            toggleAddHoliday={this.toggleAddHoliday}
          />
        </div>
      );
    }
    if (this.state.holidaysList && this.state.holidaysList.length === 0) {
      return this.state.emptyHolidaysMessage;
    }
    return this.state.noHolidaysMessage;
  }
}

export default HolidayListContainer;
