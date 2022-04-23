import React from "react";
import {Button, Card, Form, Input} from "../components/AuthForms";
import { useAuth } from "../context/auth";
import Categories from "../Data/Categories.js";
import GrapheAdmin from "../container/GrapheAdmin";
import Graphe from "../container/Graphe";
import {Route} from "react-router-dom";

function Admin(props) {
    const { setAuthTokens } = useAuth();
    const listCategories = <Categories />;
    const listItems = listCategories.map((listCategories) =>
        <li>{listCategories}</li>
    );

    function logOut() {
        setAuthTokens();
    }

    return (
        <div>
            <div>Admin Page</div>
            <Button onClick={logOut}>Log out</Button>

            <ul>{listItems}</ul>
            <Form>
                <Input type="text" placeholder="Soumettre une question" />
                <Input type="text" placeholder="Avec 4 réponses (1V/3F)" />
                <Button>Submit une question</Button>
            </Form>

            <Form>
                <Input type="text" placeholder="Soumettre nouveau skill" />
                <Button>Submit le skill</Button>
            </Form>


            <GrapheAdmin />

        </div>
    );
}

export default Admin;