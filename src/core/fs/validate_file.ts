import {ParsedPath} from "node:path";
import {
  BadFileTypeError,
  FileIntegrityError,
  FolderNotFound,
  InvalidFileNameError,
} from "../error";
import {SUPPORTED_EXT, getSupportedFolder} from "../constants";

export const validateFile = (
  buf: ArrayBuffer,
  dir: string,
  filepath: ParsedPath
) => {
  validateFolder(dir, filepath);
  validateFilename(filepath.name);
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
