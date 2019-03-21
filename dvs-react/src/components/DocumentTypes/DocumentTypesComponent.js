import React from "react";

const DocumentTypesComponent = props => {
  return (
    <div className="row users-padding-bottom">
      <div className="col-1 documents-table-size">{props.typeId}</div>
      <div className="col-11 documents-table-size">{props.typeTitle}</div>
    </div>
  );
};

export default DocumentTypesComponent;
