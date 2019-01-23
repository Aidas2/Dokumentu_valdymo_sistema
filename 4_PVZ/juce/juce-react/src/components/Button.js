import React from "react";

const Button = props => {
  return (
    <button
      type="button"
      onClick={props.action}
      className={"btn " + props.type}
    >
      {props.title}
    </button>
  );
};

export default Button;
