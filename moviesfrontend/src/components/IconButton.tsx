import React from "react";
import cx from "classnames";

type IconButtonProps = {
  label: string;
  onClick: () => void;
  icon: (props: React.ComponentProps<"svg">) => JSX.Element;
  className?: string;
};

export default function IconButton({
  label,
  onClick,
  icon: Icon,
  className = "",
}: IconButtonProps) {
  const buttonStyle = cx({
    "text-white flex justify-start flex-row items-center rounded mb-2 p-2":
      true,
    "bg-indigo-600 hover:bg-indigo-500": !className,
    [className]: true,
  });

  return (
    <button className={buttonStyle} onClick={onClick}>
      <Icon className="max-h-5 mr-1" />
      <p>{label}</p>
    </button>
  );
}
