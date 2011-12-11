PHANTOMPREFIX="/Users/jacklaxson/Downloads/phantomjs-1.3.0/"

$PHANTOMPREFIX/bin/phantomjs $PHANTOMPREFIX/examples/rasterize.js $1 $2.png

echo "$2 : $3" >> scores.txt