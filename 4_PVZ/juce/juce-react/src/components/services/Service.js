import React from "react";

const Service = props => {
  return (
    <tr>
      <th scope="row">{props.index}</th>
      <td>{props.title}</td>
      <td>{props.description}</td>
      <td>{props.category}</td>
      <td>{props.price}</td>
      <td>
        <img
          height="150px"
          width="200px"
          src={props.picture}
          alt={props.title}
        />
      </td>
      <td className="d-flex justify-content-between">{props.children}</td>
    </tr>
  );
};

export default Service;
