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
<<<<<<< HEAD
    fs.writeFileSync(dest, Buffer.from(buf));
=======
    const to = getRelativePath(directory, filename);

    console.log("to write", buf);

    // fs.writeFileSync(to, Buffer.from(buf));
>>>>>>> 21c3162 (feat: add POST /file/upload)
  } catch (e) {
    throw new FileLockError();
  }
};
