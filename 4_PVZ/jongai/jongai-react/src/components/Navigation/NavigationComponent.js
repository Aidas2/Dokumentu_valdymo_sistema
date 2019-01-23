import React from 'react';
import { Link } from 'react-router-dom';
import UserContext from '../../UserContext';

var NavigationComponent = (props) => {
    return (

        <div>
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <Link to='/'>Home</Link> |&nbsp;
                            </li>
                            <li className="nav-item active">
                                <Link to='/admin'>Administration</Link> |&nbsp;
                            </li>
                            <li className="nav-item active">
                                {/*Cia yra nematomi punktai - nezinau ar jie reikalingi, kad navigavimas veiktu*/}
                                <Link to={`/products/${1}`}></Link>
                            </li>
                        </ul>
                        {/* <form className="form-inline">
                            <input type="text" className="form-control mr-sm-2" onChange={props.handleChangeOnName}
                                value={props.userName} name="currentUser" placeholder="User"></input>
                        </form>
                        <UserContext.Consumer>
                            {
                                (userNameObject) => {
                                    let linkas = "/shopping-Cart/" + userNameObject.user;
                                    return <Link className="btn btn-success" to={linkas} >Shopping cart</Link>
                                }
                            }
                        </UserContext.Consumer> */}
                    </div>
                </nav>
            </div>
            {props.children}
        </div>);

};

export default NavigationComponent;

