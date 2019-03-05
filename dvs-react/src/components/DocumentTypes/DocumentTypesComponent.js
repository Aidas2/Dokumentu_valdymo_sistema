import React from "react";

const DocumentTypesComponent = props => {
  return (
    <div className="container pl-0 ml-0">
      <div className="row">
        <div className="col-12 padding-normal">
          {props.typeId}

          {props.typeTitle}
        </div>
      </div>
    </div>
  );
};

export default DocumentTypesComponent;
