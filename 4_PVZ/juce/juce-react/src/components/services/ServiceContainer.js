import React, { Component } from "react";
import Axios from "axios";

import Service from "./Service";
import Button from "../Button";
import ServiceForm from "./ServiceForm";

class ServiceContainer extends Component {
  constructor(props) {
    super(props);
    this.state = { services: [] };
    this.searchBy = ["", ""];
  }

  getAllData = () => {
    Axios.get("http://localhost:8081/juce-spring/api/services")
      .then(res => {
        //console.log(res.data);
        this.setState({ services: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  onDetailsClickHandler = title => {
    Axios.get(
      "http://localhost:8081/juce-spring/api/services/" +
        title +
        "/all-providers"
    )
      .then(res => {
        console.log("Getting all providers for: " + title);
        console.log(res.data);
        this.props.history.push("/service/" + title);
      })
      .catch(err => {
        console.log(err);
      });
  };
  onDeleteClickHandler = title => {
    Axios.delete("http://localhost:8081/juce-spring/api/services/" + title)
      .then(res => {
        console.log("Deleting: " + title);
        this.getAllData();
      })
      .catch(err => {
        console.log(err);
      });
  };

  showAllData = () => {
    let data = this.state.services.map((s, index) => {
      let category;
      switch (s.category) {
        case 0:
          category = "It";
          break;
        case 1:
          category = "Transport";
          break;
        case 2:
          category = "Foreman";
          break;
        case 3:
          category = "Beauty";
          break;
        case 4:
          category = "Training";
          break;
      }
      return (
        <Service
          key={s.title}
          index={index + 1}
          title={s.title}
          description={s.description}
          category={category}
          price={s.price}
          picture={s.picture}
          {...this.props}
        >
          <Button
            title="Details"
            action={() => this.onDetailsClickHandler(s.title)}
            type="btn-success"
          />
          <Button
            title="Delete"
            action={() => this.onDeleteClickHandler(s.title)}
            type="btn-warning"
          />
        </Service>
      );
    });
    return data;
  };

  componentDidMount = () => {
    this.getAllData();
  };

  handleChange = event => {
  
    if (event.target.value !== "") {
      Axios.get(
        "http://localhost:8081/juce-spring/api/services/filter/" +
          event.target.value
      )
        .then(res => {
          //console.log(res.data);
          this.setState({ services: res.data });
        })
        .catch(err => {
          console.log(err);
        });
    } else {
      this.getAllData();
    }
  };

  handleSearchByTitlteDescription = event => {
    if (event.target.name === "title") {
      this.searchBy[0] = event.target.value;
    }
    if (event.target.name === "description") {
      this.searchBy[1] = event.target.value;
    }

    if (this.searchBy[0] !== "" || this.searchBy[1] !== "") {
      console.log(this.searchBy);
      Axios.post(
        "http://localhost:8081/juce-spring/api/services/filters/",
        this.searchBy
      )
        .then(res => {
          //console.log(res.data);
          this.setState({ services: res.data });
        })
        .catch(err => {
          console.log(err);
        });
    } else if (this.searchBy[0] === "" && this.searchBy[1] === "") {
      this.getAllData();
    }
  };

  render() {
    return (
      <div className="container">
        {/* //////////////////////////////////////////////// */}
        <div className="row my-3">
          <div className="col-xs-1">
            <label htmlFor="exampleInputName2" className="col-form-label mr-3">
              Filter by title
            </label>
          </div>
          <div className="col-xs-2">
            <input
              type="text"
              className="form-control"
              onChange={this.handleChange}
              placeholder="title..."
            />
          </div>
        </div>
        {/* ////////////////////////////////// */}
        <div className="row my-3">
          <div className="col-xs-1">
            <label htmlFor="exampleInputName2" className="col-form-label mr-3">
              Filter by:
            </label>
          </div>
          <div className="col-xs-1">
            <input
              type="text"
              className="form-control"
              onChange={this.handleSearchByTitlteDescription}
              placeholder="title..."
              name="title"
            />
          </div>

          <div className="col-xs-2">
            <input
              type="text"
              className="form-control"
              onChange={this.handleSearchByTitlteDescription}
              placeholder="description..."
              name="description"
            />
          </div>
        </div>
        {/* ////////////////////////////////// */}
        <div className="row">
          <ServiceForm {...this.props} />
        </div>
        <div className="row">
          <table className="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Picture</th>
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

ServiceContainer.propTypes = {};

export default ServiceContainer;
