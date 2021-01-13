import React, {useState} from 'react';
import Typography from '@material-ui/core/Typography';

export default function UserInfo(props) {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [visitorId, setVisitorId] = useState("");

  let email = (window.location.pathname.replace("/dashboard/", ""));

  let nameURL = fetch("/login/userInfo/name?email=" + email, {method: "GET"});

  nameURL.then(nameURL => {
    return nameURL.json();
  }).then(visitorName => {
    const name = visitorName[0]
    setName(name)
  })


  let surnameURL = fetch("/login/userInfo/surname?email=" + email, {method: "GET"});

  surnameURL.then(surnameURL => {
    return surnameURL.json();
  }).then(visitorSurname => {
    const surname = visitorSurname[0]
    setSurname(surname)
  })

  let visitorIdURL = fetch("/login/userInfo/visitorId?email=" + email, {method: "GET"});

  visitorIdURL.then(visitorIdURL => {
    return visitorIdURL.json();
  }).then(visitorIdP => {
    const visitorId = visitorIdP[0]
    setVisitorId(visitorId)
  })


  return (
    <div>
      <Typography component="h1" variant="h3" style={{color: "#c16b53", fontWeight: "bold", paddingLeft: "7px" }}>
        Welcome, 
      </Typography>
      {/* name and surname area */}
      <Typography component="p" variant="h4" style={{color: "#c2968a", paddingLeft: "7px"}}>
        {name} {surname}
      </Typography>
      {/* email area */ }
      <Typography color="textSecondary" style={{paddingLeft: "7px"}}>
        {email}, ID: {visitorId}
      </Typography>
    </div>
   

  
    
  );
}
