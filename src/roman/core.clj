(ns roman.core)
(require '[clojure.string :as str])

(def mappings { \I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})

(defn numeral-to-number
  [first-numeral second-numeral]
  (let [mapped-first (mappings first-numeral 0)
        mapped-second (mappings second-numeral 0)]
    (if (< mapped-first mapped-second) (- mapped-first)
                                       mapped-first)))

(defn convert
  [numerals]
  (let [split-chars (seq numerals)
        first-numeral (first split-chars)
        second-numeral (second split-chars)]
    (if (empty? numerals) 0
                          (+ (numeral-to-number first-numeral second-numeral) (convert (rest numerals))))))

(defn print-number [numerals]
  (println (convert numerals)))