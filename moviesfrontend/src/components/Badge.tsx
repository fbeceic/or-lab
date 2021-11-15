import React from "react";
import cx from "classnames";

type BadgeProps = {
  color: string;
  label: string;
};

export default function Badge({ color, label }: BadgeProps) {
  const finalClassName = cx({
    "rounded-full m-1 p-2": true,
    "px-2.5 px-2": true,
    [`bg-${color}-500`]: true,
    [`text-${color}-50`]: true,
  });

  return <span className={finalClassName}>{label}</span>;
}
