import React from 'react';
import PropTypes from 'prop-types';
import pic from '../HolidayList/img/KingWear-KW06.jpg';
import { withRouter } from 'react-router';

//ar reikia jo? Ar pades jis? 
import { Link } from 'react-router-dom';

const HolidayAdministrationLineComponent = (props) => {
    
    var linkas = "/admin/holidays/" + props.title;
    return (
        <div className="container">
            <div className="row">
                <div className="col-2">
                <Link to={linkas}>{props.title}</Link> 
                    
                </div>
                <div className="col-2">
                    <img src={pic} alt="Smartphone" width="50px"></img>
                </div>
                <div className="col-8">
                    {/* senas budas
                    <a href={linkas}>{props.title}</a>
                    */}
                    <p>{props.description}</p>
                    
                    
                </div>
            </div>
        </div>
    );
    }


{/*

        <div className="card" style={{ width: "18rem" }}>
            <img className="card-img-top" src={pic} alt="Smartwatch"></img>
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-text">{props.description}</p>
                <p className="card-text">Price: {props.price} Euro</p>
                <p className="card-text">Quantity: {props.quantity} pcs.</p>
                <a href="#" className="btn btn-primary">Product details</a>
            </div>
        </div>
        );

    */}


{/*
ProductCardComponent.propTypes = {
    id: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired
};
*/}

export default withRouter(HolidayAdministrationLineComponent);