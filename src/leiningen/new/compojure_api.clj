(ns leiningen.new.compojure-api
  (:use [leiningen.new.templates :only [renderer year sanitize ->files]])
  (:require [clojure.string :as s]))

(def render (renderer "compojure-api"))

(defn compojure-api
  "Create a new Compojure-api project"
  [name]
  (let [data {:name name
              :nameCamel (str (s/upper-case (subs name 0 1)) (subs name 1))
              :year (year)
              :sanitized (sanitize name)}]
    (->files data
             ["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md"   (render "README.md" data)])))
