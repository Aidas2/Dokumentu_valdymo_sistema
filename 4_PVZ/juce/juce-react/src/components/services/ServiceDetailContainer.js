import React, { Component } from "react";
import Details from "../Details";
import Button from "../Button";
import Axios from "axios";
import Provider from "../providers/Provider";

class ServiceDetailContainer extends Component {
  constructor(props) {
    super(props);
    this.state = { service: "", providers: [] };
  }

  componentDidMount() {
    Axios.get(
      "http://localhost:8081/juce-spring/api/services/" +
        this.props.match.params.title
    )
      .then(res => {
        console.log(res.data);
        this.setState({ service: res.data });
      })
      .catch(err => {
        console.log(err);
      });

    this.getAllProviders();
  }

  getAllProviders = () => {
    Axios.get(
      "http://localhost:8081/juce-spring/api/services/" +
        this.props.match.params.title +
        "/all-providers"
    )
      .then(res => {
        console.log(res.data);
        this.setState({ providers: res.data });
      })
      .catch(err => {
        console.log(err);
      });
  };

  onClickGoBackHandler = () => {
    this.props.history.goBack();
  };

  onClickUpdateHandler = () => {
    this.props.history.push("/service/update/" + this.props.match.params.title);
  };

  onDeleteClickHandler = title => {
    Axios.delete(
      "http://localhost:8081/juce-spring/api/services/" +
        this.state.service.title +
        "/" +
        title
    )
      .then(res => {
        console.log(res);
        this.getAllProviders();
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

  render() {
    let category;
    switch (this.state.service.category) {
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
      <div className="container my-3">
        <div className="row d-flex justify-content-center">
          <Details
            title={this.state.service.title}
            description={this.state.service.description}
            category={category}
            price={this.state.service.price}
            picture={this.state.service.picture}
          >
            <Button
              title="Go Back"
              type="btn-warning"
              action={this.onClickGoBackHandler}
            />
            <Button
              title="Update"
              type="btn-warning"
              action={this.onClickUpdateHandler}
            />
          </Details>
        </div>
        <div>
          <table className="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">City</th>
                <th scope="col">Code</th>
                <th scope="col">Price</th>
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

export default ServiceDetailContainer;
