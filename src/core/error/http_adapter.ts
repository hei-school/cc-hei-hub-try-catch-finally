import {HttpError} from "http-errors";

export interface ToHttpError {
  toHttp(): HttpError;
}
