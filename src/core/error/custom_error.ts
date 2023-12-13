export class CustomError extends Error {
  constructor(message: string) {
    super(message);
    this.name = CustomError.prototype.constructor.name;
  }
}
