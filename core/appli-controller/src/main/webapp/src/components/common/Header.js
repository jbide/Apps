import React from "react";
import { NavLink } from "react-router-dom";

const Header = () => {
  const activeStyle = { color: "#F15B2A" };
  return (
    <div>
      <h1>Hello todareer</h1>
      <nav>
        <NavLink activeStyle={activeStyle} to="/" exact>
          Home
        </NavLink>
        <NavLink activeStyle={activeStyle} to="/todos">
          Liste todo
        </NavLink>
      </nav>
    </div>
  );
};

export default Header;
