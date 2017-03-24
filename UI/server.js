var express = require("express");
var bodyParser = require('body-parser')
var app= express();
var path = require('path');


app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));
app.set('/public/views', __dirname + '/views');


app.get('/', function(req,res){
	res.sendFile(__dirname + '/' + 'index.html');
});

app.get('*', function(req, res) {
  res.redirect('/#' + req.originalUrl);
});

app.listen(8085,function(){
	console.log("server listening: 8085");
});