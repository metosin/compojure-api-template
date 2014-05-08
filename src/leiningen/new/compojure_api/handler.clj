(ns {{name}}.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [ring.swagger.schema :refer :all]))

(defmodel Result {:result Long})

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "Sample Api"
    :description "Sample api it is.")
  (swaggered "math"
    :description "web maths"
      (GET* "/plus" []
        :return Result
        :query-params [x :- Long, y :- Long]
        :summary "x+y"
        (ok {:result (+ x y)}))))
