import Express from "express";
import cors from "cors";
import {healthRouter} from "./api/router";

const application = Express();

// middleware
application.use(Express.json());
application.use(cors());

// controller
application.use("/ping", healthRouter);

export {application};
