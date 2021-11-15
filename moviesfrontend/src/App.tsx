//import React, { useState } from "react";
import { BrowserRouter } from "react-router-dom";
import Navbar from "./components/Navbar";
import Routes from "./Routes";

function App() {
  return (
    <BrowserRouter basename="movies">
      <div className="flex justify-start flex-row">
        <Navbar />
        <Routes />
      </div>
    </BrowserRouter>
  );
}

export default App;
