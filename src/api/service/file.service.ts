import path from "node:path";
import {validateFile} from "../../core/fs/validate_file";
import {writeFileInDir} from "../../core/fs/write_file_in_dir";

export const uploadFile = async (buf: ArrayBuffer, filepath: string) => {
  const parsed = path.parse(filepath);
  const directory = /* leading */ parsed.dir.split(path.sep).at(0);
  validateFile(buf, directory, parsed);
  return writeFileInDir(buf, directory, parsed.base);
};
