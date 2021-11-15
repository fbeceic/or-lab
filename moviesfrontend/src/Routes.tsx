import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";

import Home from "./pages/home/Home";
import DataTable from "./pages/datatable/DataTable";

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
    </Switch>
  );
}
