import React, {useState} from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Typography from '@material-ui/core/Typography';
import AccountBalanceIcon from '@material-ui/icons/AccountBalance';
import IconButton from '@material-ui/core/IconButton';
import { Link } from "react-router-dom";

export default function Tickets() {
  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);
  // eslint-disable-next-line
  let isLoading = true;

  // eslint-disable-next-line
  const [visitorId, setVisitorId] = useState("");

  let email = (window.location.pathname.replace("/dashboard/", ""));
  
  const visitorTicketsURL = "/login/ticketInfo/ticketOf?email=" + email;
 
  async function sampleFunc() {
    let response = await fetch(visitorTicketsURL);
    let body = await response.json();
    upDateData(body);
  }

  console.log(data)

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }
 
  if (data.length > 0) isLoading = false;

  return (
    <React.Fragment>
      <Typography component="h3" variant="h5" style={{ color: "#c16b53", fontWeight: "bold", paddingLeft: "7px" }}>
        Your tickets
      </Typography>
      <Table size="small" style={{maxWidth: "100%"}}>
        <TableHead>
          <TableRow>
            <TableCell><b>Purchase date</b></TableCell>
            <TableCell><b>Visit date</b></TableCell>
            <TableCell><b>Ticket type</b></TableCell>
            <TableCell><b>Ticket price</b></TableCell>
            <TableCell align="right" style={{paddingLeft: "0px"}}><b>Use</b></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {data?.map((row) => (
          <TableRow key={row.employeeId}>
            <TableCell align="left">{row[0]}</TableCell>
            <TableCell align="left">{row[1]}</TableCell>
            <TableCell align="left">{row[2]}</TableCell>
            <TableCell align="left">{row[3]}</TableCell>
            <TableCell align="left">{row[4]}</TableCell>
            <TableCell align="left">
                <IconButton
                    disabled = {!row[4]}
                    onClick={() => { fetch("/api/useTicket/ticketId=" + row[6]) }}
                    component={Link}
                    to="/areaHub">
                  <AccountBalanceIcon />
                </IconButton>
              </TableCell>
          </TableRow>
        ))}
        </TableBody>
      </Table>

    </React.Fragment>
  );
}
