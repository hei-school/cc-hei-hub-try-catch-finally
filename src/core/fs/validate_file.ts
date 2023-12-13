import {existsSync} from "node:fs";
import {ParsedPath} from "node:path";
import {
  BadFileTypeError,
  FileDuplicationError,
  FileSizeExceedError,
  FolderNotFound,
  InvalidFileNameError,
} from "../error";
import {
  MAX_FILE_SIZE_IN_KB,
  SUPPORTED_EXT,
  getSupportedFolder,
} from "../constants";
import {makeFilePathInStorage} from "./storage";
import {getFileSizeInKb} from "./get_file_in_kb";

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
  validateFileSize(buf);
  ensureFileIsUnique(dir, fullpath, parsed.base);
};

const ensureFileIsUnique = (dir: string, fullpath: string, file: string) => {
  const storagePath = makeFilePathInStorage(dir, file);
  if (existsSync(storagePath)) {
    throw new FileDuplicationError(fullpath);
  }
};

export const validateFileSize = (buf: ArrayBuffer) => {
  console.log("vaidate_size");
  const fileSize = getFileSizeInKb(buf);
  if (fileSize > MAX_FILE_SIZE_IN_KB) {
    throw new FileSizeExceedError(MAX_FILE_SIZE_IN_KB);
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
