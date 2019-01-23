import React from 'react';
import { Link } from 'react-router-dom';

const navigationComponent = (props) => {
  const styles = {
    pageContent: {
      border: '1px solid #343a40',
      borderRadius: '0px 0px 5px 5px',
      padding: '5px'
    },
    navbar: {
      borderRadius: '5px 5px 0px 0px'
    },
    loginMsg: {
      color: '#FAFFBD',
      fontSize: '12px'
    }
  };
  return (
    <div>
      <nav
        className="navbar navbar-expand-lg navbar-dark bg-dark"
        style={styles.navbar}
      >
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link className="btn btn-link nav-link" to="/">
                Holidays
              </Link>
            </li>
            <li className="nav-item">
              <Link className="btn btn-link nav-link" to="/admin">
                Admin
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
};

export default navigationComponent;
