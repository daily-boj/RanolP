var scanner = new java.util.Scanner(java.lang.System['in']).useDelimiter(
  '[RC\r\n ]+'
);
var a = 'A'.charCodeAt(0);
while (true) {
  var row = scanner.nextInt();
  var column = scanner.nextInt() - 1;
  if (row == 0 && column == -1) {
    break;
  }
  var result = '';
  while (column >= 26) {
    var alphabet = column % 26;
    result = String.fromCharCode(a + alphabet) + result;
    column = (column - (column % 26) - 1) / 26;
  }
  result = String.fromCharCode(a + column) + result;
  print(result + row);
}
