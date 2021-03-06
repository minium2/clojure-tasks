(ns clojure.parallel-filter-bench1
  (:require [clojure.test :refer :all])
  (:require [clojure.parallel-filter :refer :all])
  )

(deftest time-test-with-regular-pred-lazy
  (testing "testing filter vs pfilter-lazy with regular predicate"
    (let [l1 (list 1 2 3 4 5 6 7 8)
          l2 (list 3 7 1 5 8 4 2 6)]
      (println "load classes:")
      (time (println (parallel-filter-lazy even? (range 0 100))))
      (println)
      (println "with filter:")
      (time (println (filter even? l1)))
      (time (println (filter even? l2)))
      (time (println (take 10 (filter even? naturals))))
      (println)
      (println "with pfilter:")
      (time (println (parallel-filter-lazy even? l1)))
      (time (println (parallel-filter-lazy even? l2)))
      (time (println (take 10 (parallel-filter-lazy even? naturals)))))))

(deftest time-test-with-long-running-pred-lazy
  (testing "testing filter vs pfilter-lazy with long running predicate"
    (let [l1 (list 1 2 3 4 5 6 7 8)
          l2 (list 3 7 1 5 8 4 2 6)]
      (println "load classes:")
      (time (println (parallel-filter-lazy long-running-pred (range 0 10))))
      (println)
      (println "with filter:")
      (time (println (filter long-running-pred l1)))
      (time (println (filter long-running-pred l2)))
      (time (println (filter long-running-pred (range 100))))
      (time (println (take 10 (filter long-running-pred naturals))))
      (println)
      (println "with pfilter:")
      (time (println (parallel-filter-lazy long-running-pred l1)))
      (time (println (parallel-filter-lazy long-running-pred l2)))
      (time (println (parallel-filter-lazy long-running-pred (range 100))))
      (time (println (take 10 (parallel-filter-lazy long-running-pred naturals)))))))