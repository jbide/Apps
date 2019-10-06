import React from "react";
import Header from "./common/Header";
import { Switch, Route } from "react-router-dom";
import HomePage from "./home/HomePage";
import ProtectedRoute from "./common/ProtectedRoute";
import TodoRoutes from "./todo/TodoRoutes";

const App = () => {
  return (
    <div>
      <Header />
      <Switch>
        <Route path="/" exact component={HomePage} />
        <ProtectedRoute path="/todos" component={TodoRoutes} />
      </Switch>
    </div>
  );
};

export default App;
