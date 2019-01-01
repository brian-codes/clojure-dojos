(ns roman.core-test
  (:require [clojure.test :refer :all]
            [roman.core :refer :all]))

(deftest numeral-to-number-test
  (testing "Individual Character Conversion"
    (is (= (numeral-to-number \I \I) 1))
    (is (= (numeral-to-number \L \I) 50))
    (is (= (numeral-to-number \M \I) 1000))
    (is (= (numeral-to-number \I \X) -1))
    (is (= (numeral-to-number \X \L) -10))))

(deftest convert-test
  (testing "Roman Numeral Conversion"
    (is (= (convert "MMMMCMXCIX") 4999))
    (is (= (convert "MDCCLXXVI") 1776))
    (is (= (convert "MCMLIV") 1954))
    (is (= (convert "CCXLVI") 246))))

