import React from "react";
import URLInput from "./URLInput";
import Particles from "particles-bg";

function HomePage() {
  return (
    <div
      className="container-md gx-1 d-flex justify-content-center align-items-center"
      style={{ minHeight: "100vh" }}
    >
      <Particles type="cobweb" num={window.innerWidth / 12} bg={true} />
      <div className="row">
        <div
          className="col-md-12 text-center"
          style={{ fontFamily: "Pacifico, cursive" }}
        >
          <h1 className="display-1">
            <u>SmllR</u>
          </h1>
        </div>
        <div className="col-md-4 ">
          <div className="row text-center">
            <div className="col-md-12">
              <img
                src="https://image.freepik.com/free-vector/blogging-concept-illustration_114360-1038.jpg"
                className="img-fluid"
                alt=""
              />
            </div>
            <div className="col-md-12">
              <em>We Make Your Length URL ehh.. SMLLR</em>
            </div>
          </div>
        </div>
        <div className="col-md-8">
          <URLInput />
        </div>
      </div>
    </div>
  );
}

export default HomePage;
