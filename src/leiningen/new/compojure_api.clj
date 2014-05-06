(ns leiningen.new.compojure-api
  (:use [leiningen.new.templates :only [renderer year sanitize ->files]]))

(def render (renderer "compojure-api"))

(defn compojure-api
  "Create a new Compojure-api project"
  [name]
  (let [data {:name name
              :year (year)
              :sanitized (sanitize name)}]
    (->files data
             ["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
             ["src/{{sanitized}}/domain.clj" (render "domain.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md"   (render "README.md" data)])))
