(require '[clojure.core.reducers :as r])

;; What is the largest prime factor of the number 600851475143 ?
(defn factorize [x]
  ; returns prime factors of x
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

(println (euler3 600851475143))
