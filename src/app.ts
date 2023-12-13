import Express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import {healthRouter} from "./api/router";
import {fileRouter} from "./api/router/file.router";
import {errorHandler} from "./api/middleware/error";

const application = Express();

// middleware
application.use(Express.json());
application.use(bodyParser.raw());
application.use(cors());

// controller
application.use("/ping", healthRouter);
application.use("/file", fileRouter);

// middelware
application.use(errorHandler);

export {application};
