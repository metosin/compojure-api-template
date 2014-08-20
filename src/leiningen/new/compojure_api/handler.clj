(ns {{name}}.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]))

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "{{nameCamel}} Api"
    :description "this is {{nameCamel}} Api.")
  (swaggered "math"
    :description "playing with parameters"
    (GET* "/plus" []
      :return Long
      :query-params [x :- Long, {y :- Long 1}]
      :summary "x+y (y default to 1)"
      (ok (+ x y)))))
