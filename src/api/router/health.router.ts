import {Router} from "express";
import {ping} from "../controller";

const healthRouter = Router();

healthRouter.get("/", ping);

export {healthRouter};
