(ns leiningen.new.compojure-api
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as s]))

(def render (renderer "compojure-api"))

(defmulti option-files (fn [option data] option))

(defmethod option-files :base [_ data]
  [["src/{{sanitized}}/handler.clj"  (render "handler.clj" data)]
   ["project.clj"                    (render "project.clj" data)]
   ["README.md"                      (render "README.md" data)]])

(defmethod option-files :clojure-test [_ data]
  [["test/{{sanitized}}/core_test.clj" (render "clojure_core_test.clj" data)]
   ["project.clj"                      (render "clojure_test_project.clj" data)]
   ["README.md"                        (render "clojure_test_readme.md" data)]])

(defmethod option-files :midje [_ data]
  [["test/{{sanitized}}/core_test.clj" (render "midje_core_test.clj" data)]
   ["project.clj"                      (render "midje_project.clj" data)]
   ["README.md"                        (render "midje_readme.md" data)]])


(defn active-options [args]
  (for [arg args :when (re-matches #"\+[A-Za-z0-9-]+" arg)]
    (keyword (subs arg 1))))

(defn compojure-api
  "Create a new Compojure-api project"
  [name & args]
  (let [data  {:name name
               :name-camel (str (s/upper-case (subs name 0 1)) (subs name 1))
               :sanitized (name-to-path name)}
        opts (cons :base (active-options args))
        files (reduce into [] (map #(option-files % data) opts))]
    (main/info "Generating fresh compojure-api project.")
    (apply ->files data files)))
