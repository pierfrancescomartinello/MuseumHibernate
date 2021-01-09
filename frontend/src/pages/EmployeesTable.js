import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import GroupIcon from "@material-ui/icons/Group";
import { Link } from "react-router-dom";
import Typography from "@material-ui/core/Typography";
import CircularProgress from "@material-ui/core/CircularProgress";

const useStyles = makeStyles(theme => ({
  table: {
    minWidth: 600
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  paper: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    margin: `10px`,
    height: "100%",
    width: "99%",
    marginTop: theme.spacing(7)
  },
  link: {
    color: "rgba(0,0,0,0.65)",
    textDecoration: "none",
    marginLeft: "10%",
    alignSelf: "flex-start",
    "&:hover": {
      color: "rgba(0,0,0,1)"
    }
  }
}));

export default function EmployeesTable() {
  const classes = useStyles();

  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);
  let isLoading = true;

  async function sampleFunc() {
    let response = await fetch("/api/employee");
    let body = await response.json();
    upDateData(body);
  }

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  if (data.length > 0) isLoading = false;

  return (
    <div className={classes.paper}>
      <Avatar className={classes.avatar}>
        <GroupIcon />
      </Avatar>
      <Typography component="h1" variant="h5">
        Employee Directory
      </Typography>

      {isLoading ? (
        <CircularProgress />
      ) : (
        <TableContainer
          style={{ width: "80%", margin: "0 10px" }}
          component={Paper}
        >
          <Table className={classes.table} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell align="center">ID</TableCell>
                <TableCell align="center">Name</TableCell>
                <TableCell align="center">Surname</TableCell>               
                <TableCell align="center">Date of birth</TableCell>
                <TableCell align="center">Date of signup</TableCell>
                <TableCell align="center">Salary</TableCell>
                <TableCell align="center">Working hours</TableCell>
                <TableCell align="center">Email</TableCell>
                <TableCell align="center">Curator</TableCell>
                <TableCell align="center">Director</TableCell>
                <TableCell align="center">Salesperson</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data?.map(row => (
                <TableRow key={row.employeeId}>
                  <TableCell align="center">{row.employeeId}</TableCell>
                  <TableCell align="center">{row.name}</TableCell>
                  <TableCell align="center">{row.surname}</TableCell>
                  <TableCell align="center">{row.dob}</TableCell>
                  <TableCell align="center">{row.dateOfSignup}</TableCell>
                  <TableCell align="center">{row.salary}</TableCell>
                  <TableCell align="center">{row.workingHours}</TableCell>
                  <TableCell align="center">{row.email}</TableCell>
                  <TableCell align="center">{row.isCurator}</TableCell>
                  <TableCell align="center">{row.isDirector}</TableCell>
                  <TableCell align="center">{row.isSalesperson}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      )}
      <Link className={classes.link} to="/">
        {" "}
        <Typography align="left">
          &#x2190; Head back to save data
        </Typography>{" "}
      </Link>
    </div>
  );
}