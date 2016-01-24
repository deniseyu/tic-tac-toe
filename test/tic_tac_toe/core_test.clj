(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(deftest check-rows-test
  (testing "three X's in a row wins"
    (let [board 
          [:x :x :x
           :_ :_ :_
           :_ :_ :_]]
    (is (= (check-rows board :x) :x))))
  (testing "three O's in a row win"
    (let [board
          [:o :o :o
           :_ :x :_
           :x :_ :_]]
    (is (= (check-rows board :o) :o))))
  (testing "not-win conditions"
    (let [board
          [:x :o :o
           :_ :x :_
           :x :_ :_]]
    (is (= (check-rows board :o) :no-win))
    (is (= (check-rows board :x) :no-win)))))

