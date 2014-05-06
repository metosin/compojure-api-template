(ns {{name}}.domain
  (:require [schema.core :as s]
            [ring.swagger.schema :refer :all]))

(def Topping (s/enum :cheese :olives :ham :pepperoni :habanero))

(defmodel Pizza {:id    Long
                 :name  String
                 :price Double
                 :hot   Boolean
                 (s/optional-key :description) String
                 :toppings #{Topping}})

(defmodel NewPizza (dissoc Pizza :id))
