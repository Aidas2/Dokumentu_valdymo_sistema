import React, { Component } from 'react';
import ProductListContainer from './components/ProductList/ProductListContainer';
import Produktas from './Produktas/Produktas';
import './App.css';

var productList = [
  {
    id: 6,
    title: "Smartwatch KingWear KW06",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW06 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 56.01,
    quantity: 10
  },
  {
    id: 1,
    title: "Smartwatch KingWear KW01",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW01 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 6.05,
    quantity: 1
  },
  {
    id: 2,
    title: "Smartwatch KingWear KW02",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW02 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 15.15,
    quantity: 8
  },
  {
    id: 3,
    title: "Smartwatch KingWear KW03",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW03 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 116.11,
    quantity: 15
  },
  {
    id: 4,
    title: "Smartwatch KingWear KW04",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW04 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 25.19,
    quantity: 5
  },
  {
    id: 5,
    title: "Smartwatch KingWear KW05",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW05 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 89.89,
    quantity: 6
  },
  {
    id: 7,
    title: "Smartwatch KingWear KW07",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW07 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 1.15,
    quantity: 16
  },
  {
    id: 8,
    title: "Smartwatch KingWear KW08",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW08 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 9.01,
    quantity: 2
  },
  {
    id: 9,
    title: "Smartwatch KingWear KW09",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW09 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 16.01,
    quantity: 10
  },
  {
    id: 10,
    title: "Smartwatch KingWear KW10",
    image: "img/KingWear-KW06.jpg",
    description: "KingWear KW10 Smart Watch Android 5.1 OS 512GB Ram 8GB Rom MTK6580 Quad Core 3G GPS WiFi Wristwatch Heart Rate Pedometer watch",
    price: 4.44,
    quantity: 3
  }
]

//--------------------------------------------------------

var filteredProductList = productList.filter(product => product.price <= 10);

class App extends Component {

  goProducts = () => this.props.history.push("products");

  render() {
    return (
      
        <div className="App">
          <p><button onClick={this.goProducts} className="btn btn-primary" role="button">Go to Products</button></p>
          <ProductListContainer products={filteredProductList} />         
        </div>
      
    );
  }
}

export default App;
