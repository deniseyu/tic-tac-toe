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

(deftest check-columns-test
  (testing "three X's in a column wins"
    (let [board 
          [:x :_ :o
           :x :_ :_
           :x :_ :_]]
    (is (= (check-columns board :x) :x))))
  (testing "three O's in a column win"
    (let [board
          [:x :o :o
           :_ :o :_
           :x :o :_]]
    (is (= (check-columns board :o) :o))))
  (testing "not-win conditions"
    (let [board
          [:x :o :o
           :_ :x :_
           :x :_ :_]]
    (is (= (check-columns board :o) :no-win))
    (is (= (check-columns board :x) :no-win))))) 

(deftest check-diagonals-test
  (testing "no-win conditions"
    (let [board 
          [:x :_ :o
           :o :_ :_
           :o :_ :x]]
    (is (= (check-diagonals board :x) :no-win))))
  (testing "three X's in a L-R diagonal wins"
    (let [board 
          [:x :_ :o
           :o :x :_
           :o :_ :x]]
    (is (= (check-diagonals board :x) :x))))
  (testing "three X's in a R-L diagonal wins"
    (let [board 
          [:x :_ :o
           :o :o :_
           :o :_ :x]]
    (is (= (check-diagonals board :o) :o)))))

(deftest add-marks-test
  (testing "Adding marks to the board"
    (let [turn-0 [:_ :_ :_ 
                 :_ :_ :_ 
                 :_ :_ :_]
          turn-1 [:x :_ :_
                  :_ :_ :_
                  :_ :_ :_]]
    (is (= (place-mark turn-0 :x 0) turn-1)))))
