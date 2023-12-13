import Express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import {fileRouter, healthRouter} from "./api/router";
import {errorHandler} from "./api/middleware/error";
import {MAX_FILE_SIZE_IN_KB} from "./core/constants";

const application = Express();

// middelware
application.use(
  bodyParser.raw({
    type: ["image/*", "video/*", "application/*"],
    limit: /* bytes */ MAX_FILE_SIZE_IN_KB / 1_000,
  })
);
application.use(cors());
application.use(errorHandler);

// controller
application.use("/ping", healthRouter);
application.use("/file", fileRouter);

application.use(errorHandler);

export {application};
