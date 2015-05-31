(ns isomorphic.components
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

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
