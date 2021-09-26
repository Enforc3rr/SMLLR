import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Particles from "particles-bg";

function URLInput() {
  return (
    <div className="container shadow bg-white rounded card mt-5">
      <Particles
        type="cobweb"
        num={20}
        bg={{
          position: "absolute",
        }}
      />
      <div className="row">
        <div className="col-md-12 text-center mb-3 mt-5">
          <h2>
            <u>URL Input</u>
          </h2>
        </div>
        <div className="col-md-12 mt-5 mb-2">
          <form>
            <div className="form-group row">
              <div
                className="col-md-5 col-form-label text-center"
                htmlFor="urlInput"
              >
                <h4>Enter Long URL Here</h4>
              </div>
              <div className="col-md-7">
                <input
                  id="urlInput"
                  className="form-control form-control-lg"
                  type="text"
                  placeholder="LONG URL HERE"
                ></input>
              </div>
            </div>
            <hr></hr>
          </form>
        </div>
        <div className="col-md-12 mt-1 mb-3 text-center">
          <button className="btn btn-outline-primary btn-lg">
            Shorten Your URL
          </button>
        </div>
      </div>
    </div>
  );
}

export default URLInput;
