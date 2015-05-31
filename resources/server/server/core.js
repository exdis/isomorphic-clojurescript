// Compiled by ClojureScript 0.0-3211 {:target :nodejs}
goog.provide('server.core');
goog.require('cljs.core');
goog.require('hiccups.runtime');
goog.require('cljs.nodejs');
server.core.express = cljs.nodejs.require.call(null,"express");
server.core.markup = (function server$core$markup(){
return [cljs.core.str("<head><title>Isomorphic ClojureScript</title></head>"),cljs.core.str("<body><div id=\"app\"></div><script src=\"/js/compiled/isomorphic.js\"></script></body>")].join('');
});
server.core.handler = (function server$core$handler(req,res){
return res.send(server.core.markup.call(null));
});
server.core._main = (function server$core$_main(){
var app = server.core.express.call(null);
app.use(server.core.express.static("resources/public"));

app.get("/",server.core.handler);

return app.listen((3000),((function (app){
return (function (){
return console.log("Server started on port 3000");
});})(app))
);
});
cljs.core._STAR_main_cli_fn_STAR_ = server.core._main;
