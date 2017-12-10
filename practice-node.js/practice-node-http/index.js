var http = require("http");

var server = http.createServer(function handler(request, response) {
    request.writeHead(200, {"Content-Type": "text/plain"});
    response.end("Hello World\n");
}).listen(8080);

console.log("HTTP server with dummy response is running with URL http://127.0.0.1:8080/");
