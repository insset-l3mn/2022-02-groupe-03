import { Link } from "react-router-dom";
import "./Header.css";
import React, { Component }  from 'react';

const Header = () => {
  return (
    <div className="header">
      <Link to="/" className="title">
        Quiz
      </Link>
      <hr className="divider" />
    </div>
  );
};

export default Header;
