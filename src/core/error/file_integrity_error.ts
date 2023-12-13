export class FileIntegrityError extends Error {
  constructor() {
    super("Please ensure the file is not corrupted");
  }
}
