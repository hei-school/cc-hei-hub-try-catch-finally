import {CustomError} from "./custom_error";

export class FileLockError extends CustomError {
  constructor() {
    super(
      "The file you are trying to access is currently locked by another process. Please try again later."
    );
  }
}
