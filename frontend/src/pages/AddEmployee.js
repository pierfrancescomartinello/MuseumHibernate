import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import GroupIcon from "@material-ui/icons/Group";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(7),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: "100%",
  },
}));

export default function AddEmployee() {
  const classes = useStyles();
  const [firstLoad, setLoad] = React.useState(true);

  const [name, setFirstName] = React.useState("");
  const [surname, setLastName] = React.useState("");
  const [dob, setDob] = React.useState("");
  const [salary, setSalary] = React.useState("");
  const [workingHours, setWorkingHours] = React.useState("");

  const handleName = (event) => setFirstName(event.target.value);
  const handleSurname = (event) => setLastName(event.target.value);
  const handleDobChange = (event) => setDob(event.target.value);
  const handleSalary = (event) => setSalary(event.target.value);
  const handleWorkingHours = (event) => setWorkingHours(event.target.value);

  async function sampleFunc(toInput) {
    // eslint-disable-next-line
    const response = await fetch("/api/employee", {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *client
      body: JSON.stringify(toInput), // body data type must match "Content-Type" header
    });
  }

  const handleSubmit = (variables) => {
    const toInput = { name, surname, dob, salary, workingHours };
    sampleFunc(toInput);

    setFirstName("");
    setLastName("");
    setDob("");
    setSalary("");
    setWorkingHours("");
    console.log(toInput);
  };

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  return (
    <Container component="main" maxWidth="xs" style={{ marginTop: 100 }}>
      <div className={classes.paper} >
        <Avatar className={classes.avatar}>
          <GroupIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Employee Directory
        </Typography>
        <form className={classes.form} noValidate>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
            <TextField
                variant="outlined"
                fullWidth
                id="name"
                value={name}
                label="First name"
                name="name"
                autoComplete="name"
                onChange={handleName}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="surname"
                name="surname"
                variant="outlined"
                fullWidth
                value={surname}
                id="surname"
                label="Last name"
                onChange={handleSurname}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                autoComplete="dob"
                name="dob"
                variant="outlined"
                fullWidth
                value={dob}
                id="dob"
                label="Date of birth"
                onChange={handleDobChange}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                variant="outlined"
                fullWidth
                id="salary"
                value={salary}
                label="Salary"
                name="Salary"
                autoComplete="Salary"
                onChange={handleSalary}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                variant="outlined"
                fullWidth
                id="workingHours"
                value={workingHours}
                label="Working Hours"
                name="workingHours"
                autoComplete="workingHours"
                onChange={handleWorkingHours}
              />
            </Grid>
            <Grid item xs={12}>
            </Grid>
          </Grid>
          <Button
            // type="submit"
            fullWidth
            variant="contained"
            color="primary"
            //preventDefault
            className={classes.submit}
            onClick={handleSubmit}
            style={{ color: "#FFFFFF", backgroundColor: "#d18570", fontWeight: "bold" }}
          >
            Save
          </Button>

          <Grid container justify="center">
            <Grid item>
              <Button
                style={{ color: "#FFFFFF", backgroundColor: "#d18570", fontWeight: "bold" }}
                color="primary" 
                variant="contained" 
                component={Link} 
                to="/employees">
                  VIEW EMPLOYEES
                </Button>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );
}
