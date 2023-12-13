import {Locked} from "http-errors";
import {CustomError} from "./custom_error";

export class FileSizeExceedError extends CustomError {
  constructor(limit: number) {
    super(
      `Unable to upload file because the file size exceeds the maximum limit: ${limit}kb`
    );
  }

  override toHttp() {
    return new Locked(this.message);
  }
}
