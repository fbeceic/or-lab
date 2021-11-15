import React from "react";
import cx from "classnames";

type ButtonProps = {
  label: string;
  onClick?: () => void; //? = can be undefined
  type?: "submit" | "reset" | "button";
  className?: string;
  rounded?: boolean;
};

export default function Button({
  label,
  onClick,
  type,
  className = "",
  rounded = true,
}: ButtonProps) {
  const finalClassName = cx({
    "bg-green-600 text-white px-3 py-2": !className,
    rounded: rounded,
    [className]: className, //because we are assigning it to an object
  });
  return (
    <button
      type={type}
      className={finalClassName}
      onClick={onClick ?? (() => {})}
    >
      {label}
    </button>
  );
}
