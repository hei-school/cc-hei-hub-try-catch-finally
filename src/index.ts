import {application} from "./app";

const PORT = process.env.PORT || 8080;
const SERVER_RUNNING_MSG = `Server running at port ${PORT}`;

const bootstrap = () => {
  application.listen(PORT, () => {
    console.log(SERVER_RUNNING_MSG);
  });
};

bootstrap();
