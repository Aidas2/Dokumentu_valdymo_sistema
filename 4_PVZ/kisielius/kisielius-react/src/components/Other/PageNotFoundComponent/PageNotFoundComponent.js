import React from 'react';

const pageNotFoundComponent = (props) => {
const styles = {
  notFound: { 
    margin: '50px auto',
    textAlign: 'center',
  },
  message: {
    color: 'red'
  }
}
return (
  <div style={styles.notFound}>
  <h4 style={styles.message}>Oops...This page does not exist!</h4>
  <button className="btn btn-link" onClick={() => props.history.push('/')}>Return Home</button>
  </div>
);
}

export default pageNotFoundComponent;