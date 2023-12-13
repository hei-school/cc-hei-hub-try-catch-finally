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
<<<<<<< HEAD
    fs.writeFileSync(dest, Buffer.from(buf));
=======
    const to = getRelativePath(directory, filename);
<<<<<<< HEAD

    console.log("to write", buf);

    // fs.writeFileSync(to, Buffer.from(buf));
>>>>>>> 21c3162 (feat: add POST /file/upload)
=======
    fs.writeFileSync(to, Buffer.from(buf));
>>>>>>> 6252aab (fix: upload file)
=======
    fs.writeFileSync(dest, Buffer.from(buf));
>>>>>>> 8982a39 (fix: handler order (error))
  } catch (e) {
    throw new FileLockError();
  }
};
