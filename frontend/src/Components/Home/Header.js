import React from 'react';
import temple from '../../img/temple-mini.png'

const headerStyle = {
    marginTop: "64px",
    fontSize: "64px",
    paddingLeft: 420,
    paddingTop: 135,

    color: '#ffffff',
    backgroundColor: '#ebcebd',
    backgroundImage: `url(${temple})`,
    backgroundSize: '100%',
    backgroundRepeat: 'no-repeat',
    minHeight: '320px',
};

export default function Header() {
    return (
            <div style={headerStyle}>Experience<br></br>the new museum.</div> 
    );
}

