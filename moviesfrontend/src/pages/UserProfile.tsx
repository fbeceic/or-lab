import React, { useEffect } from "react";
import { useAuth0 } from "@auth0/auth0-react";
import { LogoutIcon, UserCircleIcon } from "@heroicons/react/solid";
import Card from "../components/Card";
import cx from "classnames";
import IconButton from "../components/IconButton";

export default function UserProfile() {
  const {
    isLoading,
    error,
    isAuthenticated,
    user,
    getAccessTokenSilently,
    loginWithRedirect,
    logout,
  } = useAuth0();

  const FormStyle = cx({
    "flex flex-col items-center w-full space-y-2": true,
  });

  if (!isAuthenticated) {
    return <div>{loginWithRedirect()}</div>;
  }

  return (
    <div className="w-full">
      <Card
        title="Korisnički profil"
        className="md:w-1/3 w-full flex flex-col items-center h-fit"
      >
        <div className={FormStyle}>
          <div className="w-full">
            <div className="w-32 text-center mx-auto">
              <UserCircleIcon fill="gray" />
              Username: <br />
              <p className="text-slate-900 text-base hover:font-bold">
                {user?.name}
              </p>
            </div>
          </div>
          <div className="md:w-2/3 w-80 border-yellow-100 text-center rounded p-2 md:w-80 w-full text-yellow-700 mb-2 bg-yellow-100">
            Username je jedinstven i nepromjenjiv
          </div>
          <IconButton
            icon={LogoutIcon}
            label="Logout"
            onClick={() =>
              logout({ returnTo: window.location.origin, localOnly: true })
            }
          />
        </div>
      </Card>
    </div>
  );
}
