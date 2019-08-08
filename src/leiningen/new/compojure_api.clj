(ns leiningen.new.compojure-api
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as s]))

(def render (renderer "compojure-api"))

(defn midje? [opts]
  (some #{:midje} opts))

(defn cl-test? [opts]
  (some #{:clojure-test} opts))

(defn pad [len]
  (apply str (repeat len " ")))

(defn template-data [name opts]
  {:name           name
   :name-camel     (str (s/upper-case (subs name 0 1)) (subs name 1))
   :sanitized      (name-to-path name)
   :gen-test-deps  (if (or (midje? opts) (cl-test? opts))
                     (s/join (concat "\n" (pad 34) "[ring/ring-mock \"0.3.2\"]")))
   :midje-deps     (if (midje? opts)
                     (s/join (concat "\n" (pad 34) "[midje \"1.8.3\"]"))
                     "")
   :midje-plugs    (if (midje? opts)
                     (s/join (concat "\n" (pad 29) "[lein-midje \"3.2\"]"))
                     "")
   :midje-readme   (if (midje? opts) "\n### Run the tests\n\n`lein midje`\n" "")
   :cl-test-readme (if (cl-test? opts) "\n### Run the tests\n\n`lein test`\n" "")})

(defmulti option-files (fn [option data] option))

(defmethod option-files :base [_ data]
  [["src/{{sanitized}}/handler.clj"  (render "handler.clj" data)]
   ["project.clj"                    (render "project.clj" data)]
   ["README.md"                      (render "README.md" data)]])

(defmethod option-files :clojure-test [_ data]
  [["test/{{sanitized}}/core_test.clj" (render "clojure_core_test.clj" data)]])

(defmethod option-files :midje [_ data]
  [["test/{{sanitized}}/core_test.clj" (render "midje_core_test.clj" data)]])

(defn active-options [args]
  (for [arg args :when (re-matches #"\+[A-Za-z0-9-]+" arg)]
    (keyword (subs arg 1))))

(defn compojure-api
  [name & args]
  (let [opts  (cons :base (active-options args))
        data  (template-data name opts)
        files (reduce into [] (map #(option-files % data) opts))]
    (main/info "Generating fresh compojure-api project.")
    (apply ->files data files)))
