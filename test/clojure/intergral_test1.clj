(ns clojure.intergral-test1
  (:require [clojure.test :refer :all])
  (:require [clojure.integral :refer :all])
  )

(deftest const-test
  (testing "testing integral y=const"
    (is (equal-to 1.0 ((integral-partial-sums y=const) 1)))
    (is (equal-to 2.0 ((integral-partial-sums y=const) 2))))
  )

(deftest line-test
  (testing "testing integral y=x"
    (is (equal-to 0.5 ((integral-partial-sums y=x) 1)))
    (is (equal-to 2.0 ((integral-partial-sums y=x) 2)))
    (is (equal-to 96.605 ((integral-partial-sums y=x) 13.9))))
  )

(deftest sqr-test
  (testing "testing integral y=sqrx"
    (is (equal-to 0.333 ((integral-partial-sums y=sqrx) 1)))
    (is (equal-to 576 ((integral-partial-sums y=sqrx) 12))))
  )

(deftest time-test
  (testing "Naive execution time measure: "
    (println "y=sqrx with integral:")
    (time ((memoized-integral y=sqrx) 1))
    (time ((memoized-integral y=sqrx) 1))
    (time ((memoized-integral y=sqrx) 2))
    (time ((memoized-integral y=sqrx) 2))
    (time ((memoized-integral y=sqrx) 30))
    (time ((memoized-integral y=sqrx) 30))
    (println)
    (println "y=sqrx with partial sum integral:")
    (time ((integral-partial-sums y=sqrx) 1))
    (time ((integral-partial-sums y=sqrx) 1))
    (time ((integral-partial-sums y=sqrx) 2))
    (time ((integral-partial-sums y=sqrx) 2))
    (time ((integral-partial-sums y=sqrx) 30))
    (time ((integral-partial-sums y=sqrx) 30))))