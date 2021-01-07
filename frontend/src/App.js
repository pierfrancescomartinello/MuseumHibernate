import React, { Component } from "react";
import AddEmployee from "./Components/AddEmployee";
import { Route, BrowserRouter as Router } from "react-router-dom";
import Table from "./Components/Table";
import SignIn from "./Components/SignIn";

class App extends Component {
  render() {
    return (
      <SignIn />
      /*
      <Router>
        <Route exact path="/" component={AddEmployee} />
        <Route exact path="/view" component={Table} />
      </Router>
      */
    );
  }
}

export default App;
