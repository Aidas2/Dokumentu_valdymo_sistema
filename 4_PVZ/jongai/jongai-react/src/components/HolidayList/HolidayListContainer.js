import React from 'react';
import PropTypes from 'prop-types';
import HolidayCardComponent from './HolidayCardComponent';
import axios from 'axios';

class HolidayListContainer extends React.Component {
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
                console.log("Koks atiduodamas švenčių sąrašas?");
                console.log(this.state.holidays);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    render() {
        if (this.state.holidays) {
            const holidayCards = this.state.holidays.map((holiday, index) => {
                //Čia patikrinu ar ten yra reikšmių
                /* if (product.productDetails == null) {    
                    return (
                        <HolidayCardComponent
                            key={index}
                            id={product.id}
                            title={product.title}
                            image="null"
                            description="null"
                            price={product.price}
                            quantity={product.quantity}
                        />
                    );
                } */

                return (
                    <HolidayCardComponent
                        key={index}
                        title={holiday.title}
                        description={holiday.description}
                        image={holiday.image}  
                        type={holiday.type}
                        flag={holiday.flag}
                    />
                );
            });
            return (<div className="row">{holidayCards}</div>);
        }
        return this.state.loading;
    }
}

export default HolidayListContainer;