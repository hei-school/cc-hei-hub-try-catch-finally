import {HttpError} from "http-errors";
import {ErrorRequestHandler} from "express";

export const errorHandler: ErrorRequestHandler = (
  err: HttpError,
  _req,
  res,
  next
) => {
  res.status(err.status).json({
    status: err.status,
    name: err.name,
    message: err.message,
  });
};
