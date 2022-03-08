import axios from "axios";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer/Footer";
import Header from "./components/Header/Header";
import Home from "./Pages/Home/Home";
import Quiz from "./Pages/Quiz/Quiz";
import Result from "./Pages/Result/Result";
import React, { useState, useEffect } from "react";
import { Button, Navbar, Nav } from 'react-bootstrap'
import Routes from "./Routes";
import { LinkContainer } from "react-router-bootstrap";
import Login from "./container/Login";
import { AppContext } from "./lib/contextLib";
import { Auth } from "aws-amplify";


function App() {
  const [isAuthenticating, setIsAuthenticating] = useState(true);
  const [isAuthenticated, userHasAuthenticated] = useState(false);
  const [questions, setQuestions] = useState();
  const [name, setName] = useState();
  const [score, setScore] = useState(0);

  useEffect(() => {
    onLoad();
  }, []);

  async function onLoad() {
    try {
      await Auth.currentSession();
      userHasAuthenticated(true);
    } catch (e) {
      if (e !== 'No current user') {
        alert(e);
      }
    }

    setIsAuthenticating(false);
  }

  const fetchQuestions = async (category = "", difficulty = "") => {
    const {data} = await axios.get(
        `https://api.api-ninjas.com/v1/trivia?category=mathematics${
            category && `&category=${category}`
        }${difficulty && `&difficulty=${difficulty}`}&type=multiple`
    );

    setQuestions(data.results);
  };

  async function handleLogout() {
    await Auth.signOut();

    userHasAuthenticated(false);
  }

  return (
      !isAuthenticating && (
          <div className="App container py-3">
            <Navbar collapseOnSelect bg="light" expand="md" className="mb-3">
              <LinkContainer to="/">
                <Navbar.Brand className="font-weight-bold text-muted">
                  Bonsoir
                </Navbar.Brand>
              </LinkContainer>
              <Navbar.Toggle/>
              <Navbar.Collapse className="justify-content-end">
                <Nav activeKey={window.location.pathname}>
                  {isAuthenticated ? (
                      <Nav.Link onClick={handleLogout}>Deconnexion</Nav.Link>
                  ) : (
                      <>
                        <LinkContainer to="/signup">
                          <Nav.Link>Inscription</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/login">
                          <Nav.Link>Connexion</Nav.Link>
                        </LinkContainer>
                      </>
                  )}
                </Nav>
              </Navbar.Collapse>
            </Navbar>
            <AppContext.Provider value={{isAuthenticated, userHasAuthenticated}}>
              <Routes/>
            </AppContext.Provider>
            <Switch>
              <Route path="/" exact>
                <Home
                    name={name}
                    setName={setName}
                    fetchQuestions={fetchQuestions}
                />
              </Route>
              <Route path="/quiz">
                <Quiz
                    name={name}
                    questions={questions}
                    score={score}
                    setScore={setScore}
                    setQuestions={setQuestions}
                />
              </Route>
              <Route path="/result">
                <Result name={name} score={score} />
              </Route>
            </Switch>
          </div>
      )
  );
}

export default App;
