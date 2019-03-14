import React, { Component } from "react";

const LoginComponent = (
  { email, pass, onPassChange, onEmailChange, onSubmit },
  context
) => {
  return (
    <form onSubmit={onSubmit}>
      <input type="text" value={email} onChange={onEmailChange} />
      <input type="password" value={pass} onChange={onPassChange} />
      <input type="submit" />
    </form>
  );
};

export default LoginComponent;
