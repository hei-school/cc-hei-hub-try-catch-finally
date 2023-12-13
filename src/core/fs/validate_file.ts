import {existsSync} from "node:fs";
import {ParsedPath} from "node:path";
import {
  BadFileTypeError,
  FileDuplicationError,
  FolderNotFound,
  InvalidFileNameError,
} from "../error";
import {SUPPORTED_EXT, getSupportedFolder} from "../constants";
import {makeFilePathInStorage} from "./storage";

type ValidationOptions = {
  fullpath: string;
  parsedPath: ParsedPath;
  dir: string;
};

export const validateFile = (
  buf: ArrayBuffer,
  {dir, fullpath, parsedPath: parsed}: ValidationOptions
) => {
  validateFolder(dir, parsed);
  validateFilename(parsed.name);
  ensureFileIsUnique(dir, fullpath, parsed.base);
};

const ensureFileIsUnique = (dir: string, fullpath: string, file: string) => {
  const storagePath = makeFilePathInStorage(dir, file);
  if (existsSync(storagePath)) {
    throw new FileDuplicationError(fullpath);
  }
};

const validateFolder = (folder: string, file: ParsedPath) => {
  const folderExists = getSupportedFolder().includes(folder);

  if (!folderExists) {
    throw new FolderNotFound(folder);
  }

  const extensions = SUPPORTED_EXT[folder];

  // TODO: ensure file content has the given file ext
  const fileExtIsSupported = extensions.some(
    (ext) => file.ext.toLocaleLowerCase() === `.${ext}`
  );

  if (!fileExtIsSupported) {
    throw new BadFileTypeError(file.ext);
  }
};

// /!\ keeping global vars in closure
const validateFilename = (function () {
  const rg1 = /^[^\\/:\*\?"<>\|]+$/; // forbidden characters \ / : * ? " < > |
  const rg2 = /^\./; // cannot start with dot (.)
  const rg3 = /^(nul|prn|con|lpt[0-9]|com[0-9])(\.|$)/i; // forbidden file names
  return function doCheck(filename: string) {
    if (!(rg1.test(filename) && !rg2.test(filename) && !rg3.test(filename))) {
      throw new InvalidFileNameError(filename);
    }
  };
})();
