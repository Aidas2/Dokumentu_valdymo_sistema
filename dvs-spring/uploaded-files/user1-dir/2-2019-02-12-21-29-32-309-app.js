var styles = {
  thumbnail: {
    maxWidth: '242px',
    textAlign: 'center',
    marginLeft: 'auto',
    marginRight: 'auto'
  },
  image: { width: '100%', height: '200px', display: 'block'}
};

class ProductCardComponent extends React.Component {
  render() {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="thumbnail" style={styles.thumbnail}>
          <img src={this.props.image} style={styles.image} alt="..."/>
          <div className="caption">
            <h3>{this.props.title}</h3>
            <p>{this.props.description}</p>
            <p>{this.props.price} Eur</p>
            <p><button className="btn btn-primary" role="button">Details</button></p>
          </div>
        </div>
      </div>
    );
  }
};

ProductCardComponent.propTypes = {
  id: PropTypes.number.isRequired,
  id: PropTypes.number.isRequired,
  image: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
};

var ProductListComponent = (props) => {
  var productCards = props.products.map(function (product, index) {
    return (
      <ProductCardComponent
        key={index}
        id={product.id}
        image={product.image}
        title={product.title}
        description={product.description}
        price={product.price}
      />
    );
  });
  return (<div className="row">{productCards}</div>);
};

/*
class ProductListComponentKlase extends React.Component {
  render() {
	  var productCards = this.props.products.map(function (product, index) {
	    return (
	      <ProductCardComponent
		key={index}
		id={product.id}
		image={product.image}
		title={product.title}
		description={product.description}
		price={product.price}
	      />
	    );
	  });
	  return (<div className="row">{productCards}</div>);
 }
};
*/

ProductListComponent.propTypes = {
  products: PropTypes.array.isRequired,
};

var testProducts = [
  {
    id: 1,
    image: 'samsung.jpg',
    title: 'Telephons',
    description: 'Fainas',
    price:2.5
  },
  {
    id: 2,
    image: 'samsung.jpg',
    title: 'Telephons 2',
    description: 'Fainas',
    price:2.7
  },
  {
    id: 3,
    image: 'samsung.jpg',
    title: 'Telephons 3',
    description: 'Fainas',
    price:2.8
  }
];

ReactDOM.render(<ProductListComponent products={testProducts} />, document.getElementById('root'));
