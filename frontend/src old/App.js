import React, { Component } from "react";
import { Route, BrowserRouter as Router } from "react-router-dom";
import AddEmployee from "./pages/AddEmployee";
import AppBar from "./components/AppBar";
import EmployeesTable from "./pages/EmployeesTable";
import Pricing from "./pages/Pricing";
import Table from "./pages/Table";

class App extends Component {
  render() {
    return (
      [
        <Router key="router">
          <AppBar key="appbar" />
          <Route exact path="/" component={AddEmployee} />
          <Route exact path="/employees" component={EmployeesTable} />
        </Router>
      ]
    );
  }
}

export default App;
