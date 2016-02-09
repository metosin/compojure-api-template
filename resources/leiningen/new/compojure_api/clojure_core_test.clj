(ns {{name}}.core-test
  (:require [cheshire.core :as cheshire]
            [clojure.test :refer :all]
            [{{name}}.handler :refer :all]
            [ring.mock.request :as mock]))

(defn parse-body [body]
  (cheshire/parse-string (slurp body) true))

(deftest a-test

  (testing "Test GET request to /hello?name={a-name} returns expected response"
    (let [response (app (-> (mock/request :get  "/api/plus?x=1&y=2")))
          body     (parse-body (:body response))]
      (is (= (:status response) 200))
      (is (= (:result body) 3)))))
