import {InternalServerError} from "http-errors";
import {CustomError} from "./custom_error";

export class FileIntegrityError extends CustomError {
  constructor() {
    super("Please ensure the file is not corrupted");
  }

  override toHttp() {
    return new InternalServerError(this.message);
  }
}
