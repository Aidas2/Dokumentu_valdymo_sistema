import React, { Component } from 'react';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import NavigationContainer from './components/Navigation/NavigationContainer';
import PageNotFoundComponent from './components/Other/PageNotFoundComponent/PageNotFoundComponent';
import HolidayListContainer from './components/HolidayList/HolidayListContainer';
import HolidayAdminContainer from './components/HolidayAdministration/HolidayAdminContainer';

class App extends Component {
  render() {
    return (
      <div className="container app-container">
        <BrowserRouter>
          <NavigationContainer>
            <Switch>
              <Route
                exact
                path="/"
                render={() => (
                  <HolidayListContainer/>
                )}
              />
              <Route path="/admin" component={HolidayAdminContainer} />
              <Route path="*" component={PageNotFoundComponent} />
            </Switch>
          </NavigationContainer>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
