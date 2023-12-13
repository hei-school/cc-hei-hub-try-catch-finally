import {NotFound} from "http-errors";
import {CustomError} from "./custom_error";

export class FolderNotFound extends CustomError {
  constructor(path: string) {
    super(`Folder at '${path}' couldn't be located`);
  }

  override toHttp() {
    return new NotFound(this.message);
  }
}
