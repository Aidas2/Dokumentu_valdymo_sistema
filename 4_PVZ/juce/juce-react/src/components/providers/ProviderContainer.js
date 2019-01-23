import React, { Component } from "react";
import Axios from "axios";

import Provider from "./Provider";
import Button from "../Button";
import ProviderForm from "./ProviderForm";

class ProviderContainer extends Component {
  constructor(props) {
    super(props);
    this.state = { providers: [] };
  }

  getAllData = () => {
    Axios.get("http://localhost:8081/juce-spring/api/service-providers")
      .then(res => {
        //console.log(res.data);
        this.setState({ providers: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  //   onDetailsClickHandler = title => {
  //     Axios.get(
  //       "http://localhost:8081/juce-spring/api/services/" +
  //         title +
  //         "/all-providers"
  //     )
  //       .then(res => {
  //         console.log("Getting all providers for: " + title);
  //         console.log(res.data);
  //         this.props.history.push("/service/" + title);
  //       })
  //       .catch(err => {
  //         console.log(err);
  //       });
  //   };
  onDeleteClickHandler = title => {
    console.log(title);
    Axios.delete(
      "http://localhost:8081/juce-spring/api/service-providers/" + title
    )
      .then(res => {
        console.log("Deleting: " + title);
        this.getAllData();
      })
      .catch(err => {
        console.log(err);
      });
  };

  showAllData = () => {
    let data = this.state.providers.map((p, index) => {
      return (
        <Provider
          key={p.title}
          index={index + 1}
          title={p.title}
          city={p.city}
          code={p.code}
          stars={p.stars}
          type={p.type}
          {...this.props}
        >
          <Button
            title="Delete"
            action={() => this.onDeleteClickHandler(p.title)}
            type="btn-warning"
          />
        </Provider>
      );
    });
    return data;
  };

  componentDidMount = () => {
    this.getAllData();
  };

  render() {
    return (
      <div className="container">
        <div className="row my-3">
          <ProviderForm {...this.props} />
        </div>
        <div className="row">
          <table className="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">City</th>
                <th scope="col">Code</th>
                <th scope="col">Stars</th>
                <th scope="col">Type</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>{this.showAllData()}</tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ProviderContainer;
