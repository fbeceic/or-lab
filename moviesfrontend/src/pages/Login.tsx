import React, { useEffect } from "react";
import { useAuth0 } from "@auth0/auth0-react";

export default function Login() {
  const {
    isLoading,
    error,
    isAuthenticated,
    user,
    getAccessTokenSilently,
    loginWithRedirect,
    logout,
  } = useAuth0();

  return (
    <>
      <button onClick={() => logout({ returnTo: window.location.origin })}>
        Log Out
      </button>
    </>
  );
}
