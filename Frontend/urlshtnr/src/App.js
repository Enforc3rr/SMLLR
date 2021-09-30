import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HomePage from "./components/HomePage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Redirect from "./components/Redirect";

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/sm/:smllrId" children={<Redirect />} />
        <div>
          <Navbar />
          <Route path="/" component={HomePage} />
          <Route path="/sb/:sharebinId" />
          <Route path="/sb" component={HomePage} />
          <Footer />
        </div>
      </Switch>
    </Router>
  );
}

export default App;
