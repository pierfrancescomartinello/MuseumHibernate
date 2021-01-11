import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import { useHistory } from "react-router-dom";

const TextFieldEmail = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();

  const handleClick = () => {
    let url = "login?email=" + email + "&password=" + password;

    fetch(url, { method: "Get" })
      .then((res) => res.json())
      .then((json) => {
        if (json === false) {
          console.log("Wrong email and / or password, please try again.");
          alert("Wrong email and / or password, please try again.");
        } else {
          history.push("/dashboard/" + email);  
        }
      });
  };

  return (
    <form>
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
        //  className={classes.submit}
        onClick={handleClick}
      >
        Sign In
      </Button>
    </form>
  );
};
export default TextFieldEmail;
