import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";

import Home from "./pages/Home";
import Login from "./pages/Login";
import DataTable from "./pages/DataTable";
import UserProfile from "./pages/UserProfile";

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact={true}>
        <Redirect to="/index" />
      </Route>
      <Route path="/index" exact={true}>
        <Home />
      </Route>
      <Route path="/datatable" exact={true}>
        <DataTable />
      </Route>
      <Route path="/login" exact={true}>
        <Login />
      </Route>
      <Route path="/profile" exact={true}>
        <UserProfile />
      </Route>
    </Switch>
  );
}
