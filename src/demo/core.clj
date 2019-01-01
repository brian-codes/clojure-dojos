(ns demo.core)

(require '[fizzbuzz.core])
(require '[bowling.core])
(require '[roman.core])

(defn demo-fizzbuzz []
  (println "FizzBuzz 1 to 100:")
  (fizzbuzz.core/print-converted-list (range 1 101)))

(defn demo-bowling []
  (println "Bowling 12 Strikes XXXXXXXXXXXX:")
  (bowling.core/print-score [\X \X \X \X \X \X \X \X \X \X \X \X]))

(defn demo-roman-numerals []
  (println "Roman Numeral Conversion MMMMCMXCIX:")
  (roman.core/print-number "MMMMCMXCIX"))

(defn -main []
  (demo-fizzbuzz)
  (demo-bowling)
  (demo-roman-numerals))