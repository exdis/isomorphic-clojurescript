(ns ^:figwheel-always isomorphic.core
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]
              [isomorphic.components :as component]
              [ajax.core :refer [GET POST]]))

(enable-console-print!)

(def repos (atom []))

(defn get-repos [response]
  (reset! repos response))

(GET "http://api.github.com/users/exdis/repos"
     {:handler get-repos
      :response-format :json
      :keywords? true})

(om/root component/repo-list repos
  {:target (. js/document (getElementById "app"))})

(defn on-js-reload [])
