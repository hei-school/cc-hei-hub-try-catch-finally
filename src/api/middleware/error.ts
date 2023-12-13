import {ErrorRequestHandler, Response} from "express";
import {CustomError} from "../../core/error/custom_error";
import {FileSizeExceedError} from "../../core/error";
import {MAX_FILE_SIZE_IN_KB} from "../../core/constants";

export const errorHandler: ErrorRequestHandler = (err, _req, res, next) => {
  if (err instanceof CustomError) {
    return customErrorToPrettyHttpError(res, err);
  }
  // bodyParser
  if (err.type === "entity.too.large") {
    const fileSizeExceed = new FileSizeExceedError(MAX_FILE_SIZE_IN_KB);
    return customErrorToPrettyHttpError(res, fileSizeExceed);
  }
};

const customErrorToPrettyHttpError = (res: Response, err: CustomError) => {
  const http = err.toHttp();
  return res.status(http.status).json({
    status: http.status,
    name: http.name,
    message: http.message,
  });
};
