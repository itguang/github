import requests
from bs4 import BeautifulSoup
res=  requests.get('http://www.runoob.com/')
res.encoding = 'utf-8'
print(res.text)
soup = BeautifulSoup(res.text."html.parser")
