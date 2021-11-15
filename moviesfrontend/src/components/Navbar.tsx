import React from "react";
import { useHistory } from "react-router-dom";
import { HomeIcon, TableIcon } from "@heroicons/react/solid";
import IconButton from "./IconButton";

export default function Navbar() {
  const history = useHistory();
  return (
    <div className="bg-indigo-600 flex justify-start flex-col h-screen w-60 p-3">
      <div className="text-white text-lg mb-4 text-center">Movies Dataset</div>
      <IconButton
        icon={HomeIcon}
        label="Početna"
        onClick={() => history.push("/")}
      />
      <IconButton
        icon={TableIcon}
        label="Data Table"
        onClick={() => history.push("/datatable")}
      />
    </div>
  );
}
