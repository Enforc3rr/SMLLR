import React, { useState } from "react";
import MDEditor from "@uiw/react-md-editor";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import Particles from "particles-bg";
import { post } from "axios";
import Swal from "sweetalert2";

function Sharebin() {
  const [text, setText] = useState("### Enter Text In Markdown Format Here");
  const [title, setTitle] = useState("");

  const onCreate = () => {
    const config = {
      headers: {
        "content-type": "multipart/form-data",
        "Allow-Access-Allow-Origin": "*",
      },
    };
    const url = "http://localhost:8081/sharebin/create";
    const formData = new FormData();

    formData.append("shareBinTitle", title);
    formData.append("shareBinCode", text);

    post(url, formData, config)
      .then((response) => {
        console.log(response);
        Swal.fire(
          `You can Access This Document From siteName.com/sb/${response.data}`
        );
        setTitle("");
        setText("");
      })
      .catch((error) => {
        Swal.fire(
          `An error occurred while saving the document. Please try again later`
        );
      });
  };

  return (
    <div
      className="container-md shadow mt-3 mb-3"
      style={{
        minHeight: "100vh",
        backgroundColor: "rgba(255, 255, 255, 0.8)",
      }}
    >
      <Particles type="cobweb" num={window.innerWidth / 12} bg={true} />
      <div className="row justify-content-center align-items-center">
        <div className="col-md-12 mt-3 mb-1">
          <div className="row">
            <div className="col-md-3">
              <img
                src="https://image.freepik.com/free-vector/blogging-concept-illustration_114360-1038.jpg"
                className="img-fluid"
                alt=""
                style={{ Height: "20px" }}
              />
            </div>

            <div
              className="col-md-9"
              style={{ fontFamily: "Pacifico, cursive" }}
            >
              <h1 className="display-1 ml-5 mt-5">
                <u>Share-Bin</u>
              </h1>
            </div>
          </div>
        </div>
        <div className="col-md-8 mt-3 mb-3 text-center">
          <div className="form-outline">
            <input
              type="text"
              id="formControlLg"
              className="form-control form-control-lg"
              onChange={(e) => setTitle(e.target.value)}
              value={title}
              placeholder="Enter Title"
            />
          </div>
        </div>
        <div className="col-md-12 mt-3">
          <MDEditor
            value={text}
            onChange={setText}
            hideToolbar={true}
            visiableDragbar={true}
            height={window.innerHeight / 1.5}
            commands={[]}
          />
        </div>
        <div className="col-md-12 mt-5 mb-3 text-center">
          <button className="btn btn-outline-primary" onClick={onCreate}>
            Create
          </button>
        </div>
      </div>
    </div>
  );
}

export default Sharebin;
