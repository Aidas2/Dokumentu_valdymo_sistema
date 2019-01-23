import React from "react";

const Provider = props => {
  return (
    <tr>
      <th scope="row">{props.index}</th>
      <td>{props.title}</td>
      <td>{props.city}</td>
      <td>{props.code}</td>
      <td>{props.stars}</td>
      <td>{props.type}</td>
      <td className="d-flex justify-content-between">{props.children}</td>
    </tr>
  );
};

export default Provider;
