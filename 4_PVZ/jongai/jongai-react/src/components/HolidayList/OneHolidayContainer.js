import React from 'react';
import {Component} from 'react';
import PropTypes from 'prop-types';
import OneHolidayComponent from './OneHolidayComponent';
import axios from 'axios';
import UserContext from '../../UserContext';
import AddToCartComponent from './AddTopCartComponent';

class OneHolidayContainer extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            title: "",
            description: '',
            type: '',
            
            //image: "",
            //description: "",
            flag: false
            
        };
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! užkomentavau, nes man atrodo, kad čia aš eksperimentavau
        //this.userName = this.context;
        
    }
    
     handleAddToCart = (userName) => {      
        console.log("--------------vartotojo vardas yra " + userName);
        axios.post('http://localhost:8080/api/users/' + userName + '/cart-products', this.state)
        
            .then((response) => {
                console.log("Sėkminga" + response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    handleChangeOfQuantity = (event) => {
        this.setState({ quantity: event.target.value });
        console.log(this.state.quantity);
      }



    componentDidMount() {
        const position = this.props.match.params.title;
        axios.get('http://localhost:8080/holidays/' + (position))
            .then((response) => {
                //this.setState(response.data);
                console.log("-----------------Response data id yra: " + response.data.id);
                console.log("-----------------Response data title yra: " + response.data.title);
                this.setState({ title: response.data.title,
                                description: response.data.description,
                                type: response.data.type,
                                flag: response.data.flag
                })
                
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        return (
            <div>
                <OneHolidayComponent title={this.state.title}
                                    description={this.state.description}
                                    type={this.state.type}
                                    //dabar taip
                                    flag={this.state.flag}
                                    //buvo taip
                                    //------quantity={this.state.quantity}
                                    //handleAddToCart={this.handleAddToCart}
                                    //handleChangeOfQuantity={this.handleChangeOfQuantity}
                  />
                {/* <UserContext.Consumer>
                {
                    (userNameObject) => {
                       return <AddToCartComponent userName={userNameObject.user} handleAddToCart={this.handleAddToCart} handleChangeOfQuantity={this.handleChangeOfQuantity}/>
                    }
                } 
                </UserContext.Consumer>  */}
            </div>
        );
    }
}

export default OneHolidayContainer;