import fs from "fs";
import {FileLockError} from "../error";
import path from "path";

export const writeFileInDir = (
  buf: ArrayBuffer,
  directory: string,
  filename: string
) => {
  try {
    const to = getRelativePath(directory, filename);
    fs.writeFileSync(to, Buffer.from(buf));
  } catch (e) {
    throw new FileLockError();
  }
};

const STORAGE = "storage";

const getRelativePath = (directory: string, file: string) => {
  return path.join(STORAGE, directory, file);
};
