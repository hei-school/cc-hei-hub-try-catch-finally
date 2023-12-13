import {CustomError} from "./custom_error";

export class InsufficientStorageError extends CustomError {
  constructor(remainingStorageMb: number) {
    super(`Insufficient storage for files larger than ${remainingStorageMb}mb`);
  }
}
