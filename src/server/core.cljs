(ns server.core
  (:require-macros [hiccups.core :as hiccups])
  (:require [cljs.nodejs :as node]
            [hiccups.runtime :as hiccupsrt]))

(def express (node/require "express"))

(defn markup []
  (hiccups/html
    [:head
     [:title "Isomorphic ClojureScript"]]
    [:body
     [:div#app nil]
     [:script {:src "/js/compiled/isomorphic.js"}]]))

(defn handler [req res]
  (.send res (markup)))

(defn -main []
  (let [app (express)]
    (.use app (.static express "resources/public"))
    (.get app "/" handler)
    (.listen app 3000 (fn []
                        (.log js/console "Server started on port 3000")))))

(set! *main-cli-fn* -main)
