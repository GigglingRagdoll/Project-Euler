(require '[clojure.core.reducers :as r])

;; By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
(defn fibWhile [f]
  ((fn [xs]
    (let 
      ;; curr is sum of previous two elements
      [curr (+ (nth xs 0)
               (nth xs 1))]
      ;; recurs until condition f returns false
      (if (not (f curr))
          xs
          (recur (conj xs curr)))))
    ;; begin with first two values of fibonacci seq
    '(1 0)))

(defn euler2 [n]
  (r/fold +
    (filter
      ;; filter out odd-valued fibonacci
      ;; numbers from following parameter
      (fn [x] (== 0 (mod x 2)))
      ;; list containing all fibonacci 
      ;; numbers <= n
      (fibWhile (fn [x] (<= x n))))))

(println (euler2 4000000))
