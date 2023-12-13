import {join} from "path";

const STORAGE = "storage";

export const makeFilePathInStorage = (directory: string, file: string) => {
  return join(STORAGE, directory, file);
};
