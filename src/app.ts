import Express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import {fileRouter, healthRouter} from "./api/router";
import {errorHandler} from "./api/middleware/error";

const application = Express();

// middelware
application.use(
  bodyParser.raw({type: ["image/*", "video/*", "application/*"]})
);
application.use(cors());
application.use(errorHandler);

// controller
application.use("/ping", healthRouter);
application.use("/file", fileRouter);

export {application};
