import React from 'react';
import PropTypes from 'prop-types';
import pic from '../HolidayList/img/KingWear-KW06.jpg';
import { withRouter } from 'react-router';

const ShoppingCartComponent = (props) => {
    console.log("Is krepselio komponento");
    console.log(props.id);   
 
    return (
        <div className="container">
            <div className="row">
                <div className="col-2">
                    <img src={pic} alt="Smartphone" width="50px"></img>
                </div>
                <div className="col-3">
                    <p>{props.title}</p>
                </div>
                <div className="col-1">
                    <p>{props.quantity}</p>
                </div>
                <div className="col-3">
                   <button className="btn btn-primary" onClick={props.handleDeleteItem.bind(this, props.id)}>Delete item</button>
                </div>
            </div>
            
        </div>
    );
    }

export default withRouter(ShoppingCartComponent);