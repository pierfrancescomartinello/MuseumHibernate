import React from "react";
import { Route, BrowserRouter as Router } from "react-router-dom";
import AddEmployee from "./pages/AddEmployee";
import AppBar from "./components/AppBar";
import EmployeesTable from "./pages/EmployeesTable";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import Home from "./pages/Home";
import Pricing from "./pages/Pricing";
import ConfirmYoungTicket from "./pages/ConfirmYoungTicket";
import ConfirmAdultTicket from "./pages/ConfirmAdultTicket";
import Dashboard from "./pages/Dashboard";
import AreaHub from "./pages/AreaHub";
import Baroque from "./pages/Area/Baroque";
import Cubism from "./pages/Area/Cubism";
import Impressionism from "./pages/Area/Impressionism";
import Renaissance from "./pages/Area/Renaissance";
import Artwork from "./pages/Area/Artwork";


export default function App() {
  return (
    <Router>
      <div>
        <AppBar />
        <Route path="/" exact component={Home} />
        <Route path="/tickets" exact component={Pricing} />
        <Route path="/employees" exact component={EmployeesTable} />
        <Route path="/addemployees" exact component={AddEmployee} />
        <Route path="/login" exact component={Login} />
        <Route path="/signup" exact component={Signup} />
        <Route path="/confirmYoungTicket" component={ConfirmYoungTicket} />
        <Route path="/confirmAdultTicket" component={ConfirmAdultTicket} />
        <Route path="/dashboard" component={Dashboard} />
        <Route path="/areaHub" exact component={AreaHub} />
        <Route path="/areaHub/Cubism" exact component={Cubism} />
        <Route path="/areaHub/Renaissance" exact component={Renaissance} />
        <Route path="/areaHub/Baroque" exact component={Baroque} />
        <Route path="/areaHub/Impressionism" exact component={Impressionism} />
        <Route path="/areaHub/Renaissance/artwork" component={Artwork} />
      </div>
    </Router>
  );
}
