(defproject testproject "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-time "0.11.0"] ; required due to bug in `lein-ring uberwar`
                 [metosin/compojure-api "1.0.0-SNAPSHOT"]]
  :ring {:handler testproject.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [cheshire "5.5.0"]
                                  [ring/ring-mock "0.3.0"]
                                  [midje "1.8.3"]]
                   :plugins [[lein-ring "0.9.6"]
                             [lein-midje "3.2"]]}})
