(ns css-critic.core
  (:use css-critic.css))

; Maybe use webkit to render to image?
; Find CSS processing lib or do it VERY BASICALLY

(def sample "body {
             color: black;
             background: #e5e5e5;
             font-family: Verdana, sans-serif;
             font-size: 12px;
             margin: 0;
             padding: 0;}")

(parse-css sample)

(def rules (get-in  (first (parse-css sample)) (list :content :declarations)))

;;map down a filter checking get-in :content... has 

;;< gfredericks> &(let [m {:foo 12 :bar 14 :baz 14}] (filter #(= 14 (m %)) (keys m)))
;; 70.957  < gfredericks> another thing you might find useful: ##(let [m {:foo 12 :bar 14 :baz 14}] (group-by m (keys m)))
;;70.937  < gfredericks> you pass it a key and it gives you a value: ##({:foo 'bar} :foo)

;;http://clojuredocs.org/clojure_core/clojure.java.shell/sh


;; Color utilities
;; To average an area dump its contents into an array then process the array into lists of r,g ;;and b values. http://processing.org/reference/loadPixels_.html


(defn avgonecolor [r] 
  (int (/ (apply + r) (count r))))

(defn avgcolor 
  "Take three lists of RGB triads and give an average."
  [red blue green]
  ((avgonecolor red) (avgonecolor blue) (avgonecolor green))
  )

;; See how far apart colors are on a hue?
