(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/compojure-api "0.20.3"]
                 [clj-time "0.9.0"] ; required due to bug in lein-ring
                 [metosin/ring-http-response "0.6.1"]]
  :ring {:handler {{name}}.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]{{{gen-test-deps}}}{{{midje-deps}}}]
                   :plugins [[lein-ring "0.9.3"]{{{midje-plugs}}}]}})
