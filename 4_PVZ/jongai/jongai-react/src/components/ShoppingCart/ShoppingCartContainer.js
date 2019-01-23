import React from 'react';
import PropTypes from 'prop-types';
import ShoppingCartComponent from './ShoppingCartComponent';
//import MyProvider from '../App';
import axios from 'axios';
import { Link } from 'react-router-dom';

class ShoppingCartContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            products: '',
            loading: 'Shopping cart is empty.',
            user: ''
        };
    }

    componentDidMount() {
        const userLink = this.props.match.params.user;
        axios.get('http://localhost:8080/api/users/' + userLink + '/cart-products')
            .then((response) => {
                this.setState({ products: response.data });
                console.log("Gaunama produktų lentelė");
                console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    handleDeleteItem = (itemId) => {
        const userLink = this.props.match.params.user;
        axios.delete('http://localhost:8080/api/users/' + userLink + '/cart-products/' + (itemId))
            .then((response) => {
                axios.get('http://localhost:8080/api/users/' + userLink + '/cart-products')
                    .then((response) => {
                        this.setState({ products: response.data });
                        
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        if (this.state.products) {
            /*var testas = [
                {id: 1,
                image: "aa",
                title: "pavad"
                },
                {
                    id: 2,
                    image: "bb",
                    title: "bbbbpavad"
                }
            ] */
            
             //Šitas geras
             const productList = this.state.products.products.map((product, index) => {

             //Perdaryta eilutė
             //const productList = testas.map((product, index) => {
                return (
                    <ShoppingCartComponent
                        key={index}
                        id={product.id}
                        image={product.image}
                        title={product.title}
                        quantity={product.quantity}
                        handleDeleteItem={this.handleDeleteItem}
                    />
                );
            }); 
            return (<div className="container">

                <div className="row">
                    <div className="col-2">
                        <p>Product picture</p>
                    </div>
                    <div className="col-3">
                        <p>Product title</p>
                    </div>
                    <div className="col-1">
                        <p>Quantity</p>
                    </div>
                    <div className="col-3">
                        <p>Product #</p>
                    </div>
                </div>
                <div className="row">{productList}
                </div>
            </div>);
        }
        return this.state.loading;
    }
}

export default ShoppingCartContainer;
