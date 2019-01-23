import React, { Component } from 'react';
import NavigationComponent from './NavigationComponent';

class NavigationContainer extends Component {

  render() {
    const styles = {
      border: '1px solid #343a40',
      borderRadius: '0px 0px 5px 5px',
      padding: '5px'
    };
    return (
      <>
        <NavigationComponent/>
        <div style={styles}>{this.props.children}</div>
      </>
    );
  }
}
export default NavigationContainer;
