(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/compojure-api "0.16.5"]
                 [metosin/ring-http-response "0.5.2"]
                 [metosin/ring-swagger-ui "2.0.17"]]
  :ring {:handler {{name}}.handler/app}
  :uberjar-name "server.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [cheshire "5.3.1"]]
                   :plugins [[lein-ring "0.8.13"]]}})
