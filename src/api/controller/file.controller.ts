import {BadRequest} from "http-errors";
import {RequestHandler} from "express";
import {uploadFile} from "../service";

export const uploadFileHandler: RequestHandler<
  unknown,
  unknown,
  ArrayBuffer
> = (req, res, next) => {
  const filePath = req.query["file_path"];
  const buf = req.body;

  if (!buf) {
    throw new BadRequest("body (binary) is required");
  }
  if (!filePath || typeof filePath !== "string") {
    throw new BadRequest("'file_path' required as str");
  }
  return uploadFile(buf, filePath);
};
