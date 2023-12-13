import {CustomError} from "./custom_error";

export class FileDuplicationError extends CustomError {
  constructor() {
    super(
      `Please ensure the file you are trying to save upload is unique. (?) rename`
    );
  }
}
