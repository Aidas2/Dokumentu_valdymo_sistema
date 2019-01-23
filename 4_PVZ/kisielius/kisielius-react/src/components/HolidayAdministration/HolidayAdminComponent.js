import React from 'react';
import PropTypes from 'prop-types';
import HolidayAdminCardComponent from './HolidayAdminCard/HolidayAdminCardComponent';

const holidayAdminComponent = (props) => {
  const holidaysList = props.holidaysList.map((holiday) => {
    return (
      <HolidayAdminCardComponent
        key={Math.floor(Math.random() * 100 + 1) * 117}
        holiday={holiday}
        removeFromList={props.removeFromList}
      />
    );
  });
  return (
    <div>
      {holidaysList}
    </div>
  );
}

holidayAdminComponent.propTypes = {
  holidaysList: PropTypes.array.isRequired
}

export default holidayAdminComponent;