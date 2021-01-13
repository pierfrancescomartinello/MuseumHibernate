import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";

const TextFieldEmail = () => {
  const [visitDate, setDate] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  //const history = useHistory();

  const handleClick = () => {
    // sends a GET request to verify credentials, then tries to complete the purchase
    let signInURL = "login?email=" + email + "&password=" + password;
    fetch(signInURL, { method: "GET" })
      .then((res) => res.json())
      .then((json) => {
        if (json === false) {
          console.log("Wrong email and / or password, please try again.");
          alert("Wrong email and / or password, please try again.");
        } else {
          let visitorIdURL = "login/visitorId?email=" + email;

          fetch(visitorIdURL, { method: "GET" })
            .then((res) => res.json())
            .then((json) => {
              if (json[0] === null)
                console.log("No visitor is registered to this email address.");
              else {
                let visitorId = json[0];
                console.log("Logged in.");

                let url = "/api/ticket";
                let requestOptions = {
                  method: "POST",
                  headers: { "Content-Type": "application/json" },
                  body: JSON.stringify({
                    ticketType: "Young",
                    visitDate: visitDate,
                    purchaseDate: new Date()
                      .toJSON()
                      .slice(0, 10)
                      .replace(/-/g, "-")
                      .toString(),
                    usable: 1,
                    visitor: visitorId, // a query gets the correct visitorId and assigns it to the ticket
                    ticketPrice: 5.0,
                  }),
                };

                fetch(url, requestOptions)
                  .then((res) => res.json())
                  .then((json) => {
                    if (json === false) console.log("Something went wrong.");
                    else {
                      alert("Young ticket succesfully bought!");
                      //history.push("/")
                    }
                  });
              }
            });
        }
      });
  };

  return (
    <form>
      <TextField
        variant="outlined"
        margin="normal"
        color="secondary"
        fullWidth
        name="visitDate"
        label="Visit date"
        autoComplete="current-date"
        autoFocus
        value={visitDate}
        onChange={(event) => {
          setDate(event.target.value);
        }} //whenever the text field change, you save the value in state
      />
      <TextField
        variant="outlined"
        color="secondary"
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
        color="secondary"
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
        style={{ color: "#FFFFFF", backgroundColor: "#d18570", fontWeight: "bold" }}
        //  className={classes.submit}
        onClick={handleClick}
      >
        Sign In
      </Button>
    </form>
  );
};
export default TextFieldEmail;
