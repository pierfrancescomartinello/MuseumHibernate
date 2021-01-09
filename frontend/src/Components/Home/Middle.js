import React from 'react';
import temple from '../../img/museum.png'
import Button from '@material-ui/core/Button';
import {Link} from 'react-router-dom';

const middleStyle = {
    fontSize: "48px",
    paddingLeft: 420,
    backgroundColor: '#d76843',
    backgroundImage: `url(${temple})`,
    backgroundRepeat: 'no-repeat',
    backgroundPosition: '350px',
    minHeight: '417px',
}

const sectionOne = {
    fontSize: "50px",
    paddingTop: "110px",
    paddingLeft: "500px",
    color: '#ffffff'
}

const sectionTwo = {
    fontSize: "20px",
    paddingLeft: "500px",
    color: '#ffffff'
}

const sectionThree = {
    fontSize: "20px",
    paddingLeft: "500px",
    color: '#ffffff'
}

const sectionFour = {
    fontSize: "20px",
    paddingLeft: "500px",
    color: '#ffffff'
}

function Section(props) {
    return (
        <div style={props.section}>{props.text}</div>
    )
}

export default function Middle() {
    return (
        <div style={middleStyle}>
            <Section section={sectionOne} text={"Features"}></Section>
            <Section section={sectionTwo} text={"Enjoy seamless museum visiting from the comfort of your own device."}></Section>
            <Section section={sectionThree} text={"Safely buy tickets using the latest hackproof technologies."}></Section>
            <Section section={sectionFour} text={"Navigate through our countless artwork collection, and give us your thoughts."}></Section>  
            <div style={{paddingLeft: "500px"}}><Link to="/tickets"><Button variant="contained" color="inherit" style={{color: '#000000'}}>Get your tickets now</Button></Link></div>
        </div>
    );
}

