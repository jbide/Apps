import React from "react";
import { Route, Switch } from "react-router-dom";
import PropTypes from "prop-types";
import TodoListPage from "./TodoListPage";
import TodoManagePage from "./TodoManagePage";

const TodoRoutes = props => {
  return (
    <Switch>
      <Route path={props.match.path} exact component={TodoListPage} />
      <Route path={`${props.match.path}/:id`} component={TodoManagePage} />
    </Switch>
  );
};

TodoRoutes.propTypes = {
  match: PropTypes.object.isRequired
};

export default TodoRoutes;
