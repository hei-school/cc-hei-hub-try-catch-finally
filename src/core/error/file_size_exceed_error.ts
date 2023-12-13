import {CustomError} from "./custom_error";

export class FileSizeExceedError extends CustomError {
  constructor(limit: number) {
    super(
      `Unable to upload file because the file size exceeds the maximum limit: ${limit}`
    );
  }
}
