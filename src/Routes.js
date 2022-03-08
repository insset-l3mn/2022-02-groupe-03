import React from "react";
import { Route, Switch } from "react-router-dom";
import Home from "./Pages/Home/Home.js";
import Login from "./container/Login";
import Signup from "./container/Signup";

export default function Routes() {
    return (
        <Switch>
            <Route exact path="/login">
                <Login />
            </Route>
            <Route exact path="/signup">
                <Signup />
            </Route>
        </Switch>
    );
}