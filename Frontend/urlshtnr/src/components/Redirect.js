import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { get } from "axios";

function RedirectManual() {
  let { smllrId } = useParams();
  const [message, setMessage] = useState("Redirecting..!");
  useEffect(() => {
    get(`http://localhost:8080/url/${smllrId}`)
      .then((response) => {
        window.location.href = `http://${response.data.url}`;
      })
      .catch((error) => {
        setMessage(error.response.data.message);
      });
  });

  return (
    <div className="container-md">
      <h1>{message}</h1>
    </div>
  );
}

export default RedirectManual;
