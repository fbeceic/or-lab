import React from "react";
import cx from "classnames";

type FieldProps = {
  className?: string;
  label: string;
  error?: string;
  children: React.ReactNode;
};

export default function Field({
  className = "",
  label,
  error,
  children,
}: FieldProps) {
  const finalClassName = cx({
    "flex flex-col justify-start": true,
    [className]: className,
  });

  return (
    <div className={finalClassName}>
      <p className="mb-2">{label}</p>
      {children}
      {error && <p className="text-red-500">{error}</p>}
    </div>
  );
}
