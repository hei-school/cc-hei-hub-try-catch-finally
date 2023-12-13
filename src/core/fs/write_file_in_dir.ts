import fs from "fs";
import {FileLockError} from "../error";
import {makeFilePathInStorage} from "./storage";

export const writeFileInDir = async (
  buf: ArrayBuffer,
  directory: string,
  filename: string
) => {
  const dest = makeFilePathInStorage(directory, filename);
  try {
    fs.writeFileSync(dest, Buffer.from(buf));
  } catch (e) {
    throw new FileLockError();
  }
};
