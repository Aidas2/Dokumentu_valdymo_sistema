import React from 'react';
import PropTypes from 'prop-types';
import pic from './img/KingWear-KW06.jpg';
import { Link } from 'react-router-dom';
import UserContext from '../../UserContext';
// Stilius importuoju iš css failo
import './styles.css';

const OneHolidayComponent = (props) => {
    return (
        <div className="container">
            <div className="row">
                <div className="col-2">
                    <img src={pic} alt="Smartphone" width="150px"></img>
                </div>
                <div className="col-3">
                    <h5>{props.title}</h5>
                    <p>{props.description}</p>
                    <p>{props.type}</p>
                    <p>flag: {props.flag} pcs.</p>
                </div>
            </div>
        </div>
    );
}

/*
OneProductComponent.propTypes = {
    id:PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};*/


export default OneHolidayComponent;