import React from "react";
import {
  ArchiveIcon,
  BanIcon,
  BeakerIcon,
  CashIcon,
  CubeTransparentIcon,
  FastForwardIcon,
  LibraryIcon,
  LightningBoltIcon,
  LocationMarkerIcon,
  ReceiptTaxIcon,
} from "@heroicons/react/solid";

type IconProps = {
  icon: string;
};

const iconMapping = {
  ArchiveIcon,
  BanIcon,
  BeakerIcon,
  CashIcon,
  CubeTransparentIcon,
  FastForwardIcon,
  LibraryIcon,
  LightningBoltIcon,
  LocationMarkerIcon,
  ReceiptTaxIcon,
} as Record<string, (props: React.ComponentProps<"svg">) => JSX.Element>;

export default function Icon({ icon }: IconProps) {
  const Icon = iconMapping[icon]; //iz iconMappinga se izvlaci atribut jednak vrijednosti icona
  if (Icon) {
    return <Icon />;
  } else {
    return <div className="text-red-700">{icon}</div>;
  }
}
