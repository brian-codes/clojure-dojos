(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))

(deftest frame-type-test
  (testing "Frame Type"
    (is (= (frame-type [\X 1]) :strike))
    (is (= (frame-type [5 \\]) :spare))
    (is (= (frame-type [2 3]) :regular))
    ))

(deftest frame-score-test
  (testing "Frame Score"
    (is (= (frame-score [\X 4 3 1]) 17))
    (is (= (frame-score [5 \\ 1 2]) 11))
    (is (= (frame-score [2 3 4 5]) 5))
    ))

(deftest game-score-test
  (testing "Whole Game Score"
    (is (= (game-score [9 \- 9 \- 9 \- 9 \- 9 \- 9 \- 9 \- 9 \- 9 \- 9 \-]) 90))
    (is (= (game-score [5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5 \\ 5]) 150))
    (is (= (game-score [\X \X \X \X \X \X \X \X \X \X \X \X]) 300))
    (is (= (game-score [8 1 3 4 2 6 3 3 \X 1 2 5 \\ 7 1 \- 4 5 1]) 81))))
