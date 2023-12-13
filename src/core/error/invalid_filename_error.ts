import {CustomError} from "./custom_error";

export class InvalidFileNameError extends CustomError {
  constructor() {
    super(
      "Please ensure the file name does not contain any invalid characters or spaces."
    );
  }
}
