import React from "react";
import { Route, Redirect } from "react-router-dom";
import PropTypes from "prop-types";

const ProtectedRoute = props => {
  const { component: Component, ...rest } = props;

  let isAuthenticated = true;

  return (
    <Route
      {...rest}
      render={routeprops =>
        isAuthenticated ? <Component {...routeprops} /> : <Redirect to="/" />
      }
    />
  );
};

ProtectedRoute.propTypes = {
  component: PropTypes.func.isRequired
};

export default ProtectedRoute;
