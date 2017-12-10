var fs = require("fs");

fs.readFile("index.txt", "utf8", function(error, data) {
	console.log(data);
});

console.log("File processing is completed");
