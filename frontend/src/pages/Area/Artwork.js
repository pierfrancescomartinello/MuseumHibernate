import React from 'react';
import { Link } from "react-router-dom";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import AreaHubBG from "../../img/areahub.png";
import Fab from '@material-ui/core/Fab';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import AppbarLoggedIn from "../../components/AppbarLoggedIn";

const useStyles = makeStyles((theme) => ({
  icon: {
    marginRight: theme.spacing(2),
  },
  heroContent: {
    backgroundColor: theme.palette.background.paper,
    padding: theme.spacing(8, 0, 6),
    backgroundImage: `url(${AreaHubBG})`,
    backgroundRepeat: "no-repeat",
  },

  cardGrid: {
    paddingTop: theme.spacing(8),
    paddingBottom: theme.spacing(8),
  },
  card: {
    minHeight: '300px',
		minWidth: '300px',
    display: 'flex',
    flexDirection: 'column',
		marginLeft: "30px",
		marginTop: "30px",

  },
	fab : {
		margin: 0,
    top: 'auto',
    right: 'auto',
    bottom: 20,
    left: 20,
    position: 'fixed',
		backgroundColor: "#d18570",
		color: "#FFFFFF"
	},
  footer: {
    backgroundColor: theme.palette.background.paper,
  },
}));

export default function Artwork() {
  // eslint-disable-next-line
  const classes = useStyles();

  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);

  // eslint-disable-next-line
  let isLoading = true;
  let artworkId = window.location.pathname.replace("Baroque", "").replace("Cubism", "").replace("Impressionism", "").replace("Renaissance", "").replace("/areaHub/", "").replace("/artwork/", "");
	console.log(artworkId)

  async function sampleFunc() {
    let response = await fetch("/api/artwork/" + artworkId);
    let body = await response.json();
    upDateData(body);
  }

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  console.log(data[0])

  if (data.length > 0) isLoading = false;

  return (
    <div style={{backgroundColor: "#dac0b8", minHeight:"100vh"}}>
    <AppbarLoggedIn />
		<Fab  className={classes.fab} component={Link} to={window.location.pathname.replace(artworkId, "").replace("/artwork/", "")}>
			<ArrowBackIcon />
		</ Fab>

      {/* Hero unit */}
      <div className={classes.heroContent} style={{backgroundColor: "#d69e8d"}}>
        <Container maxWidth="sm">
          <Typography component="h3" variant="h3" align="center" color="textPrimary" gutterBottom style={{color: "#975643"}}>
              {data.name}
          </Typography>
          <Typography variant="h4" align="center" color="textSecondary" paragraph style={{color: "#975643"}}>
							{data.author}
          </Typography>
        </Container>
      </div>
			<Grid
				container
				spacing={0}
				direction="column"
				alignItems="center"
				justify="center"
				style={{ minHeight: '100vh', marginTop: "0px" }}
			>
			<CardMedia
				className={classes.cardMedia}
				component={() => (<img alt="an artwork" src={"data:image/png;base64," + data.image} />)}
			/>
				<Card className={classes.card} style={{height: "300px" , width: "1000px"}} elevation={24}>
					<CardContent className={classes.cardContent}>
						<Typography gutterBottom variant="h5" component="h2">
							Made: {data.date} <br></br><br></br>
							{data.simpleDescription} <br></br>
							{data.completeDescription}
						</Typography>
						<Typography>
							{/*testo*/}
						</Typography>
					</CardContent>
				</Card>
			</Grid>
 
    </div>
  );
}
