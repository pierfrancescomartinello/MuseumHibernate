import React from 'react';
import { Link } from "react-router-dom";
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import AreaHubBG from "../../img/areahub.png";
import { render } from '@testing-library/react';
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
  heroButtons: {
    marginTop: theme.spacing(4),

  },
  cardGrid: {
    paddingTop: theme.spacing(8),
    paddingBottom: theme.spacing(8),
  },
  card: {
    height: '100%',
    display: 'flex',
    flexDirection: 'column',
  },
  cardMedia: {
    paddingTop: '56.25%', // 16:9
  },
  cardContent: {
    flexGrow: 1,
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

export default function Cubism() {
  // eslint-disable-next-line
  const classes = useStyles();

  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);

  // eslint-disable-next-line
  let isLoading = true;

  async function sampleFunc() {
    let response = await fetch("/api/artwork/areaId=12");
    let body = await response.json();
    upDateData(body);
  }

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  console.log(data)

  if (data.length > 0) isLoading = false;

  return (
    <div style={{backgroundColor: "#dac0b8", minHeight:"100vh"}}>
    <AppbarLoggedIn />
      <Fab  className={classes.fab} component={Link} to={window.location.pathname.replace("/Impressionism", "")}>
          <ArrowBackIcon />
      </ Fab>
      {/* Hero unit */}
      <div className={classes.heroContent} style={{backgroundColor: "#d69e8d"}}>
        <Container maxWidth="sm">
          <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom style={{color: "#975643"}}>
            Welcome
          </Typography>
          <Typography variant="h5" align="center" color="textSecondary" paragraph style={{color: "#975643"}}>
              Have a nice stay and enjoy your ride in this new Museum Experience.
          </Typography>
        </Container>
      </div>
      <Container className={classes.cardGrid} maxWidth="md">
        <Grid container spacing={4}>
          {data.map((card) => (
            <Grid item key={card} xs={12} sm={6} md={6}>
              <Card className={classes.card}>
                <CardMedia
                  component={() => (
                    <img
                      alt="test"
                      src={"data:image/png;base64," + card.miniature}
                    />
                  )}
                  className={classes.cardMedia}
                  image={<img src={"data:image/png;base64, " + card.miniature} alt="Red dot" />}
                />
                <CardContent className={classes.cardContent}>
                <Typography gutterBottom variant="h5" component="h2">
                    {card.name}
                  </Typography>      
                  <Typography gutterBottom variant="h8" component="h8">
                    {card.author}
                  </Typography>
                </CardContent>
                <CardActions>
                <Link to={"/areaHub/Renaissance/artwork/" + card.artworkId}>
                  <Button size="small" color="secondary" >
                    View artwork
                  </Button>
                </Link>
                </CardActions>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Container>  
    </div>
  );
}
