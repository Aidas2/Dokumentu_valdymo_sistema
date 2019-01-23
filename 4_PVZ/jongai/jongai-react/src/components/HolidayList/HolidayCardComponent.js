import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';
import {Link} from 'react-router-dom';

/* var styles = {
    tekstoFonas: { background: 'red' },
    tekstoSpalva: { color: 'green' }
    }; */

const HolidayCardComponent = (props) => {
    var linkas = "/holidays/" + props.title;
    return (
        <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="Smartwatch"></img>
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">{props.description}</p>
                <p className="card-text">Type: {props.type}</p>
                <p className="card-text">Rise flag: {props.flag}</p>
                <Link className="btn btn-primary" to={linkas}>Holiday details</Link>
            </div>
        </div>
        );
}

HolidayCardComponent.propTypes = {
    //id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    type: PropTypes.number.isRequired,
    flag: PropTypes.bool.isRequired
};

export default HolidayCardComponent;