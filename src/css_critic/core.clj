(ns css-critic.core
  (:use css-critic.css)
  (:use com.evocomputing.colors))

; Maybe use webkit to render to image?


(def sample "body {
             color: black;
             background: #e5e5e5;
             font-family: Verdana, sans-serif;
             font-size: 12px;
             margin: 0;
             padding: 0;}")

(parse-css sample)

(def rules (get-in  (first (parse-css sample)) (list :content :declarations)))

;; Tools for Evolution to steal.

(defn getvalue [rules item]
  "Vector of fontsizes."
  (map #(get-in % (list :content :value :content)) 
       (filter #(if (= item (get-in % (list :content :property :content))) 
                  true) rules)))



;;Font sizes
;;Colors defined

;;Actually used CSS v. Defined?

;;map down a filter checking get-in :content... has 

;;<gfredericks> &(let [m {:foo 12 :bar 14 :baz 14}] (filter #(= 14 (m %)) (keys m)))
;;<gfredericks> another thing you might find useful: ##(let [m {:foo 12 :bar 14 :baz 14}] (group-by m (keys m)))
;;<gfredericks> you pass it a key and it gives you a value: ##({:foo 'bar} :foo)

;;http://clojuredocs.org/clojure_core/clojure.java.shell/sh


;; Color utilities
;; To average an area dump its contents into an array then process the array into lists of r,g ;;and b values. http://processing.org/reference/loadPixels_.html

(create-color (str "#" (first (getvalue rules "background"))))

(defn avgonecolor [r] 
  (int (/ (apply + r) (count r))))

(defn avgcolor 
  "Take three lists of RGB triads and give an average."
  [red blue green]
  ((avgonecolor red) (avgonecolor blue) (avgonecolor green))
  )


(defn distance-hsl [color1 color2]
  "See how far apart colors are on a hue"
  (let [hue1 (first (get color1 :hsl)) hue2 (first (get color2 :hsl))]
    ;; hue 0, 360
    ))
