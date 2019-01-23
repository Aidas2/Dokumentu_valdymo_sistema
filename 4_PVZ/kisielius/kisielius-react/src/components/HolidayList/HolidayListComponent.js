import React from 'react';
import PropTypes from 'prop-types';
import HolidayCardContainer from './HolidayCard/HolidayCardContainer';

const holidayListComponent = (props) => {
  const holidaysList = props.holidaysList.map((holiday) => {
    return (
      <HolidayCardContainer
        key={Math.floor(Math.random() * 100 + 1) * 117}
        title={holiday.title}
        description={holiday.description}
        image={holiday.image}
        type={holiday.type}
      />
    );
  });
  return (
    <div>
      {holidaysList}
    </div>
  );
}

holidayListComponent.propTypes = {
  holidaysList: PropTypes.array.isRequired
}

export default holidayListComponent;