import React from "react";
import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import "../App.css";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light shadow-5-strong">
      <div className="container-fluid">
        <a className="navbar-brand navbarTitle" href="/sb" alt="">
          <button className="btn btn-outline-dark  my-2 my-sm-0">
            <u>Sharebin</u>
          </button>
        </a>

        <form className="form-inline my-2 my-lg-0">
          <a className="navbar-brand navbarTitle" href="/" alt="">
            <button className="btn btn-outline-dark my-2 my-sm-0">
              <u>SMLLR</u>
            </button>
          </a>
        </form>
      </div>
    </nav>
  );
}

export default Navbar;
