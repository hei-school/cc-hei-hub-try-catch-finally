import fs from "fs";
import {FileLockError} from "../error";
import path from "path";

export const writeFileInDir = async (
  buf: ArrayBuffer,
  directory: string,
  filename: string
) => {
  try {
    const to = getRelativePath(directory, filename);

    console.log("to write", buf);

    // fs.writeFileSync(to, Buffer.from(buf));
  } catch (e) {
    console.log("em", e.message);
    throw new FileLockError();
  }
};

const STORAGE = "storage";

const getRelativePath = (directory: string, file: string) => {
  return path.join(STORAGE, directory, file);
};
