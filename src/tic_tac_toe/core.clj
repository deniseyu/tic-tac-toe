(ns tic-tac-toe.core)

(defn three-of-a-kind?
  [mark]
  (fn [triple] (every? #{mark} triple)))

(defn win-condition?
  [mark triple]
  (some true? (map (three-of-a-kind? mark) triple)))

(defn check-rows
  "check if any rows contain three of a kind"
  [board mark]
  (let [rows (partition 3 board)]
  (if (win-condition? mark rows)
    mark
    :no-win)))

(defn check-columns
  "check columns for three of a kind"
  [board mark]
  (let [columns (apply mapv vector (partition 3 board))]
    (if (win-condition? mark columns)
      mark
      :no-win)))

(defn check-diagonals
  "check diagonals for three of a kind"
  [board mark]
  (let [diagonal-1 (map first (partition-all 4 (reverse board)))
        diagonal-2 (map first (partition-all 4 (mapcat reverse (partition 3 board))))]
    (if (win-condition? mark [diagonal-1 diagonal-2])
      mark
      :no-win)))


