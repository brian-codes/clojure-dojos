(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest fizzbuzz-test
  (testing "Digit Conversion"
    (is (= (fizzbuzz 3) "Fizz"))
    (is (= (fizzbuzz 5) "Buzz"))
    (is (= (fizzbuzz 15) "FizzBuzz"))
    (is (= (fizzbuzz 1) 1))
    (is (= (fizzbuzz 11) 11))))

(deftest convert-list-test
  (testing "List Conversion"
    (is (= (convert-list (list 1 2 3 4 5 6 10 15)) (list 1 2 "Fizz" 4 "Buzz" "Fizz" "Buzz" "FizzBuzz")))))

