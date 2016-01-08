(ns server.core
  (:require-macros [hiccups.core :as hiccups])
  (:require [cljs.nodejs :as node]
            [cognitect.transit :as t]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [isomorphic.components :as component]
            [hiccups.runtime :as hiccupsrt]))

(enable-console-print!)

(def express (node/require "express"))
(def ^:private js-request (node/require "request"))

(def r (t/reader :json))

(defn request [opts callback]
  (js-request (clj->js opts) callback))

(defn get-repos [callback]
  (request {:method "GET"
            :uri "https://api.github.com/users/exdis/repos"
            :headers {"User-Agent" "request"}}
           (fn [error response body]
             (when (and (not error) (= 200 (.-statusCode response)))
               (callback body)))))

(defn parse-json [json]
  (let [parsed (t/read r json)]
    (into []
          (for [item parsed] {:name (get item "name")}))))

(defn render [data]
  (dom/render-to-str (om/build component/repo-list data)))

(defn markup [data]
  (hiccups/html
    [:head
     [:title "Isomorphic ClojureScript"]]
    [:body
     [:div#app (render data)]
     [:script {:src "/js/compiled/isomorphic.js"}]]))

(defn handler [req res]
  (get-repos (fn [data]
               (.send res (markup (parse-json data))))))

(defn -main []
  (let [app (express)]
    (.use app (.static express "resources/public"))
    (.get app "/" handler)
    (.listen app 3000 (fn []
                        (println "Server started on port 3000")))))

(set! *main-cli-fn* -main)
