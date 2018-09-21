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

;; What is the largest prime factor of the number 600851475143 ?
(defn factorize [x]
  ((fn [curr factor primes]
      (cond
        (== 1 curr) 
          primes
        (== 0 (mod curr factor))
          (recur (quot curr factor)
                 2
                 (conj primes factor))
        :else
          (recur curr (+ 1 factor) primes)))
      x 2 '()))

(defn euler3 [n]
  (first (factorize n)))

(do
  (println (euler1 1000))
  (println (euler2 4000000))
  (println (euler3 600851475143)))
