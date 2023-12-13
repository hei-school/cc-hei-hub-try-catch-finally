export const SUPPORTED_EXT: Record<string, string[]> = {
  video: ["mpg4", "mp4", "ts", "webm", "avi"],
  img: ["png", "jpeg", "jpg", "webp", "mkv"],
  pdf: ["pdf"],
  docs: ["docx", "docm", "dotx", "xls", "ppt", "pptx"],
};

export const getSupportedFolder = () => Object.keys(SUPPORTED_EXT);
