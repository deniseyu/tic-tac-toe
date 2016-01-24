(ns tic-tac-toe.core)

(defn three-of-a-kind?
  [mark]
  (fn [triple] (every? #{mark} triple)))



(defn check-rows
  "check if any rows contain three of a kind"
  [board mark]
  (let [rows (partition 3 board)]
  (if (some true? (map (three-of-a-kind? mark) rows))
    mark
    :no-win)))

(defn check-columns
  "check columns for three of a kind"
  [board mark]
  (let [columns (apply mapv vector (partition 3 board))]
    (if (some true? (map (three-of-a-kind? mark) columns))
      mark
      :no-win)))
