import * as fs from 'fs';
import * as path from 'path';
import { Request, Response } from 'express';

const storageFolderPath = path.join(__dirname, 'storage');

export const getFileController = (req: Request, res: Response) => {
  const fileName: string = req.params.fileName;

  const filePath = path.join(storageFolderPath, fileName);
  if (!fs.existsSync(filePath)) {
    return res.status(404).json({ error: 'Fichier non trouvé' });
  }

  try {
    const fileBuffer = fs.readFileSync(filePath);
    
    const arrayBuffer = fileBuffer.buffer.slice(
      fileBuffer.byteOffset,
      fileBuffer.byteOffset + fileBuffer.byteLength
    );

    res.send(arrayBuffer);
  } catch (error) {
    return res.status(500).json({ error: 'Erreur lors de la lecture du fichier' });
  }
};
