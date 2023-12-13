import {ToHttpError} from "./http_adapter";

export class CustomError extends Error implements ToHttpError {
  constructor(message: string) {
    super(message);
    this.name = CustomError.prototype.constructor.name;
  }

  toHttp(): any {
    throw new Error("to_http is not implemented");
  }
}
