(ns {{name}}.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [{{name}}.domain :refer :all]))

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "Sample Api"
    :description "Compojure Api sample application")
  (swaggered "pizza"
    :description "pizza apis"
      (POST* "/pizza" []
        :return   Pizza
        :body     [pizza NewPizza]
        :summary  "creates a new pizza"
        (ok (assoc pizza :id (rand-int 100))))))
