import React from "react";
import { useField } from "formik";
import Field from "./Field";

type InputProps = {
  label: string;
  name: string;
  error?: string;
  className?: string;
};

export default function Input({ label, name, className = "" }: InputProps) {
  const [field, meta] = useField(name);

  return (
    <Field
      label={label}
      error={meta.touched && meta.error ? meta.error : ""}
      className={className}
    >
      <input {...field} className={"border rounded px-3 py-2 mb-2"} />
    </Field>
  );
}
