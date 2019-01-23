import React from 'react';
import UserContext from '../../UserContext';
import NavigationComponent from './NavigationComponent';

class NavigationContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: ""
        };
    }

    handleChangeOnName = (event) => {     
        this.setState({ user: event.target.value });           
    }

    render() {
        return (
            <UserContext.Consumer>
                {
                    (userNameObject) => {
                        userNameObject.user = this.state.user
                       return  <NavigationComponent children={this.props.children} userName={this.state.user} handleChangeOnName={this.handleChangeOnName} />
                    }
                }
            </UserContext.Consumer>
        );
    }
}

export default NavigationContainer;