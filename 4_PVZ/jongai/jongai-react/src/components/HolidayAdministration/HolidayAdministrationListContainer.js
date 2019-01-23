import React from 'react';
import PropTypes from 'prop-types';
import HolidayAdministrationLineComponent from './HolidayAdministrationLineComponent';
//import MyProvider from '../App';
import axios from 'axios';
import {Link} from 'react-router-dom';

class HolidayAdministrationListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            holidays: '',
            loading: 'Loading holidays. Please wait...'
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/holidays')
            .then((response) => {
                this.setState({ holidays: response.data });
                //console.log(response.data);
                //console.log("Produktai yra - " + this.state.holidays);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.holidays) {
            const productCards = this.state.holidays.map((product, index) => {
                return (
                    <HolidayAdministrationLineComponent
                        key={index}
                        title={product.title}
                        image={product.image}
                        description={product.description}
                    />
                );
            });
            return (<div className="container">
                         <div className="row">
                         <Link className="btn btn-success" to="/admin/holidays/new">Add new holiday</Link>
                         </div>
                         <div className="row">
                            <div className="col-2">
                                <p>Holiday</p>
                            </div>
                            <div className="col-2">
                                <p>Picture</p>
                            </div>
                            <div className="col-8">
                                <p>Description</p>
                            </div>
                        </div>
                        <div className="row">{productCards}
                        </div>
                    </div>);
        }
        return this.state.loading;
    }
}

export default HolidayAdministrationListContainer;
