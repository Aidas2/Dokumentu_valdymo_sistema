import React from 'react';
import image from '../../HolidayList/HolidayCard/holiday-2103171_960_720.jpg'

const holidayAdminCardComponent = (props) => {
  const styles = {
    cardContainer: {
      margin: '20px 0'
    },
    card: {
      padding: '0px',
    },
    image: {
      maxWidth: '100%',
      height: 'auto'
    },
    buttonUpdate: {
      marginRight: '5px'
    }
  }
  return (
    <div style={styles.cardContainer}>
      <div className="card col-md-12" style={styles.card}>
        <div className="card-header">
          {props.holiday.title}
        </div>
        <div className="card-body row">
          <div className="col-md-3 col-sm-12">
            <img src={image} alt={props.holiday.title} style={styles.image} />
          </div>
          <div className="col-md-9 col-sm-12 row">
            <div className="col-md-9 col-sm-12">
              <h5 className="card-title">Description:&nbsp;{props.holiday.description}</h5>
              <p className="card-text">Type:&nbsp;{props.holiday.type}</p>
            </div>
            <div>
              <button className="btn btn-outline-secondary" onClick={() => props.removeFromList(props.holiday.title)}>Remove</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default holidayAdminCardComponent;