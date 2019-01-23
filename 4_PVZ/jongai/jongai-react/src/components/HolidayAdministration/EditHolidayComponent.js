import React from 'react';
import PropTypes from 'prop-types';

const EditProductComponet = (props) => {
    
    return (
        <form >
            <div className="form-row">
                <div className="col-md-12 mb-12">
                    <p>{props.fromMenu}</p>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault01">Holiday title</label>
                    <input type="text" className="form-control" id="validationDefault01" placeholder="" value={props.currentTitle} required onChange={props.handleChangeOfTitle}></input>
                </div>
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault02">Image</label>
                    <input type="text" className="form-control" id="validationDefault02" placeholder="" value={props.currentImage} required onChange={props.handleChangeOfImage}></input>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-8 mb-3">
                    <label htmlFor="validationDefault03">Description</label>
                    <input type="text" className="form-control" id="validationDefault03" placeholder="" value={props.currentDescription} required onChange={props.handleChangeOfDescription}></input>
                </div>
            </div>
            <div className="form-row">
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault04">Type</label>
                    <input type="text" className="form-control" id="validationDefault04" placeholder="" value={props.currentType} required onChange={props.handleChangeOfType}></input>
                </div>
                <div className="col-md-4 mb-3">
                    <label htmlFor="validationDefault05">Flag</label>
                    <input type="text" className="form-control" id="validationDefault05" placeholder="" value={props.currentFlag} required onChange={props.handleChangeOfFlag}></input>
                </div>
            </div>
            <button className="btn btn-primary" type="submit" onClick={props.handleSubmit}>Save</button>
            <button className="btn btn-primary" onClick={props.handleDelete}>Delete</button>
        </form>
    );
}

export default EditProductComponet;