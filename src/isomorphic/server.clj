(ns isomorphic.server
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response])
  (:use [compojure.core]))

(defroutes main-routes
  (GET "/" []
      (response/redirect "index.html"))
      (route/resources "/"))

(def app (handler/site main-routes))
