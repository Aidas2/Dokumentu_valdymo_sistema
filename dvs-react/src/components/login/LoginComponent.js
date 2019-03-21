import React from "react";
import main_icon from "../../images/main_icon.png";

const LoginComponent = (
  { username, pass, onPassChange, onUsernameChange, onSubmit },
  context
) => {
  return (
    <div className="container-fluid main-container  ">
      <div className="row justify-content-between">
        <div className=" col-lg-6 col-xl-6 col-md-6 ">
          <div>
            <img
              src={main_icon}
              className=" center-block picture-padding"
              alt="main icon"
            />
          </div>
        </div>
        <div
          className=" col-lg-6 col-xl-5 col-md-6
         login-style"
        >
          <h1 className="display-6 ">Įveskite prisijungimo informaciją</h1>
          <input
            className="form-control login-form-style "
            type="text"
            onChange={onUsernameChange}
            placeholder="Įveskite prisijungimo vardą "
          />
          <input
            onChange={onPassChange}
            className="form-control login-form-style"
            type="password"
            placeholder="Jūsų slaptažodis"
          />

          <button
            onClick={onSubmit}
            className="btn btn-outline-success login-button"
          >
            Prisijungti
          </button>
        </div>
      </div>
    </div>
  );
};

export default LoginComponent;
