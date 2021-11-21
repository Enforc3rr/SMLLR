import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Particles from "particles-bg";
import { post } from "axios";
import Swal from "sweetalert2";

function URLInput() {
  const [url, setUrl] = useState("");

  const correctingUrl = () => {
    const urlRegex = new RegExp(
      "((http|https)://)(www.)?" +
        "[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]" +
        "{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)"
    );
    if (urlRegex.test(url)) {
      clickToAddUrl();
    } else {
      Swal.fire("Enter correctly formatted URL");
    }
  };
  const clickToAddUrl = () => {
    const data = {
      mainUrl: url,
    };
    const config = {
      headers: {
        "content-type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    };

    post("http://localhost:8080/url/add", data, config)
      .then((response) => {
        setUrl("");
        Swal.fire(`${response.data.message}`);
      })
      .catch((error) => {
        Swal.fire("Error occured , please try again");
      });
  };
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
        <div className="col-md-12 mt-1 mb-2">
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
                  value={url}
                  onChange={(e) => setUrl(e.target.value)}
                ></input>
              </div>
            </div>
            <hr></hr>
          </form>
        </div>
        <div className="col-md-12 mt-1 mb-3 text-center">
          <button
            className="btn btn-outline-primary btn-lg"
            onClick={correctingUrl}
          >
            Shorten Your URL
          </button>
        </div>
      </div>
    </div>
  );
}

export default URLInput;
