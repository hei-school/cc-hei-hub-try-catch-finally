import {BadRequest} from "http-errors";
import {CustomError} from "./custom_error";

export class InvalidFileNameError extends CustomError {
  constructor(filename: string) {
    super(
      `Please ensure the file name does not contain any invalid characters or spaces: '${filename}'`
    );
  }

  override toHttp() {
    return new BadRequest(this.message);
  }
}
