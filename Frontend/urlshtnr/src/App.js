import React from "react";
import URLInput from "./components/URLInput";
import Particles from "particles-bg";

function App() {
  return (
    <div className="container gx-1 vh-100 d-flex justify-content-center align-items-center ">
      <Particles type="cobweb" num={window.innerWidth / 12} bg={true} />
      <div className="row">
        <div className="col-md-12 text-center">
          <h1 className="display-1">
            <u>SmllR</u>
          </h1>
        </div>
        <div className="col-md-4 ">
          <div className="row mt-5 text-center">
            <div className="col-md-12">
              <img
                src="https://image.freepik.com/free-vector/blogging-concept-illustration_114360-1038.jpg"
                className="img-fluid"
                alt=""
              />
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

export default App;
