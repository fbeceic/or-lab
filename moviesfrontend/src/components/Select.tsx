import React from "react";
import { useField } from "formik";
import Field from "./Field";

type SelectProps<T> = {
  name: string;
  label: string;
  placeholder: string;
  className?: string;
  options: T[];
  getOptionValue: (option: T) => string;
  getOptionLabel: (option: T) => string;
};

export default function Select<T>({
  label,
  name,
  placeholder,
  options,
  getOptionValue,
  getOptionLabel,
  className = "",
}: SelectProps<T>) {
  const [field, meta] = useField(name);

  return (
    <Field
      label={label}
      error={meta.touched && meta.error ? meta.error : ""}
      className={className}
    >
      <select {...field} className="rounded border px-3 py-2 mb-2">
        <option disabled={true} selected={false} value="">
          {placeholder}
        </option>
        {options.map((value) => (
          <option value={getOptionValue(value)}>{getOptionLabel(value)}</option>
        ))}
      </select>
    </Field>
  );
}
