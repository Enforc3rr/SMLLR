import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HomePage from "./components/HomePage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Redirect from "./components/Redirect";
import Sharebin from "./components/Sharebin";
import DisplayMD from "./components/DisplayMD";

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/sm/:smllrId" children={<Redirect />} />
        <div>
          <Navbar />
          <Route exact path="/" component={HomePage} />
          <Route exact path="/sb" component={Sharebin} />

          <Route path="/sb/:sharebinId" component={DisplayMD} />
          <Footer />
        </div>
      </Switch>
    </Router>
  );
}

export default App;
