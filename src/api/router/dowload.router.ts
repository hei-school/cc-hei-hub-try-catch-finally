import {Router} from "express";
import {downloadFileHandler} from "../controller/dowload.controller";

const dowloadRouter = Router();

dowloadRouter.get("/dowload", downloadFileHandler);

export {dowloadRouter};
