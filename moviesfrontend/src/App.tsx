//import React, { useState } from "react";
import { BrowserRouter } from "react-router-dom";
import Navbar from "./components/Navbar";
import Routes from "./Routes";
import { useAuth0 } from "@auth0/auth0-react";
import { useState, useEffect } from "react";
import configData from "./config.json";

function App() {
  const {
    isLoading,
    error,
    isAuthenticated,
    user,
    getAccessTokenSilently,
    loginWithRedirect,
    logout,
  } = useAuth0();

  const [accessToken, setAccessToken] = useState<string>("");

  useEffect(() => {
    const getAccessToken = async () => {
      try {
        const accessToken = await getAccessTokenSilently({
          audience: configData.audience,
          scope: configData.scope,
        });
        setAccessToken(accessToken);
      } catch (e) {
        if (e instanceof Error) {
          console.log(e.message);
        }
      }
    };
    getAccessToken();
  }, [getAccessTokenSilently]);

  // if (error) {
  //   return <div>Oops... {error.message}</div>;
  // }
  //
  // if (isLoading) {
  //   return <div>Loading...</div>;
  // }
  //
  // if (!isAuthenticated) {
  //   return <div>{loginWithRedirect()}</div>;
  // }

  // useEffect(() => {
  //   logout({ returnTo: window.location.origin });
  // }, []);

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
