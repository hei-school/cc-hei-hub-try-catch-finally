import {BadRequest} from "http-errors";
import {CustomError} from "./custom_error";

export class BadFileTypeError extends CustomError {
  constructor(fileType: string) {
    super(`Unsupported file type: ${fileType}`);
  }

  override toHttp() {
    return new BadRequest(this.message);
  }
}
