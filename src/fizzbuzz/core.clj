(ns fizzbuzz.core)

(require '[clojure.core.match :refer [match]])

(defn fizzbuzz [n]
  (match [(mod n 3) (mod n 5)]
    [0 0] "FizzBuzz"
    [0 _] "Fizz"
    [_ 0] "Buzz"
    :else n))

(defn convert-list [list]
  (map fizzbuzz list))

(defn print-converted-list [list]
  (apply println (convert-list list)))