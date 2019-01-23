import React, { Component } from "react";
import Holiday from "./Holiday";

class HolidaysComponent extends Component {
  render() {
    let holidaysList = this.props.holidayList.map(holiday => (
      <Holiday
        id={holiday.id}
        key={holiday.id}
        title={holiday.title}
        description={holiday.description}
        imageUrl={holiday.imageUrl}
        type={holiday.type}
        isFlagRaised={holiday.isFlagRaised}
      />
    ));
    return (
      <div className="container-fluid">
        <h1 className="display-2">YOUR HOLIDAYS</h1>
        <div className="row">{holidaysList}</div>;
      </div>
    );
  }
}

export default HolidaysComponent;
