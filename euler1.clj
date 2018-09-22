(require '[clojure.core.reducers :as r])

;; Find the sum of all the multiples of 3 or 5 below 1000
(defn euler1 [n]
  (r/fold +
    ;; filter out any numbers 
    ;; not divisible by 3 or 5
    (filter 
      (fn [x] 
        (or (== 0 (mod x 3))
            (== 0 (mod x 5))))
      (range n))))

(println (euler1 1000))
