(ns tic-tac-toe.core)

(defn three-of-a-kind?
  [mark]
  (fn [triple] (every? #{mark} triple)))

(defn win-condition?
  [mark triple]
  (some true? (map (three-of-a-kind? mark) triple)))

(defn return-winner
  [mark triples]
  (if (win-condition? mark triples)
    mark
    :no-win))

(defn check-rows
  "check if any rows contain three of a kind"
  [board mark]
  (let [rows (partition 3 board)]
    (return-winner mark rows)))

(defn check-columns
  "check columns for three of a kind"
  [board mark]
  (let [columns (apply mapv vector (partition 3 board))]
    (return-winner mark columns)))

(defn check-diagonals
  "check diagonals for three of a kind"
  [board mark]
  (let [get-diagonal (fn [board] (map first (partition-all 4 board)))
        diagonal-LR (get-diagonal (reverse board))
        diagonal-RL (get-diagonal (mapcat reverse (partition 3 board)))]
    (return-winner mark [diagonal-RL diagonal-LR])))

(defn place-mark
  [board mark position]
  (assoc board position mark))

