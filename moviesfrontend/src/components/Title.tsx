import React from "react";
import cx from "classnames";

type TitleProps = {
  text: string;
  className?: string;
};

export default function Title({ text, className = "" }: TitleProps) {
  const finalClassName = cx({
    "text-5xl m-6": !className,
    [className]: className, //because we are assigning it to an object
  });
  return <h1 className={finalClassName}>{text}</h1>;
}
