(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/compojure-api "0.18.0"]
                 [metosin/ring-http-response "0.6.0"]
                 [metosin/ring-swagger-ui "2.0.24"]]
  :ring {:handler {{name}}.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]{{{gen-test-deps}}}{{{midje-deps}}}]
                   :plugins [[lein-ring "0.9.2"]{{{midje-plugs}}}]}})
