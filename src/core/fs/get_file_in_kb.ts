export const getFileSizeInKb = (buf: ArrayBuffer) => {
  const byteLength = buf.byteLength;
  const bitLength = byteLength * 8;
  return parseInt((bitLength / 1024).toFixed(2));
};
