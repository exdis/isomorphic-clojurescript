// Compiled by ClojureScript 0.0-3211 {:target :nodejs}
goog.provide('cljs.nodejs');
goog.require('cljs.core');
cljs.nodejs.require = require;
cljs.nodejs.process = process;
cljs.nodejs.enable_util_print_BANG_ = (function cljs$nodejs$enable_util_print_BANG_(){
cljs.core._STAR_print_newline_STAR_ = false;

return cljs.core._STAR_print_fn_STAR_ = (function() { 
var G__6579__delegate = function (args){
return console.log.apply(console,cljs.core.into_array.call(null,args));
};
var G__6579 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__6580__i = 0, G__6580__a = new Array(arguments.length -  0);
while (G__6580__i < G__6580__a.length) {G__6580__a[G__6580__i] = arguments[G__6580__i + 0]; ++G__6580__i;}
  args = new cljs.core.IndexedSeq(G__6580__a,0);
} 
return G__6579__delegate.call(this,args);};
G__6579.cljs$lang$maxFixedArity = 0;
G__6579.cljs$lang$applyTo = (function (arglist__6581){
var args = cljs.core.seq(arglist__6581);
return G__6579__delegate(args);
});
G__6579.cljs$core$IFn$_invoke$arity$variadic = G__6579__delegate;
return G__6579;
})()
;
});
