import {HttpError} from "http-errors";
import {ErrorRequestHandler} from "express";
import {CustomError} from "../../core/error/custom_error";

export const errorHandler: ErrorRequestHandler = (
  err: CustomError,
  _req,
  res,
  next
) => {
  const http = err.toHttp();
  return res.status(http.status).json({
    status: http.status,
    name: http.name,
    message: http.message,
  });
};
