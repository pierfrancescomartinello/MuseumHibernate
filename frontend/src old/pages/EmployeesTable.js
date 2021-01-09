import React, { Component } from "react";
import AddEmployee from "./Components/AddEmployee";
import { Route, BrowserRouter as Router } from "react-router-dom";
import Table from "./Components/Table";
import {JsonToTable} from "react-json-to-table"; 

class EmployeesTable extends Component {
  state = {
    todos: []
  }
  componentDidMount() {
    // root needs to be implicit
    fetch('/api/employees')
    .then(res => res.json())
    .then((data) => {
      this.setState({ todos: data })
      console.log(this.state.todos)
    })
    .catch(console.log)
  }
  render() {

    return (
      <div><JsonToTable json={this.state.todos} /></div>
    );
  }
}

export default EmployeesTable