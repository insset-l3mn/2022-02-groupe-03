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

import Admin from "./Pages/Admin";
import { AuthContext } from "./context/auth";
import PrivateRoute from './PrivateRoute';
import Graphe from "./container/Graphe";

import GrapheAdmin from "./container/GrapheAdmin";


function App() {

  const existingTokens = JSON.parse(localStorage.getItem("tokens"));
  const [authTokens, setAuthTokens] = useState(existingTokens);

  const setTokens = (data) => {
    localStorage.setItem("tokens", JSON.stringify(data));
    setAuthTokens(data);
  }

  const [isAuthenticating, setIsAuthenticating] = useState(true);
  const [isAuthenticated, userHasAuthenticated] = useState(false);
  const [questions, setQuestions] = useState();
  const [name, setName] = useState();
  const [score, setScore] = useState(0);


  const fetchQuestions = async (category = "", difficulty = "") => {
    const {data} = await axios.get(
        `https://opentdb.com/api.php?amount=10${
            category && `&category=${category}`
        }${difficulty && `&difficulty=${difficulty}`}&type=multiple`
    );

    setQuestions(data.results);
  };

  return (
      <AuthContext.Provider value={{ authTokens, setAuthTokens: setTokens }}>
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
                      <>
                        <LinkContainer to="/signup">
                          <Nav.Link>Inscription</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/login">
                          <Nav.Link>Connexion</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/graphe">
                          <Nav.Link>Graphe</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/grapheadmin">
                          <Nav.Link>GrapheAdmin</Nav.Link>
                        </LinkContainer>
                      </>
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

              <PrivateRoute path="/admin" component={Admin} />

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
                <Graphe />
              </Route>
            </Switch>
          </div>
      </AuthContext.Provider>
  );
}

export default App;
