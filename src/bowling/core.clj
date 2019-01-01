(ns bowling.core)

(def mappings { \- 0 \X 10 })

(defn frame-type
  [[r1 r2]]
  (cond
    (= r1 \X) :strike
    (= r2 \\) :spare
    :else :regular))

(defn frame-score
  [rolls]
  (condp = (frame-type rolls)
    :strike (+ 10 (mappings (second rolls) (second rolls)) (if (= (nth rolls 2) \\) (- 10 (second rolls))
                                                                                    (mappings (nth rolls 2) (nth rolls 2))))
    :spare (+ 10 (mappings (nth rolls 2) (nth rolls 2)))
    :regular (+ (mappings (first rolls) (first rolls)) (mappings (second rolls) (second rolls)))))

(defn game-score
  ([rolls frame score]
   (let [new-score (+ score (frame-score rolls))
         next-frame (+ frame 1)
         remaining-rolls (if (= (frame-type rolls) :strike) (rest rolls)
                                                            (drop 2 rolls))]
     (if (or (= frame 10) (empty? rolls)) new-score
                                          (game-score remaining-rolls next-frame new-score))))
  ([rolls]
   (game-score rolls 1 0)))

(defn print-score [rolls]
  (println (game-score rolls)))