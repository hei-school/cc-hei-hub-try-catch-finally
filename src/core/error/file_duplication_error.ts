import {BadRequest} from "http-errors";
import {CustomError} from "./custom_error";

export class FileDuplicationError extends CustomError {
  constructor(path: string) {
    super(
      `Please ensure the file you are trying to save upload is unique: '${path}'`
    );
  }

  override toHttp() {
    return new BadRequest(this.message);
  }
}
