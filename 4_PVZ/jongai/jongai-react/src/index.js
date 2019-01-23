import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
//import * as serviceWorker from './serviceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Switch, Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import NoMatch from './components/Navigation/NoMatch';
import NavigationComponent from './components/Navigation/NavigationComponent';
import NavigationContainer from './components/Navigation/NavigationContainer';
import HolidayListContainer from './components/HolidayList/HolidayListContainer';
import NewHolidayContainer from './components/HolidayAdministration/NewHolidayContainer';
import UserContext from './UserContext';
import HolidayAdministrationListContainer from './components/HolidayAdministration/HolidayAdministrationListContainer';
import EditHolidayContainer from './components/HolidayAdministration/EditHolidayContainer';
import OneHolidayContainer from './components/HolidayList/OneHolidayContainer';
import ShoppingCartContainer from './components/ShoppingCart/ShoppingCartContainer';
import '../node_modules/jquery/dist/jquery';
import '../node_modules/popper.js/dist/popper';
import Pasimokyti from './Pasimokyti';

var DemonstruotiNavigacija = (props) => {
    var goHome = () => props.history.push("/");
    return (
        <div>          
            At route: {props.location.pathname}
            <button onClick={goHome}>Go Home</button>
            <pre>             
                {JSON.stringify(props, null, 1)}
            </pre>
        </div>
    );
};

ReactDOM.render((
    <BrowserRouter>
        <UserContext.Provider value={{user: "Jonas"}}>
            <NavigationContainer>
                <Switch>
                    <Route exact path='/' component={HolidayListContainer} />
                    <Route exact path="/holidays/:title" component={OneHolidayContainer} />
                    <Route exact path='/admin' component={HolidayAdministrationListContainer} />
                    {/* <Route exact path='/pasimokyti' component={Pasimokyti} />           */}
                    <Route exact path="/admin/holidays/new" component={NewHolidayContainer} />       
                    <Route exact path="/admin/holidays/:title" component={EditHolidayContainer} />   
                    {/* <Route exact path="/shopping-Cart/:user" component={ShoppingCartContainer} />                                */}
                    <Route path="*" component={NoMatch} />
                    <Route component={NoMatch} />
                </Switch>
            </NavigationContainer>
        </UserContext.Provider>
    </BrowserRouter>
), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
//serviceWorker.unregister();
