(ns tic-tac-toe.core)

(defn check-rows
  "check if any rows contain three of a kind"
  [board mark]
  (let [rows (partition 3 board)]
  (if (some true? (map #(every? #{mark} %) rows))
    mark
    :no-win)))

(defn all-same-in-row
  [row mark]
  (every? #{mark} row))
