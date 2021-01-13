import React from "react";
import clsx from "clsx";
import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import UserInfo from "../components/Dashboard/UserInfo";
import Tickets from "../components/Dashboard/Tickets";
import AppbarLoggedIn from "../components/AppbarLoggedIn";

const useStyles = makeStyles((theme) => ({
  appBarSpacer: theme.mixins.toolbar,
  container: {
    paddingTop: theme.spacing(4),
    paddingBottom: theme.spacing(4),
  },
  paper: {
    padding: theme.spacing(2),
    display: "flex",
    overflow: "auto",
    flexDirection: "column",
  },
  fixedHeight: {
    height: 240,
  }
}));

export default function Dashboard() {
  const classes = useStyles();

  return (
    <div className={classes.root} style={{backgroundColor: "#dac0b8", minHeight:"100vh"}}>
    <AppbarLoggedIn />
      <main className={classes.content}>
        <div className={classes.appBarSpacer} />
        <Container maxWidth="lg" className={classes.container}>
          <Grid container spacing={3}>
            {/* User infos */}
            <Grid item xs={12}>
              <Paper className={clsx(classes.paper)}>
                <UserInfo />
              </Paper>
            </Grid>
            {/* Tickets */}
            <Grid item xs={12}>
              <Paper className={classes.paper}>
                <Tickets />
              </Paper>
            </Grid>
          </Grid>
          <Box pt={4}></Box>
        </Container>
      </main>
    </div>
  );
}
