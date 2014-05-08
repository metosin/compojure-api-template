(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/compojure-api "0.11.2"]
                 [metosin/ring-http-response "0.4.0"]
                 [metosin/ring-swagger-ui "2.0.12-1"]]
  :ring {:handler {{name}}.handler/app}
  :uberjar-name "server.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.8.10"]]}})
