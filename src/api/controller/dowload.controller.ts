import * as fs from 'fs';
import * as path from 'path';
import { Request, RequestHandler, Response } from 'express';
import {InternalServerError} from "http-errors";
import {FileNotFoundError, FolderNotFound} from "../../core/error"

const storageFolderPath = path.join(__dirname, 'storage');

export const downloadFileHandler: RequestHandler = (req: Request, res: Response) => {
  const pathParams: string = req.params.path;
  const [folder, fileName] = pathParams.split('/');

  const validFolderPathTypes = ['img', 'video', 'pdf', 'docs', ];
  if (!validFolderPathTypes.includes(folder)) {
    throw new FolderNotFound(folder);
  }

  const filePath = path.join(storageFolderPath, folder, fileName);
  if (!fs.existsSync(filePath)) {
    throw new FileNotFoundError(fileName);
  }

  try {
    const fileBuffer = fs.readFileSync(filePath);

    const arrayBuffer = fileBuffer.buffer.slice(
      fileBuffer.byteOffset,
      fileBuffer.byteOffset + fileBuffer.byteLength
    );

    res.send(arrayBuffer);
  } catch (error) {
    throw new InternalServerError("Corrupted file");
  }
};
