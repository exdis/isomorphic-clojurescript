(ns ^:figwheel-always isomorphic.core
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]
              [ajax.core :refer [GET POST]]))

(enable-console-print!)

(def repos (atom []))

(defn get-repos [response]
  (reset! repos response))

(GET "http://api.github.com/users/exdis/repos"
     {:handler get-repos
      :response-format :json
      :keywords? true})

(defn repo-item [repo owner]
  (reify om/IRender
    (render [_]
      (dom/li nil (:name repo)))))

(defn repo-list [data owner]
  (reify om/IRender
    (render [_]
      (dom/h1 nil "GitHub repos")
      (apply dom/ul nil
        (om/build-all repo-item data)))))

(om/root repo-list repos
  {:target (. js/document (getElementById "app"))})

(defn on-js-reload [])
