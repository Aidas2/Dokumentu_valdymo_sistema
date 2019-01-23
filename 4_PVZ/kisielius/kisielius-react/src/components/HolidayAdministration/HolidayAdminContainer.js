import React, { Component } from 'react';
import axios from 'axios';
import HolidayAdminComponent from './HolidayAdminComponent';
import HolidayAddContainer from './HolidayAdd/HolidayAddContainer';

class HolidayAdminContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      noHolidaysMessage: 'Holidays are loading...',
      showAddNewHolidayForm: false
    };
    this.styles = {
      holidaysContainer: {
        margin: '20px 20px 20px 20px'
      },
      msgSuccess: {color: 'green', textAlign: 'center', marginTop: '10px'}
    };
  }

  componentDidMount() {
    this.getHolidaysList();
  }

  toggleAddHoliday = () => {
    this.setState({ showAddNewHolidayForm: !this.state.showAddNewHolidayForm });
  };

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

  removeFromList = title => {
    if (this.state.holidaysList) {
      for (let i = 0; i < this.state.holidaysList.length; i++) {
        if (this.state.holidaysList[i].title === title) {
          axios
            .delete(`http://localhost:8080/api/holidays/${title}`)
            .then(response => this.getHolidaysList())
            .catch(error => console.log(error));
        }
      }
    }
  }

  afterHolidayAdd = () => {
    setTimeout(() => {
      this.setState({showAddNewHolidayForm: false});
    }, 3000);
    this.getHolidaysList();
  }

  render() {
    if (this.state.holidaysList) {
      return (
        <div style={this.styles.holidaysContainer}>
          <button className="btn btn-secondary" onClick={this.toggleAddHoliday}>
            New Holiday
          </button>
          {this.state.showAddNewHolidayForm ? (
            <HolidayAddContainer afterHolidayAdd={this.afterHolidayAdd} />
          ) : null}
          <HolidayAdminComponent
            holidaysList={this.state.holidaysList}
            toggleAddHoliday={this.toggleAddHoliday}
            removeFromList={this.removeFromList}
          />
        </div>
      );
    }
    return this.state.noHolidaysMessage;
  }
}
export default HolidayAdminContainer;
