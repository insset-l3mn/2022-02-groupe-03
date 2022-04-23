import React from "react";
import { Route, Switch } from "react-router-dom";
import Home from "./Pages/Home/Home.js";
import Login from "./container/Login";
import Signup from "./container/Signup";

import Graphe from "./container/Graphe";
import GrapheAdmin from "./container/GrapheAdmin";

export default function Routes() {
    return (
        <Switch>
            <Route exact path="/login">
                <Login />
            </Route>
            <Route exact path="/signup">
                <Signup />
            </Route>
            <Route exact path="/graphe">
                <Graphe />
            </Route>
            <Route exact path="/GrapheAdmin">
                <GrapheAdmin />
            </Route>
        </Switch>
    );
}