(ns {{name}}.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(s/defschema Message {:message String})

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "{{nameCamel}} Api")
  (swaggered "math"
    :description "hello api"
    (GET* "/hello" []
      :return Message
      :query-params [name :- String]
      :summary "hello world"
      (ok {:message (str "Hello, " name)}))))
