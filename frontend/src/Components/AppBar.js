import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import IconButton from "@material-ui/core/IconButton";
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";
import HomeIcon from "@material-ui/icons/Home";
import ConfirmationNumberIcon from "@material-ui/icons/ConfirmationNumber";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    marginBottom: "50px"
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function ButtonAppBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <AppBar position="fixed" style={{ backgroundColor: "#d18570" }}>
        <Toolbar>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="menu"
            component={Link}
            to="/"
          >
            <HomeIcon />
          </IconButton>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="menu"
            component={Link}
            to="/tickets"
          >
            <ConfirmationNumberIcon />
          </IconButton>
          <span style={{"fontSize": "23px", "marginTop":"-3px", "paddingLeft": "5px"}}><b>Museum</b></span>
          {/*
          <IconButton
            edge="start"
            color="inherit"
            aria-label="menu"
            component={Link}
            to="/addemployees"
          >
            <SettingsIcon />
          </IconButton>
          */}
          <Typography variant="h6" className={classes.title}></Typography>
          <Link to="/login">
            <Button
              color="default"
              type="button"
              style={{ color: "#FFFFFF", fontWeight: "bold"}}
            >
              Log in
            </Button>
          </Link>
          <Link to="/signup">
            <Button
              color="default"
              type="button"
              style={{ color: "#FFFFFF", fontWeight: "bold" }}
            >
              Sign up
            </Button>
          </Link>
        </Toolbar>
      </AppBar>
    </div>
  );
}
