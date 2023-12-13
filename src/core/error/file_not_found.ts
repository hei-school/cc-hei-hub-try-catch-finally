import {NotFound} from "http-errors";
import {CustomError} from "./custom_error";

export class FileNotFoundError extends CustomError {
  constructor(path: string) {
    super(`File at path '${path}' could not be located`);
  }

  override toHttp() {
    return new NotFound(this.message);
  }
}
