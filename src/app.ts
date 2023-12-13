import Express from "express";
import cors from "cors";
import {healthRouter} from "./api/router";
import {errorHandler} from "./api/middleware/error";

const application = Express();

// middleware
application.use(Express.json());
application.use(cors());

// controller
application.use("/ping", healthRouter);
// middelware
application.use(errorHandler);

export {application};
