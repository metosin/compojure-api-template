(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-time "0.11.0"] ; required due to bug in `lein-ring uberwar`
                 [metosin/compojure-api "1.1.1"]]
  :ring {:handler {{name}}.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]{{{gen-test-deps}}}{{{midje-deps}}}]
                   :plugins [[lein-ring "0.9.7"]{{{midje-plugs}}}]}})
