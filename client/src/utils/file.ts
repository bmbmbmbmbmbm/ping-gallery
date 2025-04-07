const units = ['bytes', 'KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB'];

/**
 * Converts a number in bytes to an appropriate unit.
 * Sourced form https://stackoverflow.com/questions/15900485/correct-way-to-convert-size-in-bytes-to-kb-mb-gb-in-javascript
 * Answer by Faust
 * @param value 
 * @returns File size in string format
 */
export function sizeFormat(value: number): string{

  let l = 0, n = parseInt(value.toString(), 10) || 0;

  while(n >= 1024 && ++l){
      n = n/1024;
  }
  
  return(n.toFixed(n < 10 && l > 0 ? 1 : 0) + ' ' + units[l]);
}