diff out.txt ref.txt
if [ $? -eq "" ]
then
  echo "Referenční řešení v pořádku!";
else
  echo "Výsledek referenčního řešení není v pořádku!"
fi