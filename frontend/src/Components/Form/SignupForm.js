import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import { useHistory } from "react-router-dom";

const TextFieldEmail = () => {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [dob, setDob] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();

  const handleClick = () => {
    // POST request to /api/account, email and password only
    let url = "/api/account";
    let requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        email: email,
        password: password,
        isLoggedIn: 0,
      }),
    };

    fetch(url, requestOptions).then((res) => res.json());

    // POST request to /api/visitor
    url = "/api/visitor";
    requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name: name,
        surname: surname,
        dateOfBirth: dob,
        dateOfSignUp: new Date()
          .toJSON()
          .slice(0, 10)
          .replace(/-/g, "-")
          .toString(),
        email: email,
      }),
    };

    fetch(url, requestOptions)
      .then((res) => res.json())
      .then((json) => {
        alert("Succesful signup!");
        history.push("/");
      });
  };

  return (
    <form>
      <TextField
        variant="outlined"
        margin="normal"
        fullWidth
        name="name"
        label="Name"
        type="name"
        autoComplete="current-name"
        autoFocus
        value={name}
        onChange={(event) => {
          setName(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <TextField
        variant="outlined"
        margin="normal"
        fullWidth
        name="surname"
        label="Surname"
        autoComplete="current-surname"
        autoFocus
        value={surname}
        onChange={(event) => {
          setSurname(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <TextField
        variant="outlined"
        margin="normal"
        fullWidth
        name="dob"
        label="Date of birth"
        autoComplete="current-dob"
        autoFocus
        value={dob}
        onChange={(event) => {
          setDob(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <TextField
        variant="outlined"
        margin="normal"
        fullWidth
        name="email"
        label="Email"
        type="email"
        autoComplete="current-email"
        autoFocus
        value={email}
        onChange={(event) => {
          setEmail(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <TextField
        variant="outlined"
        margin="normal"
        fullWidth
        name="password"
        label="Password"
        type="password"
        id="password"
        autoComplete="current-password"
        autoFocus
        value={password}
        onChange={(event) => {
          setPassword(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <div style={{ padding: "1.5%" }}></div>
      <Button
        fullWidth
        variant="contained"
        color="primary"
        onClick={handleClick}
      >
        Sign up
      </Button>
    </form>
  );
};
export default TextFieldEmail;
