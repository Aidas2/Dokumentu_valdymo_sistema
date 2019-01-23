import React from 'react';
import '../HolidayAdministrationComponent.css';

const holidayAddComponent = (props) => {
  const styles = {
    msgSuccess: {color: 'green', textAlign: 'center', marginTop: '10px'},
    msgDanger: {color: 'red', textAlign: 'center', marginTop: '10px'}
  }
  return (

    <form onSubmit={(event) => props.submitHoliday(event)}>
      <p>Add new Component</p>
      <div className="row">
        <div className="col-md-4">
          <input type="text" className="form-control" name="title" placeholder="Title" />
        </div>
        <div className="col-md-4">
          <input type="text" className="form-control" name="picture" placeholder="Picture" />
        </div>
        <div className="col-md-2">
          <input type="text" className="form-control" name="description" placeholder="Description" />
        </div>
        <div className="col-md-2">
          <input type="text" className="form-control" name="type" placeholder="Type" />
        </div>
        <div className="col-md-12 text-center">
        <input className="form-check-input" name="flag" type="checkbox" value="" id="defaultCheck1" />
        <label className="form-check-label" htmlFor="defaultCheck1">
        Flag raise
       </label>
        </div>
      </div>
      <div className="text-center">
        <button className="btn btn-outline-secondary btn-sm" type="submit">Submit</button>
      </div>
      {props.holidayAdded.status ?
        <div style={styles.msgSuccess}>{props.holidayAdded.message}</div> :
        <div style={styles.msgDanger}>{props.holidayAdded.message}</div>}
    </form>
  );
}

export default holidayAddComponent;