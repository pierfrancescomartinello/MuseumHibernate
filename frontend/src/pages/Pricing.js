import React from "react";
import Button from "@material-ui/core/Button";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardHeader from "@material-ui/core/CardHeader";
import Grid from "@material-ui/core/Grid";
import StarIcon from "@material-ui/icons/StarBorder";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import gallery from "../img/gallery32bpp.png";
import { Link } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  "@global": {
    ul: {
      margin: 0,
      padding: 0,
      listStyle: "none",
    },

    body: {
      backgroundImage: `url(${gallery})`,
      backgroundSize: "cover",
      backgroundRepeat: "no-repeat",
      minHeight: "320px",
    },
  },

  link: {
    margin: theme.spacing(1, 1.5),
  },
  heroContent: {
    padding: theme.spacing(8, 0, 6),
  },
  cardHeader: {
    backgroundColor:
      theme.palette.type === "light"
        ? theme.palette.grey[200]
        : theme.palette.grey[700],
  },
  cardPricing: {
    display: "flex",
    justifyContent: "center",
    alignItems: "baseline",
    marginBottom: theme.spacing(2),
  },
}));

const tiers = [
  {
    title: "Young",
    price: "5€",
    price_subtext: "",
    description: ["Easier, simplified descriptions for everyone to be seen."],
    buttonText: "Buy young ticket",
    buttonVariant: "outlined",
  },
  {
    title: "Adult",
    price: "15€",
    price_subtext: "",
    description: [
      "Get the complete museum experience along with longer, complete descriptions.",
    ],
    buttonText: "Buy adult ticket",
    buttonVariant: "contained",
  },
  {
    title: "Group",
    price: "5€",
    price_subtext: "/person",
    description: ["Starting from groups of 5 or more people."],
    buttonText: "Contact us",
    buttonVariant: "outlined",
  },
];

export default function Pricing() {
  const classes = useStyles();

  return (
    <React.Fragment>
      <Container
        maxWidth="sm"
        component="main"
        className={classes.heroContent}
        style={{ marginTop: "100px" }}
      >
        <Typography
          variant="h5"
          align="center"
          color="textSecondary"
          component="p"
        ></Typography>
      </Container>

      <Container maxWidth="md" component="main">
        <Grid container spacing={5} alignItems="flex-end">
          {tiers.map((tier) => (
            // Enterprise card is full width at sm breakpoint
            <Grid
              item
              key={tier.title}
              xs={12}
              sm={tier.title === "Enterprise" ? 12 : 6}
              md={4}
            >
              <Card>
                <CardHeader
                  title={tier.title}
                  subheader={tier.subheader}
                  titleTypographyProps={{ align: "center" }}
                  subheaderTypographyProps={{ align: "center" }}
                  action={tier.title === "Pro" ? <StarIcon /> : null}
                  className={classes.cardHeader}
                />
                <CardContent>
                  <div className={classes.cardPricing}>
                    <Typography component="h2" variant="h3" color="textPrimary">
                      {tier.price}
                    </Typography>
                    <Typography component="h2" variant="h4" color="textPrimary">
                      {tier.price_subtext}
                    </Typography>
                  </div>
                  <ul>
                    {tier.description.map((line) => (
                      <Typography
                        component="li"
                        variant="subtitle1"
                        align="center"
                        key={line}
                      >
                        {line}
                      </Typography>
                    ))}
                  </ul>
                </CardContent>
                <CardActions>
                  <Button
                    fullWidth
                    component={Link}
                    to={"/confirm" + tier.title + "Ticket"}
                    style={{
                      backgroundColor: "#d18570",
                      color: "#FFFFFF",
                      fontWeight: "bold",
                    }}
                  >
                    {tier.buttonText}
                  </Button>
                </CardActions>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Container>
    </React.Fragment>
  );
}
