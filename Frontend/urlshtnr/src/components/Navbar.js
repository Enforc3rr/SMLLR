import React from "react";
import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light shadow-5-strong">
      <div className="container-fluid">
        <a className="navbar-brand" href="/sharebin" alt="">
          <u>ShareBin</u>
        </a>
        <a className="navbar-brand" href="/" alt="">
          <u>SMLLR</u>
        </a>
        <form className="form-inline my-2 my-lg-0">
          <button className="btn btn-outline-success my-2 my-sm-0">
            Account
          </button>
        </form>
      </div>
    </nav>
  );
}

export default Navbar;
