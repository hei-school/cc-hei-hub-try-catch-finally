import {Router} from "express";
import {uploadFileHandler} from "../controller/file.controller";

const fileRouter = Router();

fileRouter.post("/upload", uploadFileHandler);

export {fileRouter};
