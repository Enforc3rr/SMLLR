import React, { useState, useEffect } from "react";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import ReactMarkdown from "react-markdown";
import gfm from "remark-gfm";
import Particles from "particles-bg";
import { get } from "axios";
import { useParams } from "react-router-dom";

function DisplayMD() {
  const [md, setMd] = useState("");
  const [title, setTitle] = useState("");
  let { sharebinId } = useParams();

  useEffect(() => {
    console.log(sharebinId);
    get(`http://www.localhost:8081/sharebin/get/${sharebinId}`)
      .then((response) => {
        setMd(response.data.shareBinCode);
        setTitle(response.data.shareBinTitle);
      })
      .catch((error) => {
        setTitle(error.response.data.shareBinTitle);
        setMd(error.response.data.shareBinCode);
      });
    // eslint-disable-next-line
  }, []);

  return (
    <div
      className="container-md mt-3"
      style={{
        minHeight: "100vh",
      }}
    >
      <Particles type="cobweb" num={window.innerWidth / 12} bg={true} />
      <div className="row">
        <div
          className="col-md-12 text-center"
          style={{ fontFamily: "Pacifico, cursive" }}
        >
          <h3 className="display-3">
            <u>Share-Bin</u>
          </h3>
        </div>
        <div
          className="col-md-12 shadow mt-3 mb-2"
          style={{ backgroundColor: "rgba(255, 255, 255, 0.8)" }}
        >
          <div className="row justify-content-center align-items-center">
            <div className="col-md-auto shadow mt-2 mb-2">
              <h4 className="display-4 text-center">
                <u>{title}</u>
              </h4>
            </div>
            <div className="col-md-12 mt-3">
              <ReactMarkdown remarkPlugins={[gfm]} children={md} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default DisplayMD;
