(ns isomorphic.server
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response]
            [hiccup.page :refer [html5 include-css include-js]])
  (:use [compojure.core]))

(defn render []
  (html5
    [:head
     [:title "Isomorphic ClojureScript"]]
    [:body
     [:div#app nil]
     (include-js "/js/compiled/isomorphic.js")]))

(defroutes main-routes
  (GET "/" []
    ;;(response/redirect "index.html"))
    {:status 200
     :headers {"Content-Type" "text/html; charset=utf-8"}
     :body (render)})
  (route/resources "/"))

(def app (handler/site main-routes))
